package practice.DataDrivenTeting;

import org.testng.annotations.Test;

public class ReadRunTimeParameterTest {
	@Test
	public void runtimeParametertest() {
		String URL=System.getProperty("url");
		String BROWSER=System.getProperty("browser");
		String USERNAME=System.getProperty("username");
		String PASSWORD=System.getProperty("password");

		System.out.println("Env Data==>URL ==>"+URL);
		System.out.println("Browser Data==>URL ==>"+BROWSER);
		System.out.println("Username Data==>URL ==>"+USERNAME);
		System.out.println("Password Data==>URL ==>"+PASSWORD);

	}

}
