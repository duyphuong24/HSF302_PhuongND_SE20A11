package phuongnd.fudn.chapter1_exercise1.repository;

import phuongnd.fudn.chapter1_exercise1.dao.StudentDAO;
import phuongnd.fudn.chapter1_exercise1.pojo.Student;

import java.util.List;
import java.util.Optional;

public class StudentRepositoryimpl implements StudentRepository {

    private final StudentDAO studentDAO;

    public StudentRepositoryimpl() {
        this.studentDAO = new StudentDAO();
    }

    public StudentRepositoryimpl(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Override
    public Student save(Student student) {
        studentDAO.save(student);
        return student;
    }

    @Override
    public Optional<Student> findById(Long id) {
        return Optional.ofNullable(studentDAO.findById(id));
    }

    @Override
    public List<Student> findAll() {
        return studentDAO.findAll();
    }

    @Override
    public Student update(Student student) {
        studentDAO.update(student);
        return student;
    }

    @Override
    public void deleteById(Long id) {
        studentDAO.delete(id);
    }
}
