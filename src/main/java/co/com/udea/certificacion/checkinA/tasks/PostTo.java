package co.com.udea.certificacion.checkinA.tasks;


import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

import java.util.Map;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class PostTo implements Task {
    private String endpoint;
    private Map<String, String> body;

    public PostTo(String endpoint, Map<String, String> body) {
        this.endpoint = endpoint;
        this.body = body;
    }

    public static PostTo service(String endpoint, Map<String, String> body) {
        return instrumented(PostTo.class, endpoint, body);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to(endpoint)
                        .with(request -> request
                                .contentType(ContentType.JSON)
                                .body(body)
                                .relaxedHTTPSValidation()
                        )
        );
    }
}
