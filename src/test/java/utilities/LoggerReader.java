package utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerReader {

    private Logger logger;

    LoggerReader(){
    	
    }
    
    public Logger getLogger() {
    	logger=LogManager.getLogger(); //Log4j
		return logger; 
		
		}
    
    public void vv()
    {
    	getLogger().info("test");
    }
    
}
