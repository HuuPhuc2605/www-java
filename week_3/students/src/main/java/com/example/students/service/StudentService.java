package com.example.students.service;

import com.example.students.model.Student;
import com.example.students.model.Subject;
import com.example.students.repository.StudentRepository;
import com.example.students.repository.SubjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepo;
    private final SubjectRepository subjectRepo;

    public StudentService(StudentRepository studentRepo, SubjectRepository subjectRepo) {
        this.studentRepo = studentRepo;
        this.subjectRepo = subjectRepo;
    }

    // Danh sách sinh viên
    public List<Student> findAll() {
        return studentRepo.findAll();
    }

    // Lưu sinh viên + môn học
    public void save(Student student, List<Long> subjectIds) {

        if (subjectIds != null && !subjectIds.isEmpty()) {
            List<Subject> subjects = subjectRepo.findAllById(subjectIds);
            student.setSubjects(subjects);
        }

        studentRepo.save(student);
    }
}
