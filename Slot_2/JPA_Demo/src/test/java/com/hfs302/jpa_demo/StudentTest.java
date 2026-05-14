package com.hfs302.jpa_demo;

import com.hfs302.jpa_demo.entity.Student;
import com.hfs302.jpa_demo.service.StudentService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class StudentTest {

    @Autowired
    private StudentService studentService;

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    public void testFullCRUDOperations() {
        // 1. Test Create & Retrieve (Mô phỏng image_cbe2e1.jpg)
        studentService.createStudent("Test Student", "test@fpt.edu.vn", 25);
        entityManager.flush(); // Ép xuống DB
        entityManager.clear(); // Xóa Cache để bắt buộc find() phải truy vấn lại

        Student retrieved = studentService.findAll().get(0);
        Long targetId = retrieved.getId();

        assertNotNull(retrieved, "Student should exist in database");
        assertEquals("Test Student", retrieved.getFullName());

        // 2. Test Update
        studentService.updateStudent(targetId, "Updated Student", "updated@fpt.edu.vn", 26);
        entityManager.flush();
        entityManager.clear();

        Student updated = studentService.findById(targetId);
        assertEquals("Updated Student", updated.getFullName());
        assertEquals(26, updated.getAge());

        // 3. Test Delete
        studentService.deleteStudent(targetId);
        entityManager.flush();
        entityManager.clear();

        assertNull(studentService.findById(targetId), "Student phải bị xóa khỏi database");
    }
}