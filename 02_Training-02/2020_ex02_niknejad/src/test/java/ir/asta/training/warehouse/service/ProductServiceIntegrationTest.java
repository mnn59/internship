package ir.asta.training.warehouse.service;

import ir.asta.training.warehouse.dto.ProductDto;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductServiceIntegrationTest {
    @LocalServerPort
    private int port;

    private static Client client;

    @BeforeAll
    public static void createClient() {
        client = ClientBuilder.newClient();
    }

    @Test
    public void testSavingProductWithValidSerialResults204() {
        ProductDto productDto = ProductDto.builder()
                .title("Book")
                .serial(98123456L)
                .build();
        Response response = client.target("http://localhost:" + port + "/warehouse/api")
                .path("product")
                .request()
                .post(Entity.json(productDto));
        assertThat(response.getStatus(), is(equalTo(Response.Status.NO_CONTENT.getStatusCode())));
    }

    @Test
    public void testSavingProductWithInValidSerialResults500() {
        ProductDto productDto = ProductDto.builder()
                .title("Book")
                .serial(1234L)
                .build();
        Response response = client.target("http://localhost:" + port + "/warehouse/api")
                .path("product")
                .request()
                .post(Entity.json(productDto));
        assertThat(response.getStatus(), is(equalTo(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode())));
    }

    @AfterAll
    public static void closeClient() {
        client.close();
    }
}
