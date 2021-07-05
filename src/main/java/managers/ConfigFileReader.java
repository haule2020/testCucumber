package managers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


//Config File Reader to get based info from Configuration.properties  file
public class ConfigFileReader {
	private Properties properties;
	private final String propertyFilePath = "configs//Configuration.properties";	
	private static ConfigFileReader configReader;
	
	 //Load  config file
	private ConfigFileReader() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}
	}
	
	//Implement Singleton Pattern
	public static ConfigFileReader getInstance( ) {
	     return (configReader == null) ? configReader = new ConfigFileReader():configReader; 
	}
	
	//Get Base Url from Configuration file
	public String getBaseUrl() {
		String baseurl = properties.getProperty("baseUrl");
		if (baseurl != null)
		{
			return baseurl;
		}
		else
		{
			throw new RuntimeException(
					"Application Url not specified in the Configuration.properties file for the Key:url");
		}
	}
	//Get token Url from Configuration file
	public String getTokenUrl() {
		String tokenUrl = properties.getProperty("tokenUrl");
		if (tokenUrl != null)
		{
			return tokenUrl;
		}
		else
		{
			throw new RuntimeException(
					"tokenUrl not specified in the Configuration.properties file for the Key:url");
		}
	}
	
	//Get token Url from Configuration file
		public String getTokenUrlPath() {
			String tokenUrlPath = properties.getProperty("tokenUrlPath");
			if (tokenUrlPath != null)
			{
				return tokenUrlPath;
			}
			else
			{
				throw new RuntimeException(
						"tokenUrlPath not specified in the Configuration.properties file for the Key:tokenUrlPath");
			}
		}

	//Get url path from Configuration file
	public String searchPath() {
		String searchPath = properties.getProperty("searchPath");
		if (searchPath != null)
		{
			return searchPath;
		}
		else
		{
			throw new RuntimeException(
					"searchPath not specified in the Configuration.properties file for the Key:searchPath");
		}
	}
	
	public String client_id() {
		String client_id = properties.getProperty("client_id");
		if (client_id != null)
		{
			return client_id;
		}
		else
		{
			throw new RuntimeException(
					"client_id not specified in the Configuration.properties file for the Key:client_id");
		}
	}
	public String client_secret() {
		String client_secret = properties.getProperty("client_secret");
		if (client_secret != null)
		{
			return client_secret;
		}
		else
		{
			throw new RuntimeException(
					"client_secret not specified in the Configuration.properties file for the Key:client_secret");
		}
	}
	public String grant_type() {
		String grant_type = properties.getProperty("grant_type");
		if (grant_type != null)
		{
			return grant_type;
		}
		else
		{
			throw new RuntimeException(
					"grant_type not specified in the Configuration.properties file for the Key:grant_type");
		}
	}

}