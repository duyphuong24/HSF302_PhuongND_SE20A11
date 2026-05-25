package phuongnd.fudn.chapter1_exercise1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;
import phuongnd.fudn.chapter1_exercise1.pojo.Student;
import phuongnd.fudn.chapter1_exercise1.service.StudentService;
import phuongnd.fudn.chapter1_exercise1.service.StudentServiceImpl;

// Cập nhật không dùng Spring Data JPA nên loại bỏ cấu hình tự động của DataSource
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class Chapter1Exercise1Application {

    public static void main(String[] args) {

        SpringApplication.run(Chapter1Exercise1Application.class, args);
        StudentService studentService = new StudentServiceImpl();

        // 1) CREATE
        Student s = new Student();
        s.setEmail("traltb@fe.edu.vn");
        s.setPassword("123456");
        s.setFirstName("Tra");
        s.setLastName("LTB");
        s.setMarks(85);

        Student created = studentService.create(s);
        System.out.println("CREATE OK -> id: " + created.getId());
    }
}
