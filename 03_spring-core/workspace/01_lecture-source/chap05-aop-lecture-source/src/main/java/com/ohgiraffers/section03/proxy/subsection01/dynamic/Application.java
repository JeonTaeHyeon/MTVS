package com.ohgiraffers.section03.proxy.subsection01.dynamic;
import aj.org.objectweb.asm.Handle;
import com.ohgiraffers.section03.proxy.common.OhgiraffersStudent;
import com.ohgiraffers.section03.proxy.common.Student;

import java.lang.reflect.Proxy;

public class Application {
    public static void main(String[] args) {
        Student student = new OhgiraffersStudent();
        student.study(9);

        Student proxy =
                (Student) Proxy.newProxyInstance(Student.class.getClassLoader(),new Class[]{Student.class}, new Handler(student));

        proxy.study(10);
    }
}
