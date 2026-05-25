package phuongnd.fudn.chapter1_exercise1.repository;

import phuongnd.fudn.chapter1_exercise1.pojo.Student;

import java.util.List;
import java.util.Optional;

public interface StudentRepository {
    Student save(Student student);
    Optional<Student> findById(Long id);
    List<Student> findAll();
    Student update(Student student);
    void deleteById(Long id);
}
