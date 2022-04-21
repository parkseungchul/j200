package com.psc.j215.controller.api;

import com.psc.j215.dto.DeptDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@RestController
public class RestApiController {

    @RequestMapping("/reflection.json")
    public DeptDto getDept(String level){


        try {

            String packageName = "com.psc.j216";

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
                    }
                }
            }


            Class cls2 = method.invoke(cls,packageName).getClass();
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

            // 파라미터 오브젝트화
            Class<?> clazz = Class.forName("ch.qos.logback.classic.Level");
            Field field = clazz.getField(level);
            Object logLevelObj = field.get(null);


            Logger loggerObj = LoggerFactory.getLogger(packageName);
            method2.invoke(loggerObj, logLevelObj);



            /**
            Field[] fields = cls2.getDeclaredFields();
            Field field = null;
            for(int i =0; i< fields.length; i++){
                System.out.println("-------->"+ fields[i].getName());

                if(fields[i].getName().equals("level")){
                    field = fields[i];
                }
            }
             **/
        } catch (Throwable e) {
            e.printStackTrace();

        }




        return new DeptDto();
    }
}
