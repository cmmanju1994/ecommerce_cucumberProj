package utilities;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;



public class PropertiesConfig {

	private Properties p;
	   
	public PropertiesConfig() {
		p = new Properties(); 
	}
	
	public  Properties getProperties() throws IOException {
		
		FileReader file=new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
	   		
	        p=new Properties();
			p.load(file);
			return p; 
	    }


	
	    
}
