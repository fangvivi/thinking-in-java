package com.wayne;


import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author wayne
 */
public class Log {

    public static Logger getJavaLogger(Class<?> cl){
        String clName = cl.getName();
        Logger logger = Logger.getLogger(clName);
        return logger;
    }

    public static void info(Logger logger, String msg){
        logger.log(Level.INFO,()-> msg);
    }
}
