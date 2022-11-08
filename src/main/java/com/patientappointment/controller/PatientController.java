package com.patientappointment.controller;

import com.patientappointment.Service.AppointmentService;
import com.patientappointment.controller.forms.AppointmentForm;
import com.patientappointment.model.Appointment;
import com.patientappointment.model.Patient;
import com.patientappointment.repository.AppointmentRepo;
import com.patientappointment.repository.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PatientController {
    @Autowired
    private AppointmentService appointmentService;
    @Autowired
    private PatientRepo patientRepo;
    @Autowired
    private AppointmentRepo appointmentRepo;

    @GetMapping("/showpatient")
    public ResponseEntity<List<Patient>> showPatient(){
        return ResponseEntity.ok(patientRepo.findAll());
    }

    @GetMapping("/showappointments")
    public ResponseEntity<List<Appointment>> showAppointment(){
     return ResponseEntity.ok(appointmentRepo.findAll());
    }

    @GetMapping("/patient/{id}")
    public ResponseEntity<Patient> findPatientById(@PathVariable Long id) {
        return ResponseEntity.ok(patientRepo.findById(id).orElse(null));
    }

    @GetMapping("/appointment/{id}")
    public ResponseEntity<Appointment> findAppointmentById(@PathVariable Long id) {
        return ResponseEntity.ok(appointmentRepo.findById(id).orElse(null));
    }

    @PostMapping("/register")
    public String patientAppointment(@RequestBody AppointmentForm appointmentForm){
        String message = appointmentService.patientAppoitment(appointmentForm);
        return message;
    }


    @PutMapping("/patient/update")
    public ResponseEntity<Patient> updateAppointment(@RequestBody Patient patient){
        return ResponseEntity.ok(patientRepo.save(patient));
    }

//    @DeleteMapping("/delete/{id}")
//    public String deletePatient(@PathVariable Long id){
//        String message = appointmentService.removePatient(id);
//        return message;
//    }
}
