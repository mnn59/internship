package ir.asta.training.greeting.service;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.equalTo;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GreetingServiceIntegrationTest {
    @LocalServerPort
    private int port;

    private static Client client = ClientBuilder.newClient();

    @Test
    public void testGreetingMessage_UserHasNullValueAndHonorificHasNullValue_ShouldShowProperMessage() {
        String responseString = client.target("http://localhost:" + port + "/api/greeting/")
                .path("hello")
                .queryParam("user", null)
                .queryParam("honorific", null)
                .request(MediaType.TEXT_PLAIN)
                .get(String.class);
        assertThat(responseString, is(equalTo("Hello dear User!")));
    }


    @Test
    public void testGreetingMessage_UserHasEmptyValueAndHonorificHasNullValue_ShouldShowProperMessage() {
        String responseString = client.target("http://localhost:" + port + "/api/greeting/")
                .path("hello")
                .queryParam("user", "")
                .queryParam("honorific", null)
                .request(MediaType.TEXT_PLAIN)
                .get(String.class);
        assertThat(responseString, is(equalTo("Hello dear User!")));
    }

    @Test
    public void testGreetingMessage_UserHasSpaceValueAndHonorificHasNullValue_ShouldShowProperMessage() {
        String responseString = client.target("http://localhost:" + port + "/api/greeting/")
                .path("hello")
                .queryParam("user", " ")
                .queryParam("honorific", null)
                .request(MediaType.TEXT_PLAIN)
                .get(String.class);
        assertThat(responseString, is(equalTo("Hello dear User!")));
    }


    @Test
    public void testGreetingMessage_UserHasValidValueAndHonorificHasNullValue_ShouldShowProperMessage() {
        String responseString = client.target("http://localhost:" + port + "/api/greeting/")
                .path("hello")
                .queryParam("user", "Ahmad")
                .queryParam("honorific", null)
                .request(MediaType.TEXT_PLAIN)
                .get(String.class);
        assertThat(responseString, is(equalTo("Hello dear Ahmad!")));
    }


    @Test
    public void testGreetingMessage_UserHasNullValueAndHonorificHasEmptyValue_ShouldShowProperMessage() {
        String responseString = client.target("http://localhost:" + port + "/api/greeting/")
                .path("hello")
                .queryParam("user", null)
                .queryParam("honorific", "")
                .request(MediaType.TEXT_PLAIN)
                .get(String.class);
        assertThat(responseString, is(equalTo("Hello dear User!")));
    }


    @Test
    public void testGreetingMessage_UserHasEmptyValueAndHonorificHasEmptyValue_ShouldShowProperMessage() {
        String responseString = client.target("http://localhost:" + port + "/api/greeting/")
                .path("hello")
                .queryParam("user", "")
                .queryParam("honorific", "")
                .request(MediaType.TEXT_PLAIN)
                .get(String.class);
        assertThat(responseString, is(equalTo("Hello dear User!")));
    }

    @Test
    public void testGreetingMessage_UserHasSpaceValueAndHonorificHasEmptyValue_ShouldShowProperMessage() {
        String responseString = client.target("http://localhost:" + port + "/api/greeting/")
                .path("hello")
                .queryParam("user", " ")
                .queryParam("honorific", "")
                .request(MediaType.TEXT_PLAIN)
                .get(String.class);
        assertThat(responseString, is(equalTo("Hello dear User!")));
    }


    @Test
    public void testGreetingMessage_UserHasValidValueAndHonorificHasEmptyValue_ShouldShowProperMessage() {
        String responseString = client.target("http://localhost:" + port + "/api/greeting/")
                .path("hello")
                .queryParam("user", "Ahmad")
                .queryParam("honorific", "")
                .request(MediaType.TEXT_PLAIN)
                .get(String.class);
        assertThat(responseString, is(equalTo("Hello dear Ahmad!")));
    }


    @Test
    public void testGreetingMessage_UserHasNullValueAndHonorificHasSpaceValue_ShouldShowProperMessage() {
        String responseString = client.target("http://localhost:" + port + "/api/greeting/")
                .path("hello")
                .queryParam("user", null)
                .queryParam("honorific", " ")
                .request(MediaType.TEXT_PLAIN)
                .get(String.class);
        assertThat(responseString, is(equalTo("Hello dear User!")));
    }


    @Test
    public void testGreetingMessage_UserHasEmptyValueAndHonorificHasSpaceValue_ShouldShowProperMessage() {
        String responseString = client.target("http://localhost:" + port + "/api/greeting/")
                .path("hello")
                .queryParam("user", "")
                .queryParam("honorific", " ")
                .request(MediaType.TEXT_PLAIN)
                .get(String.class);
        assertThat(responseString, is(equalTo("Hello dear User!")));
    }


    @Test
    public void testGreetingMessage_UserHasSpaceValueAndHonorificHasSpaceValue_ShouldShowProperMessage() {
        String responseString = client.target("http://localhost:" + port + "/api/greeting/")
                .path("hello")
                .queryParam("user", " ")
                .queryParam("honorific", " ")
                .request(MediaType.TEXT_PLAIN)
                .get(String.class);
        assertThat(responseString, is(equalTo("Hello dear User!")));
    }


    @Test
    public void testGreetingMessage_UserHasValidValueAndHonorificHasSpaceValue_ShouldShowProperMessage() {
        String responseString = client.target("http://localhost:" + port + "/api/greeting/")
                .path("hello")
                .queryParam("user", "Ahmad")
                .queryParam("honorific", " ")
                .request(MediaType.TEXT_PLAIN)
                .get(String.class);
        assertThat(responseString, is(equalTo("Hello dear Ahmad!")));
    }


    @Test
    public void testGreetingMessage_UserHasNullValueAndHonorificHasValidValue_ShouldShowProperMessage() {
        String responseString = client.target("http://localhost:" + port + "/api/greeting/")
                .path("hello")
                .queryParam("user", null)
                .queryParam("honorific", "Mr")
                .request(MediaType.TEXT_PLAIN)
                .get(String.class);
        assertThat(responseString, is(equalTo("Hello Mr User!")));
    }


    @Test
    public void testGreetingMessage_UserHasEmptyValueAndHonorificHasValidValue_ShouldShowProperMessage() {
        String responseString = client.target("http://localhost:" + port + "/api/greeting/")
                .path("hello")
                .queryParam("user", "")
                .queryParam("honorific", "Mr")
                .request(MediaType.TEXT_PLAIN)
                .get(String.class);
        assertThat(responseString, is(equalTo("Hello Mr User!")));
    }


    @Test
    public void testGreetingMessage_UserHasSpaceValueAndHonorificHasValidValue_ShouldShowProperMessage() {
        String responseString = client.target("http://localhost:" + port + "/api/greeting/")
                .path("hello")
                .queryParam("user", " ")
                .queryParam("honorific", "Mr")
                .request(MediaType.TEXT_PLAIN)
                .get(String.class);
        assertThat(responseString, is(equalTo("Hello Mr User!")));
    }


    @Test
    public void testGreetingMessage_UserHasValidValueAndHonorificHasValidValue_ShouldShowProperMessage() {
        String responseString = client.target("http://localhost:" + port + "/api/greeting/")
                .path("hello")
                .queryParam("user", "Ahmad")
                .queryParam("honorific", "Mr")
                .request(MediaType.TEXT_PLAIN)
                .get(String.class);
        assertThat(responseString, is(equalTo("Hello Mr Ahmad!")));
    }

    @AfterAll
    public static void closeClient() {
        client.close();
    }

}
