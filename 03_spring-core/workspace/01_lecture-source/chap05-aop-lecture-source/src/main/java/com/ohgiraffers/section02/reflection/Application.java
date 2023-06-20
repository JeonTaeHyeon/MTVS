package com.ohgiraffers.section02.reflection;

import java.lang.reflect.*;

public class Application {
    public static void main(String[] args) {
        Class class1 = Account.class;
        //Account가 가지고 있는 메타 정보를 전적으로 갖고있음, 한마디로 모든 내용
        System.out.println("class1 = " + class1);

        Class class2 = new Account().getClass();
        System.out.println("class2 = " + class2);

        try {
            Class class3 = Class.forName("com.ohgiraffers.section02.reflection.Account");
            System.out.println("class3 = " + class3);

            Class class4 = Class.forName("[D");
            System.out.println("class4 = " + class4);

            Class class5 = double[].class;
            System.out.println("class5 = " + class5);

            Class class6 = Class.forName("[Ljava.lang.String;");
            System.out.println("class6 = " + class6);

            Class class7 = String[].class;
            System.out.println("class7 = " + class7);

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }// class를 찾지 못할 수도 있으니까 try catch문으로 감싸주기
        // getname은 runtime에 class를 load하는 동적 loading을 지원

        Class class8 = Double.TYPE;
        System.out.println("class8 = " + class8);

        Class class9 = Void.TYPE;
        System.out.println("class9 = " + class9);


        /*
        클래스를 호출하는 4가지 방법
        1. .class
        2. getClass
        3. forName
        4. Wrapper clsss의 TYPE
         */


        Class superclass = class1.getSuperclass();
        System.out.println("superclass = " + superclass);
        //superclass 는 부모 class를 반환

        Field[] fields = Account.class.getDeclaredFields();
        System.out.println("fields = " + fields);
        //class가 가지고 있는 field에 대한 정보를 반환
        for (Field field : fields) {
            System.out.println("Modifier = " + Modifier.toString(field.getModifiers()));
            System.out.println("TYPE = " + field.getType());
            System.out.println("field.getName() = " + field.getName());
            //getModifiers는 접근제한자 반환
        }

        Constructor[] constructors = Account.class.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println("constructor.getName() = " + constructor.getName());
            Class[] params = constructor.getParameterTypes();
            for (Class param : params) {
                System.out.println("param = " + param);
            }
        }

        try {
            Account acc = (Account) constructors[0].newInstance("20", "110-223-123456", "1234", 10000);
            System.out.println("acc.getBalance() = " + acc.getBalance());
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        Method[] methods = Account.class.getMethods();
        Method getBalanceMethod = null;
        for (Method method : methods) {
            System.out.println(Modifier.toString(method.getModifiers()) + " " +
                    method.getReturnType().getSimpleName() + " " +
                    method.getName());

            if("getBalance".equals(method.getName())){
                getBalanceMethod=method;
            }
        }

        try {
            System.out.println("getBalanceMethod.invoke(constructors[2].newInstance()) = " + getBalanceMethod.invoke(constructors[2].newInstance()));


        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        }
    }

    public void method(Class class1){

    }
}
