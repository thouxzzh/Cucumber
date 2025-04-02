package runnerfile;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(plugin = {"pretty", "html:target/cucumber-reports/Cucumber.html"},features="src/test/resources/com/sauceDemo/sauceDemo.feature",glue="stepDefinitions")
public class runnerClass extends  AbstractTestNGCucumberTests{

}