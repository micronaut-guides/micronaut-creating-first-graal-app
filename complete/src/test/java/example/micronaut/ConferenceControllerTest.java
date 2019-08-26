package example.micronaut;

import io.micronaut.context.ApplicationContext;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.runtime.server.EmbeddedServer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ConferenceControllerTest {

    private static EmbeddedServer server;
    private static HttpClient client;

    @BeforeAll
    public static void setupServer() {
        server = ApplicationContext.run(EmbeddedServer.class); // <1>
        client = server.getApplicationContext().createBean(HttpClient.class, server.getURL()); // <2>
    }

    @AfterAll
    public static void stopServer() {
        if (server != null) {
            server.stop();
        }
        if (client != null) {
            client.stop();
        }
    }

    @Test
    public void testHello() throws Exception {
        HttpRequest request = HttpRequest.GET("/conferences/random");
        String body = client.toBlocking().retrieve(request); // <3>
        assertNotNull(body);
    }
}
