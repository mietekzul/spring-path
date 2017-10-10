package pl.raziel.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.raziel.entities.Course;
import pl.raziel.entities.Student;
import pl.raziel.repositories.CourseRepository;
import pl.raziel.repositories.StudentRepository;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/students")
    public String index(Model model) {
        List<Student> students = (List<Student>) studentRepository.findAll();
        model.addAttribute("students", students);
        return "students";
    }

    @RequestMapping(value = "add")
    public String addStudent(Model model) {
        model.addAttribute("student", new Student());
        return "addStudent";
    }

    @RequestMapping(value = "/edit/{id}")
    public String editStudent(@PathVariable("id") Long studentId, Model model) {
        model.addAttribute("student", studentRepository.findOne(studentId));
        return "editStudent";
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(Student student) {
        studentRepository.save(student);
        return "redirect:/students";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteStudent(@PathVariable("id") Long studentId, Model model) {
        studentRepository.delete(studentId);
        return "redirect:/students";
    }

    @RequestMapping(value = "addStudentCourse/{id}", method = RequestMethod.GET)
    public String addCourse(@PathVariable("id") Long studentId, Model model) {
        model.addAttribute("courses", courseRepository.findAll());
        model.addAttribute("student", studentRepository.findOne(studentId));
        return "addStudentCourse";
    }


    @RequestMapping(value = "/student/{id}/courses", method = RequestMethod.GET)
    public String studentsAddCourse(@PathVariable Long id, @RequestParam Long courseId, Model model) {
        Course course = courseRepository.findOne(courseId);
        Student student = studentRepository.findOne(id);

        if (student != null) {
            if (!student.hasCourse(course)) {
                student.getCourses().add(course);
            }
            studentRepository.save(student);
            model.addAttribute("student", courseRepository.findOne(id));
            model.addAttribute("courses", courseRepository.findAll());
            return "redirect:/students";
        }

        model.addAttribute("developers", studentRepository.findAll());
        return "redirect:/students";
    }

    @RequestMapping(value = "getstudents", method = RequestMethod.GET)
    public @ResponseBody
    List<Student> getStudents() {
        return (List<Student>) studentRepository.findAll();
    }
}