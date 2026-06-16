package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	Properties prop;

	public ConfigReader() {
		try {
			FileInputStream fis = new FileInputStream(
					"D:\\AutomationWorkspace\\GMS_Automation\\src\\main\\resources\\config.properties");
			prop = new Properties();
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getURL() {
		return prop.getProperty("URL");
	}

	public String getUsername() {
		return prop.getProperty("UserName");
	}

	public String getPassword() {
		return prop.getProperty("Password");
	}
}
