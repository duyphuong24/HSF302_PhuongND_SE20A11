package phuongnd.fudn.chapter2_ex1.services;

import org.springframework.stereotype.Service;
import phuongnd.fudn.chapter2_ex1.pojos.Student;

@Service
public class StudentServiceImpl implements StudentService {
    @Override
    public void Save(Student student) {
        System.out.println("Save Student: "+student.getFirstName()+" "+student.getLastName());
    }
}
