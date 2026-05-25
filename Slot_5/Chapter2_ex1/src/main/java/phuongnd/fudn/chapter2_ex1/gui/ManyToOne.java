package phuongnd.fudn.chapter2_ex1.gui;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import phuongnd.fudn.chapter2_ex1.configs.AppConfig;
import phuongnd.fudn.chapter2_ex1.pojos.Student;
import phuongnd.fudn.chapter2_ex1.services.StudentService;

public class ManyToOne {

    public static void main(String[] args) {

        // TODO Auto-generated method stub

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        StudentService myService = context.getBean(StudentService.class);

        Student st = new Student("Lam", "Nguyen", 8);

        myService.Save(st);
    }
}
