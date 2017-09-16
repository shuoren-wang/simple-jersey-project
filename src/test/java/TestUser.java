import static com.jayway.restassured.RestAssured.given;
import static org.junit.Assert.fail;

import application.Application;
import com.jayway.restassured.response.Response;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.grizzly.http.util.HttpStatus;
import org.junit.*;

import java.io.IOException;

public class TestUser {
    private static HttpServer testServer;

    @BeforeClass
    public static void setup() throws Exception {
        System.out.println("Starting server to run tests...");

        testServer = Application.startServer();

        try {
            testServer.start();
        } catch (IOException e){
            System.out.println("Failed to start server for tests.");
            Assert.fail();
        }

        System.out.println("Server started.");
    }


    @AfterClass
    public static void tearDown(){
        System.out.println("Stopping server . . .");
        testServer.shutdownNow();
    }

    @Test
    public void testUserOk() {
        int expectId = 1;
        String expectName = "user_1";
        String url = Application.BASE_URL + "/user/" + expectId + "/info";

        Response response = given().
                when().
                    get(url).
                then().
                    assertThat().statusCode(HttpStatus.OK_200.getStatusCode()).
                    extract().response();

        if (response == null) {
            fail("No user info found");
        }

        int id = response.path("id");
        Assert.assertEquals(id, expectId);

        String name = response.path("name");
        Assert.assertEquals(expectName, name);
    }


    @Test
    public void testUserNoContent() {
        int id = 999;
        String url = Application.BASE_URL + "/user/" + id + "/info";

        given().
            when().
        get(url).
            then().
        assertThat().statusCode(HttpStatus.NO_CONTENT_204.getStatusCode());
    }
}
