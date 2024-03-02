package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		// features={"src/test/Feature Files"},
		// features="/Ecommerce/Feature
		// Files/SearchProduct.feature/AddProductInCart.feature",
		// features=
		// {".//Features/SearchProduct.feature",".//Features/AddProductInCart.feature"},
		// features={".//Feature Files/NopCommerce_Registration.feature",".//Feature
		// Files/NopCommerce_Login.feature"},
		tags="@dummy",
		features = { "src/test/resources/FeatureFiles/" },
        
		glue = "stepDefinition", plugin = { "pretty", "html:reports/myreport.html", "rerun:target/rerun.txt", "json:target/cucmber-report.json",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }, dryRun = false, monochrome = true, publish = true // to
																																			// publish
																																			// report
																																			// in
																																			// cucumber
																																			// serve

)

public class TestRunner {

}
