/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package distsys.smart_healthcare;

import auth.AuthServiceGrpc;
import auth.AuthServiceOuterClass.LoginRequest;
import auth.AuthServiceOuterClass.LoginResponse;
import io.grpc.stub.StreamObserver;

/**
 *
 * @author vinicius
 */
public class AuthServiceImpl extends AuthServiceGrpc.AuthServiceImplBase {
    @Override
    public void login(LoginRequest request, StreamObserver<LoginResponse> responseObserver) {
        String username = request.getUsername();
        String password = request.getPassword();

        // Replace with actual validation (e.g., DB check)
        if (username.equals("doctor123") && password.equals("mypassword")) {
            String token = JwtUtil.generateToken(username);
            LoginResponse response = LoginResponse.newBuilder().setToken(token).build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } else {
            responseObserver.onError(io.grpc.Status.UNAUTHENTICATED.withDescription("Invalid credentials").asRuntimeException());
        }
    }
}
