package co.com.udea.certificacion.checkinA.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/get_all_products.feature",  // Ruta al archivo .feature
        glue = "co.com.udea.certificacion.checkinA.stepdefinitions",  // Paquete de las step definitions
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class GetAllProductsRunner {}
















