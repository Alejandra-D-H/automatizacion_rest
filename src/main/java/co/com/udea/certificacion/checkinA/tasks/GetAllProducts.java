package co.com.udea.certificacion.checkinA.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;


public class GetAllProducts implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {

        String url = "https://fakestoreapi.com/products";

        actor.attemptsTo(Get.resource(url).with(
                request -> request.relaxedHTTPSValidation()
                        .accept("application/json")
        ));
    }

    public static GetAllProducts fetch() {
        return Tasks.instrumented(GetAllProducts.class);
    }
}