package com.example.j216.core;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

@Slf4j
public final class LoggerUtil {

    public static boolean setLevel(String packageName, String loglevel){
        Logger logger = LoggerFactory.getLogger(packageName);
        if(logger == null){
            log.error("No logger for the name: {}", packageName);
            return false;
        }

        try{
            Class cls = Class.forName("org.slf4j.LoggerFactory");
            Method method = cls.getDeclaredMethod("getLogger", java.lang.String.class);
            Class clz = method.invoke(cls,packageName).getClass();


            Class<?> clazz = Class.forName("ch.qos.logback.classic.Level");
            Field field = clazz.getField(loglevel);
            Object logLevelObj = field.get(null);


            Class<?>[] paramTypes =  { logger.getClass() };
            Object[]   params     =  { logLevelObj };

            method = clz.getMethod("setLevel", paramTypes);
            method.setAccessible(true);
            method.invoke(logger, params);

        }catch (Exception e){
            e.printStackTrace();
            log.error(e.getMessage());
        }



        return true;
    }
}
