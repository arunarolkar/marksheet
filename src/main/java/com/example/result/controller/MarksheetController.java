package com.example.result.controller;

import com.example.result.entity.Marksheet;
import com.example.result.entity.MarksheetDetails;
import com.example.result.entity.Student;
import com.example.result.entity.Subject;
import com.example.result.repo.MarksheetDetailsRepo;
import com.example.result.repo.MarksheetRepo;
import com.example.result.repo.StudentRepo;
import com.example.result.repo.SubjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.NullLiteral;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/marksheets/")
public class MarksheetController
{
    @Autowired
    MarksheetRepo marksheetRepo;
    @Autowired
    MarksheetDetailsRepo marksheetDetailsRepo;
    @Autowired
    StudentRepo sudentRepo;
    @Autowired
    SubjectRepo subjectRepo;

    @GetMapping("/{idStud}/")
    public String showMarksheet(@PathVariable Long idStud, Model model)
    {
        Student student = sudentRepo.getReferenceById(idStud);
        model.addAttribute("student",student);

        List<Subject> listSubject =subjectRepo.findAll();
        model.addAttribute("listSubject",listSubject);

        Marksheet marksheetSaved = marksheetRepo.findOneByIdStudent(idStud);

        if (marksheetSaved != null)
        {
            List<MarksheetDetails> listMarksheetDet = marksheetDetailsRepo.findByIdMarksheet(marksheetSaved.getId());
            model.addAttribute("ListMarksheetDet", listMarksheetDet);
            model.addAttribute("subjectRepo", subjectRepo);
        }

        return "marksheet";
    }

    @PostMapping("/save/")
    public String saveMarksheetData(@RequestParam Long idSub, @RequestParam int marks, @RequestParam Long idStud)
    {
        Marksheet marksheetSaved = marksheetRepo.findOneByIdStudent(idStud);

        if (marksheetSaved == null)
        {
            Marksheet marksheet = new Marksheet(idStud);
            marksheetSaved = marksheetRepo.save(marksheet);
        }

        MarksheetDetails marksheetDetSaved = marksheetDetailsRepo.findByIdMarksheetAndIdSubject(marksheetSaved.getId(), idSub);

        if (marksheetDetSaved == null)
        {
            MarksheetDetails marksheetDetails = new MarksheetDetails(marksheetSaved.getId(), idSub, marks);
            marksheetDetailsRepo.save(marksheetDetails);
        }
        else
        {
            marksheetDetSaved.setMarks(marks);
            marksheetDetailsRepo.save(marksheetDetSaved);
        }

        return "redirect:/admin/marksheets/" + idStud + "/";
    }

}
