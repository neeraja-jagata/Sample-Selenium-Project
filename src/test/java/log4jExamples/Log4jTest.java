package log4jExamples;

import java.util.Date;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log4jTest {
	public static Logger log= Logger.getLogger(Log4jTest.class);
	
	public static void main(String[] args) {
		
		PropertyConfigurator.configure("./src/test/resources/properties/log4j.properties");
		
		System.out.println("logging");
		log.info("Info log");
		log.debug("Debug log");
		log.error("error log");
		
	}

}


