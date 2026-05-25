package phuongnd.fudn.chapter1_exercise1.service;


import phuongnd.fudn.chapter1_exercise1.pojo.Student;
import java.util.List;
import java.util.Optional;

public interface StudentService {

    Student create(Student student);

    // Lấy thông tin sinh viên theo ID (trả về Optional để tránh lỗi NullPointerException)
    Optional<Student> getById(Long id);


    List<Student> getAll();


    Student update(Student student);


    void deleteById(Long id);
}