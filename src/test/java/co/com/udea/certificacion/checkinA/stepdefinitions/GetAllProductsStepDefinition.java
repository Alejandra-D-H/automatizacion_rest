package co.com.udea.certificacion.checkinA.stepdefinitions;

import co.com.udea.certificacion.checkinA.tasks.ConnectTo;
import co.com.udea.certificacion.checkinA.tasks.GetAllProducts;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.hamcrest.Matchers;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.Matchers.greaterThan;

public class GetAllProductsStepDefinition {

    Actor usuario = Actor.named("usuario");

    @Before
    public void config() {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("user");
    }

    @Given("I am connected as a user")
    public void iAmConnectedAsASupplier() {
        usuario.attemptsTo(ConnectTo.theService());
    }

    @When("I send a GET request to retrieve all the products")
    public void iSendAGetRequestToRetrieveAllTheProducts() {
        usuario.attemptsTo(GetAllProducts.fetch());
    }

    @Then("all the products should be shown")
    public void allTheProductsShouldBeShown() {
        usuario.should("The response contains a list of products", seeThatResponse(response -> response
                .body("size()", greaterThan(0))

        ));
    }
}
