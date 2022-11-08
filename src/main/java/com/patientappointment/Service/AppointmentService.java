package com.patientappointment.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.patientappointment.controller.forms.AppointmentForm;
import com.patientappointment.model.Appointment;
import com.patientappointment.model.Patient;
import com.patientappointment.repository.AppointmentRepo;
import com.patientappointment.repository.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;

@Service
@Transactional
public class AppointmentService {

    @Autowired
    private AppointmentRepo appointmentRepo;
    @Autowired
    private PatientRepo patientRepo;

    public String patientAppoitment(AppointmentForm appointmentForm){
        Patient patient = new ObjectMapper().convertValue(appointmentForm,Patient.class);

        Long patientNo = patientRepo.save(patient).getPatientId();

        Appointment appointment = new Appointment("D101",new Date(System.currentTimeMillis()),patientNo);

        Long appointmentNo = appointmentRepo.save(appointment).getAppointmentId();

        return "Appointment Successfully Done with appointment Id : "+appointmentNo;
    }

//    public String removePatient(Long id){
//        Long appointmentNo;
//        patientRepo.findById(id).ifPresent(patientRepo::delete);
//        appointmentRepo.findById(appointmentNo).ifPresent(patientRepo::delete);
//        ResponseEntity.ok().build();
//        return "Deleted Successfully";
//    }

}
