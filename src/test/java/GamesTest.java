import api.Application;
import api.services.GameService;
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
public class GamesTest {

    @LocalServerPort
    private int port;

    TestRestTemplate restTemplate = new TestRestTemplate();

    HttpHeaders headers = new HttpHeaders();

    @Test
    public void testRetrieveGame() throws JSONException {

        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/api/game/all"),
                HttpMethod.GET, entity, String.class);

        String expected = "[{\"id\":1,\"title\":\"League of Legends\",\"summary\":\"League of Legends is a fast-paced, competitive online game that blends the speed and intensity of an RTS with RPG elements.\",\"price\":0.0,\"releaseDate\":null,\"rating\":4,\"imageLink\":\"https://vignette.wikia.nocookie.net/leagueoflegends/images/7/7f/LoL_Battle_13.jpg/revision/latest?cb=20180515174205\",\"developer\":{\"id\":1,\"name\":\"Riot Games\",\"address\":\"Los Angeles\",\"numEmployees\":2500,\"dateFounded\":\"2006-08-31\"},\"genre\":{\"id\":6,\"name\":\"Strategy\"}}]";

        JSONAssert.assertEquals(expected, response.getBody(), false);
    }

    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }
}
