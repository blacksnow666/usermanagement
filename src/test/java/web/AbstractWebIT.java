package web;

import org.junit.Before;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

@ContextConfiguration({ "classpath:selenium-context.xml" })
public abstract class AbstractWebIT extends AbstractJUnit4SpringContextTests {
	@Autowired
	protected WebDriver webDriver;

	protected final String APPLICATION_PREFIX = "http://localhost:58080";
	protected final int WINDOW_WIDTH = 1600;

	@Before
	public void setUp() {
		final Window window = webDriver.manage().window();
		window.maximize();
		final Dimension d = window.getSize();
		final Dimension dimension = new Dimension(WINDOW_WIDTH, d.getHeight());
		window.setSize(dimension);
	}
}
