package example.spring.bootapp.controller;

import com.jayway.restassured.response.Header;
import example.spring.bootapp.IntegrationTestBase;
import org.junit.Assert;
import org.junit.Test;
import static com.jayway.restassured.RestAssured.*;

public class IT_HelloGreetingApiIntegrationTest extends IntegrationTestBase
{
    @Test
    public void integrationTestHelloGreeting()
    {
        System.out.println("Integration test chander");
        testUrl = getURLFromString("http://" + hostName + ":" + tomcatPort  + "/hello");
        System.out.println("Integration test testUrl" + testUrl);

        String greetingMessage = with().header(new Header("Content-Type", "application/json; charset=UTF-8"))
                .expect().log().all()
                .when().get(testUrl.toString())
                .then().statusCode(200)
                .extract().path("greeting");
                

        Assert.assertEquals(greetingMessage, "Hello Greeting!!");
    }
}
