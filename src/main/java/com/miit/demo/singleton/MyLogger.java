package com.miit.demo.singleton;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MyLogger {
    private static final Logger logger = LogManager.getLogger(MyLogger.class);

    private static final MyLogger instance = new MyLogger();

    private MyLogger() {
    }

    public static MyLogger getInstance() {
        return instance;
    }

    public Logger getLogger() {
        return logger;
    }
}
