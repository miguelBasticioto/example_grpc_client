import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GRPCClient {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090).usePlaintext().build();

        //Sincrono
        UserGrpc.UserBlockingStub userStub = UserGrpc.newBlockingStub(channel);

        UserOuterClass.LoginRequest loginRequest = UserOuterClass.LoginRequest
            .newBuilder()
            .setUsername("Hello")
            .setPassword("Hello")
            .build();

        UserOuterClass.APIResponse response = userStub.login(loginRequest);

        System.out.println(response.getResponseMessage());

    }
}
