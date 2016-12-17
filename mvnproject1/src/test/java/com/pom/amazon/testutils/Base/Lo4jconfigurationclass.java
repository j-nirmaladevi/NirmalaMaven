package com.pom.amazon.testutils.Base;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class Lo4jconfigurationclass {
	   
	//public final Logger logger = Logger.getLogger(getClass().getSimpleName());
	
	public static Logger Log = Logger.getLogger(Lo4jconfigurationclass.class);
	 
	/* public static void main(String[] args)
	    {
	        //DOMConfigurator is used to configure logger from xml configuration file
	       
	 
	        //Log in console in and log file
	      //  logger.info("Log4j appender configuration is successful !!");
	    }
*/
	 
	 
public static void config()
{
	// DOMConfigurator.configure("log4j.xml");
}
	 
	 
	// Need to create these methods, so that they can be called  

	 public static void info(String message) {

			Log.info(message);

			}

	 public static void warn(String message) {

	    Log.warn(message);

		}

	 public static void error(String message) {

	    Log.error(message);

		}

	 public static void fatal(String message) {

	    Log.fatal(message);

		}

	 public static void debug(String message) {

	    Log.debug(message);

		}

}