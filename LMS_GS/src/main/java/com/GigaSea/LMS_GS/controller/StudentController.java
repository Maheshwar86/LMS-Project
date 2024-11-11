package com.GigaSea.LMS_GS.controller;
import com.GigaSea.LMS_GS.model.Student;
import com.GigaSea.LMS_GS.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;
    @GetMapping("/students")
    public String students(Model model){
        model.addAttribute("students", studentService.findStudents());
        return "students"; // HTML File
    }
    @PostMapping("/saveStudent")
    public String saveStudent(@ModelAttribute("student")Student student){
        studentService.saveStudent(student);
        return "redirect:/students";
    }
    @GetMapping("/registerStudent")
    public String registerStudent(Model model){
        Student student = new Student();
        model.addAttribute("student", student);
        return "registerStudent";
    }
    @GetMapping("/updateStudent/{id}")
    public String updateStudent(Model model, @PathVariable Long id){
        Student student = studentService.getStudentId(id);
        model.addAttribute("student",student);
        return "updateFormStudent";
    }
    @GetMapping("/deleteStudent/{id}")
    public String deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
        return "redirect:/students";
    }


}
