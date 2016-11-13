package com.company;

import java.lang.reflect.Method;

/**
 * Created by Jan Nachtigal on 11/13/2016.
 */
public class MethodController
{
    public  <E>  void getReturnMetod (Long number, Class<E> nClass,String methodName) throws ClassNotFoundException {

        Class myClass = Class.forName(nClass.getName());
        Method[] methods = myClass.getMethods();

        for (Method method : methods) {
            if (method.getName().startsWith(methodName)) ;
        }


    }
}
