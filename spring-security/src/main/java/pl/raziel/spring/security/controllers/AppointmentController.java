package pl.raziel.spring.security.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.raziel.spring.security.repositories.AppointmentRepository;
import pl.raziel.spring.security.entities.Appointment;
import pl.raziel.spring.security.entities.AutoUser;


import java.util.List;

@Controller()
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @ModelAttribute
    public Appointment getAppointment() {
        return new Appointment();
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getAppointmentPage() {
        return "appointments";
    }

    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public List<Appointment> saveAppointment(@ModelAttribute Appointment appointment) {
        AutoUser user = new AutoUser();
        user.setEmail("test@email.com");
        user.setFirstName("Joe");
        user.setLastName("Doe");
        appointment.setUser(user);
        appointment.setStatus("Initial");
        appointmentRepository.save(appointment);
        return this.appointmentRepository.findAll();
    }

    @ResponseBody
    @RequestMapping("/all")
    public List<Appointment> getAppointments() {
        return this.appointmentRepository.findAll();
    }

    @RequestMapping("/{appointmentId}")
    public String getAppointment(@PathVariable("appointmentId") Long appointmentId, Model model) {
        Appointment appointment = appointmentRepository.findOne(appointmentId);
        model.addAttribute("appointment", appointment);
        return "appointment";
    }

}
