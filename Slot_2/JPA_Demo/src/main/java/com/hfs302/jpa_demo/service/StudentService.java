package com.hfs302.jpa_demo.service;

import com.hfs302.jpa_demo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentService {

    @PersistenceContext
    private EntityManager em;

    // --- CREATE ---
    @Transactional
    public void createStudent(String name, String email, int age) {
        Student s = Student.builder()
                .fullName(name)
                .email(email)
                .age(age)
                .build();
        em.persist(s);
        System.out.println(">>> Saved with ID = " + s.getId());
    }

    // --- READ ---
    @Transactional(readOnly = true)
    public List<Student> findAll() {
        return em.createQuery("SELECT s FROM Student s", Student.class).getResultList();
    }

    @Transactional(readOnly = true)
    public Student findById(Long id) {
        return em.find(Student.class, id);
    }

    @Transactional(readOnly = true)
    public void printAll() {
        System.out.println("===== DANH SACH STUDENT =====");
        findAll().forEach(System.out::println);
    }

    // --- UPDATE ---
    @Transactional
    public void updateStudent(Long id, String name, String email, int age) {
        Student s = findById(id);
        if (s != null) {
            s.setFullName(name);
            s.setEmail(email);
            s.setAge(age);
            em.merge(s); // Đồng bộ thay đổi xuống DB
            System.out.println(">>> Updated student ID: " + id);
        }
    }

    // --- DELETE ---
    @Transactional
    public void deleteStudent(Long id) {
        Student s = findById(id);
        if (s != null) {
            em.remove(s);
            System.out.println(">>> Deleted student ID: " + id);
        }
    }
}