package com.example.result.controller;

import com.example.result.entity.Student;
import com.example.result.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.model.IAttribute;

import java.util.List;

@Controller
@RequestMapping("/admin/students/")
public class StudentController
{
    @Autowired
    StudentRepo studentRepo;

    @GetMapping("/")
    public String showStudents(Model model)
    {
        List<Student> list = studentRepo.findAll();
        model.addAttribute("list", list);
        return "student";
    }

    @PostMapping("/save/")
    public String saveStudent(Student student)
    {
        studentRepo.save(student);
        return "redirect:/admin/students/";
    }

    @GetMapping("/delete/{id}/")
    public String deleteStudents(@PathVariable Long id)
    {
        studentRepo.deleteById(id);
        return "redirect:/admin/students/";
    }


}
