package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions( 
		          //features={"src/test/Feature Files"},
		         //features="/Ecommerce/Feature Files/SearchProduct.feature/AddProductInCart.feature",
		          //features= {".//Features/SearchProduct.feature",".//Features/AddProductInCart.feature"},
		           //features={".//Feature Files/NopCommerce_Registration.feature",".//Feature Files/NopCommerce_Login.feature"},
		
		features= {".//Feature Files/"},    
		
		
		
		
		          glue="stepDefinition",
		          plugin={"pretty", "html:reports/myreport.html", 
						  "rerun:target/rerun.txt",
						  "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
						},
		          dryRun=false,
		          monochrome=true,
		        		  publish=true   // to publish report in cucumber server
							//tags="@sanity"  // this will execute scenarios tagged with @sanity
							//tags="@regression"
							//tags="@sanity and @regression" //Scenarios tagged with both @sanity and @regression
							//tags="@sanity and not @regression" //Scenarios tagged with @sanity but not tagged with @regression
							//tags="@sanity or @regression" //Scenarios tagged with either @sanity or @regression
		
		
		
		
		
		
		)

public class TestRunner {

}
