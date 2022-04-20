package com.psc.j215.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.MessageFormat;

public final class LogbackUtils
{
    public  static final String LOGBACK_CLASSIC        = "ch.qos.logback.classic";
    public  static final String LOGBACK_CLASSIC_LOGGER = "ch.qos.logback.classic.Logger";
    public  static final String LOGBACK_CLASSIC_LEVEL  = "ch.qos.logback.classic.Level";
    private static final Logger logger                 = LoggerFactory.getLogger(LogbackUtils.class);

    private LogbackUtils()
    {
        // Prevent instance creation
    }

    /**
     * Dynamically sets the logback log level for the given class to the specified level.
     *
     * @param loggerName Name of the logger to set its log level. If blank, root logger will be used.
     * @param logLevel   One of the supported log levels: TRACE, DEBUG, INFO, WARN, ERROR, FATAL,
     *                      OFF. {@code null} value is considered as 'OFF'.
     */
    public static boolean setLogLevel(String loggerName, String logLevel)
    {
        String logLevelUpper = (logLevel == null) ? "OFF" : logLevel.toUpperCase();

        try
        {
            Package logbackPackage = Package.getPackage(LOGBACK_CLASSIC);
            if (logbackPackage == null)
            {
                logger.info("Logback is not in the classpath!");
                return false;
            }

            // Use ROOT logger if given logger name is blank.
            if ((loggerName == null) || loggerName.trim().isEmpty())
            {
                loggerName = (String) getFieldVaulue(LOGBACK_CLASSIC_LOGGER, "ROOT_LOGGER_NAME");
            }

            // Obtain logger by the name
            Logger loggerObtained = LoggerFactory.getLogger(loggerName);
            if (loggerObtained == null)
            {
                // I don't know if this case occurs
                logger.warn("No logger for the name: {}", loggerName);
                return false;
            }

            Object logLevelObj = getFieldVaulue(LOGBACK_CLASSIC_LEVEL, logLevelUpper);
            if (logLevelObj == null)
            {
                logger.warn("No such log level: {}", logLevelUpper);
                return false;
            }

            Class<?>[] paramTypes =  { logLevelObj.getClass() };

            Object[]   params     =  { logLevelObj };




            Class cls = Class.forName("org.slf4j.LoggerFactory");
            Method m[] = cls.getDeclaredMethods();
            Method method = null;
            for (int i = 0; i < m.length; i++){
                String methodName;
                String paraType;
                if(m[i].getParameterCount() == 1){
                    methodName = m[i].getName();
                    paraType = m[i].getParameters()[0].getType().getName();
                    System.out.println("-> " + methodName);
                    System.out.println("-> " + paraType);
                    if(methodName.equals("getLogger") && paraType.equals("java.lang.String")){
                        System.out.println("OK");
                        method = m[i];
                        break;
                    }
                }
            }




            Class clz = method.invoke(cls,"com.psc.j216").getClass();

            //Class<?> clz    = Class.forName(LOGBACK_CLASSIC_LOGGER);






            method = clz.getMethod("setLevel", paramTypes);
            method.setAccessible(true);
            method.invoke(loggerObtained, params);

            logger.debug("Log level set to {} for the logger '{}'", logLevelUpper, loggerName);
            return true;
        }
        catch (Exception e)
        {
            logger.warn("Couldn't set log level to {} for the logger '{}'", logLevelUpper, loggerName, e);
            return false;
        }
    }

    private static Object getFieldVaulue(String fullClassName, String fieldName)
    {
        try
        {
            Class<?> clazz = Class.forName(fullClassName);
            Field field = clazz.getField(fieldName);
            return field.get(null);
        }
        catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | NoSuchFieldException |
                SecurityException ignored)
        {
            return null;
        }
    }
}