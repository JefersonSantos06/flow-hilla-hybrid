package com.example.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface Loggable {

    default Logger getLogger() {
        return LoggerFactory.getLogger(getClass());
    }

    static Logger getLogger(final Class<?> clazz) {
        return LoggerFactory.getLogger(clazz);
    }
}