package com.example.j216.core;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@Slf4j
public final class LoggerUtil {

    public static boolean setLevel(String packageName, String loglevel){
        Logger loggerObj = LoggerFactory.getLogger(packageName);
        if(loggerObj == null){
            log.error("No logger for the name: {}", packageName);
            return false;
        }

        try{
            Class cls = Class.forName("org.slf4j.LoggerFactory");
            Method method = cls.getDeclaredMethod("getLogger", java.lang.String.class);
            Class clz = method.invoke(cls,packageName).getClass();

            // 비정상적 로그 레벨이거나 오타!!
            Class<?> clazz = Class.forName("ch.qos.logback.classic.Level");
            Field field = null;
            try{
                field = clazz.getField(loglevel);
            }catch (NoSuchFieldException e){
                log.error("No log level for the name: {}", loglevel);
                return false;
            }

            Object logLevelObj = field.get(null);
            Class<?>[] paramTypes =  { logLevelObj.getClass() };
            Object[]   params     =  { logLevelObj };

            method = clz.getMethod("setLevel", paramTypes);
            method.setAccessible(true);
            method.invoke(loggerObj, params);

        }catch (Exception e){
            e.printStackTrace();
            log.error(e.getMessage());
            return false;
        }

        log.debug("success package:{}, log level {}",packageName,loglevel);
        return true;
    }
}
