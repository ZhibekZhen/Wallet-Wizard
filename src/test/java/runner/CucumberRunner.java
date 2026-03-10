package runner;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.core.options.Constants.*;

@Suite
@SelectClasspathResource("features")  // the path to your feature files
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "steps")  // the path to step definitions
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty, html:target/cucumber-report.html")  // tells cucumber where to put report
@ConfigurationParameter(key = FILTER_TAGS_PROPERTY_NAME, value = "@regression")
@ConfigurationParameter(key = EXECUTION_DRY_RUN_PROPERTY_NAME, value = "true")
public class CucumberRunner {
}