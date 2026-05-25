package phuongnd.fudn.chapter1_exercise2.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import phuongnd.fudn.chapter1_exercise2.pojo.Student;


import java.util.List;

public class StudentDAO {

    private static final String PERSISTENCE_UNIT_NAME = "hsf302-chapter1";
    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

    // ====================== CREATE ======================
    public void save(Student student) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(student);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }
    // ====================== READ ========================
    public Student findById(Long id) {
        EntityManager em = emf.createEntityManager();
        Student student = em.find(Student.class, id);
        em.close();
        return student;
    }
    public List<Student> findAll() {
        EntityManager em = emf.createEntityManager();
        List<Student> students = em.createNamedQuery("Student.findAll", Student.class).getResultList();
        em.close();
        return students;
    }
    // ====================== UPDATE ======================
    public void update(Student student){
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Student existingStudent = em.find(Student.class, student.getId());
            if(existingStudent != null){
                existingStudent.setMarks(student.getMarks());
                existingStudent.setEmail(student.getEmail());
                existingStudent.setFirstName(student.getFirstName());
                existingStudent.setLastName(student.getLastName());
                existingStudent.setPassword(student.getPassword());
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }

    // ====================== DELETE ======================
    public void delete(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Student student = em.find(Student.class, id);
            if (student != null) {
                em.remove(student);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }

    // ==================== CLOSE ====================
    public static void close() {
        if (emf.isOpen()) {
            emf.close();
        }
    }
}