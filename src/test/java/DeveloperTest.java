import api.Application;
import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DeveloperTest {

    @LocalServerPort
    private int port;

    TestRestTemplate restTemplate = new TestRestTemplate();
    HttpHeaders headers = new HttpHeaders();
    private static int FIRST_ELEMENT = 0;

    @Test
    public void testRetrieveDevelopers() throws JSONException {

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/api/developer/all"),
                HttpMethod.GET, entity, String.class);

        String expected = "[{\"address\":\"Los Angeles\"," +
                "\"numEmployees\":2500," +
                "\"dateFounded\":\"2006-08-31\"," +
                "\"name\":\"Riot Games\"," +
                "\"id\":1},{" +
                "\"address\":\"Californië\"," +
                "\"numEmployees\":4700," +
                "\"dateFounded\":\"1991-02-08\"," +
                "\"name\":\"Blizzard Entertainment\"," +
                "\"id\":2}]";

        JSONAssert.assertEquals(expected, response.getBody(), false);
    }

    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }
}

