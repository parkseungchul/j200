package com.psc.j215.controller.api;

import ch.qos.logback.classic.Level;
import com.psc.j215.core.LogbackUtils;
import com.psc.j215.dto.DeptDto;


import org.apache.logging.log4j.LogManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Field;
import java.lang.reflect.Method;



@RestController
public class RestApiController {

    @RequestMapping("/inject.json")
    public DeptDto getDept(String level){


        try {
/**
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




            Class cls2 = method.invoke(cls,"com.psc.j216").getClass();
            Method m2[] = cls2.getDeclaredMethods();
            Method method2 = null;
            for (int i = 0; i < m2.length; i++){
                String methodName;
                String paraType;

                if(m2[i].getParameterCount() == 1){
                    methodName = m2[i].getName();
                    paraType = m2[i].getParameters()[0].getType().getName();
                    System.out.println("| " + methodName + " | " + paraType);
                    if(methodName.equals("setLevel") && paraType.equals("ch.qos.logback.classic.Level")){
                        System.out.println("OK2");
                        method2 = m2[i];
                    }

                }
            }


            Field[] fields = cls2.getDeclaredFields();
            Field field = null;
            for(int i =0; i< fields.length; i++){
                System.out.println("-------->"+ fields[i].getName());

                if(fields[i].getName().equals("level")){
                    field = fields[i];

                }
            }


            //Level level = Level.toLevel("ERROR");
            //field.setAccessible(true);
            //field.set(cls2, org.apache.logging.log4j.Level.toLevel("ERROR"));




            // 변경기준 패키지명(root package name)
            //String packageName = "com.deoklab.app";

            // 변경 전 로그레벨

            //Logger loggerObtained = LoggerFactory.getLogger("com.psc.j215");


**/
            LogbackUtils.setLogLevel("com.psc.j215", level);




        } catch (Throwable e) {
            e.printStackTrace();

        }




        return new DeptDto();
    }
}
