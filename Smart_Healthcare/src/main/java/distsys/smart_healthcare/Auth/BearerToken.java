/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package distsys.smart_healthcare.Auth;

import io.grpc.CallCredentials;
import io.grpc.Metadata;
import io.grpc.Status;
import java.util.concurrent.Executor;

/**
 *
 * @author vinicius
 */
public class BearerToken extends CallCredentials {

    private String value;

    public BearerToken(String value) {
        this.value = value;
    }

    @Override
    public void applyRequestMetadata(RequestInfo requestInfo, Executor executor, MetadataApplier metadataApplier) {
        executor.execute(() -> {
            try {
                Metadata headers = new Metadata();
                headers.put(Constants.AUTHORIZATION_METADATA_KEY, String.format("%s %s", Constants.BEARER_TYPE, value));
                metadataApplier.apply(headers);
            } catch (Throwable e) {
                metadataApplier.fail(Status.UNAUTHENTICATED.withCause(e));
            }
        });
    }

    @Override
    public void thisUsesUnstableApi() {
        // noop
    }
}