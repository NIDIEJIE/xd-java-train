package org.example;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogBack {
    private static final Logger logger = LoggerFactory.getLogger(LogBack.class);
    public static void main(String[] args) {
        logger.warn("This is a warning message.");
        logger.info("This is an informational message.");
        logger.error("This is an error message.");
    }
}
