package com.healthcare.doctor_consultation_medicine.Mapper;

import com.healthcare.doctor_consultation_medicine.DTO.PatientDto;
import com.healthcare.doctor_consultation_medicine.Model.Patient;

import java.util.Optional;

public class PatientMapper {
    public static Patient toMapPatientEntity(PatientDto patientDto){
        Long id;
        if (patientDto.getId() != null && !patientDto.getId().isEmpty()) {
            try {
                id= Long.parseLong(patientDto.getId());
            } catch (NumberFormatException e) {
                // Handle invalid id format
                id=null;
            }
        } else {
            // Set to null for new records
            id=null;
        }
        return new Patient(
              id,
              patientDto.getFirstName(),
              patientDto.getLastName(),
              patientDto.getPassword(),
              Integer.parseInt(patientDto.getAge()),
              patientDto.getGender(),
              patientDto.getEmail(),
              Long.parseLong(patientDto.getPhone()),
              Float.parseFloat(patientDto.getHeight()),
              Float.parseFloat(patientDto.getWeight()),
              patientDto.getCity(),
              patientDto.getAddress(),
              patientDto.getMedicalHistory(),
              patientDto.getMedicines().stream().map(MedicineMapper::toMapEntity).toList(),
              patientDto.getEmergencyContactRelationship(),
              Long.parseLong(patientDto.getEmergencyContactNumber())
      );
    }
    public static PatientDto toMapPatientDto(Patient patient){

        return new PatientDto(String.valueOf(patient.getId()),
                patient.getFirstName(),
                patient.getLastName(),
                patient.getPassword(),
                String.valueOf(patient.getAge()),
                patient.getGender(),
                patient.getEmail(),
                String.valueOf(patient.getPhone()),
                String.valueOf(patient.getHeight()),
                String.valueOf(patient.getWeight()),
                patient.getCity(),
                patient.getAddress(),
                patient.getMedicalHistory(),
                patient.getMedicines().stream().map(MedicineMapper::toMapDto).toList(),
                patient.getEmergencyContactRelationship(),
                String.valueOf(patient.getEmergencyContactNumber())
        );
    }
}
