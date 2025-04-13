/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package distsys.smart_healthcare;

import io.grpc.*;
import io.jsonwebtoken.Claims;

/**
 *
 * @author vinicius
 */
public class AuthInterceptor implements ServerInterceptor {
    private static final Metadata.Key<String> AUTHORIZATION_KEY =
        Metadata.Key.of("Authorization", Metadata.ASCII_STRING_MARSHALLER);

    @Override
    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(
            ServerCall<ReqT, RespT> call,
            Metadata headers,
            ServerCallHandler<ReqT, RespT> next) {

        String authHeader = headers.get(AUTHORIZATION_KEY);

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            call.close(Status.UNAUTHENTICATED.withDescription("Authorization header missing"), headers);
            return new ServerCall.Listener<>() {};
        }

        String token = authHeader.substring("Bearer ".length());
        try {
            Claims claims = JwtUtil.validateToken(token);
            Context ctx = Context.current().withValue(Context.key("userId"), claims.getSubject());
            return Contexts.interceptCall(ctx, call, headers, next);
        } catch (Exception e) {
            call.close(Status.UNAUTHENTICATED.withDescription("Invalid token").withCause(e), headers);
            return new ServerCall.Listener<>() {};
        }
    }
}
