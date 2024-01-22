package com.example.result.controller;

import com.example.result.entity.Student;
import com.example.result.entity.Subject;
import com.example.result.repo.SubjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin/subjects/")
public class SubjectController
{
    @Autowired
    SubjectRepo subjectRepo;

    @GetMapping("/")
    public String showSubjects(Model model)
    {
        List<Subject> list = subjectRepo.findAll();
        model.addAttribute("list", list);
        return "subject";
    }

    @PostMapping("/save/")
    public String saveSubjects(Subject subject)
    {
        subjectRepo.save(subject);
        return "redirect:/admin/subjects/";
    }

    @GetMapping("/delete/{id}/")
    public String deleteSubjects(@PathVariable Long id)
    {
        subjectRepo.deleteById(id);
        return "redirect:/admin/subjects/";
    }
}
