package com.example.students.controller;

import com.example.students.model.Student;
import com.example.students.model.Subject;
import com.example.students.repository.SubjectRepository;
import com.example.students.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;
    private final SubjectRepository subjectRepo;

    public StudentController(StudentService studentService, SubjectRepository subjectRepo) {
        this.studentService = studentService;
        this.subjectRepo = subjectRepo;
    }

    // Trang danh sách
    @GetMapping
    public String list(Model model) {
        model.addAttribute("students", studentService.findAll());
        return "students";
    }

    // Form thêm sinh viên
    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("subjects", subjectRepo.findAll());
        return "student-form";
    }

    // Xử lý submit form
    @PostMapping("/save")
    public String saveStudent(
            @ModelAttribute Student student,
            @RequestParam(required = false, name = "subjectIds") List<Long> subjectIds
    ) {
        studentService.save(student, subjectIds);
        return "redirect:/students";
    }
}
