package com.hfs302.jpa_demo;

import com.hfs302.jpa_demo.service.StudentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpaDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(StudentService service) {
        return args -> {
            // 1. Tạo dữ liệu bằng tham số rời (Style image_cbe2db.jpg)
            service.createStudent("Nguyễn Văn A", "a@fpt.edu.vn", 20);
            service.createStudent("Trần Thị B", "b@fpt.edu.vn", 21);
            service.createStudent("Nguyễn Duy Phương", "c@fpt.edu.vn", 22);

            // 2. In danh sách ra console để kiểm tra
            service.printAll();

            // 3. Test thử tính năng tìm kiếm (Read)
            System.out.println(">>> Tìm sinh viên ID 2: " + service.findById(2L));
        };
    }
}