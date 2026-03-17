package com.example.studentapp.controller;

import com.example.studentapp.model.Student;
import com.example.studentapp.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @PostMapping
    public String addStudent(Student student) {
        service.save(student);
        return "redirect:/students/view";
    }
    @GetMapping("/view")
    public String viewPage(Model model) {
        List<Student> list = service.findAll();
        model.addAttribute("list", list != null ? list : new ArrayList<>());
        model.addAttribute("student", new Student());
        return "students";
    }
    @GetMapping("/search")
    public String searchById(@RequestParam Integer id, Model model) {

        Student student = service.findById(id);

        if (student != null) {
            model.addAttribute("list", List.of(student)); // có thì hiện 1
        } else {
            model.addAttribute("list", service.findAll()); // ❗ không có → load lại tất cả
            model.addAttribute("message", "Không tìm thấy sinh viên!");
        }

        model.addAttribute("student", new Student());

        return "students";
    }
    @PostMapping("/save")
    public String saveStudent(Student student) {

        if(student.getName() == null || student.getName().isEmpty()){
            return "redirect:/students/view";
        }

        service.save(student);
        return "redirect:/students/view";
    }
    @GetMapping
    public List<Student> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Student getById(@PathVariable Integer id) {
        return service.findById(id);
    }
}