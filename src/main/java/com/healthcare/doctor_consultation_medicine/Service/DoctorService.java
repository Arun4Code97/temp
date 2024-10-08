package com.healthcare.doctor_consultation_medicine.Service;

import com.healthcare.doctor_consultation_medicine.DTO.DoctorDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface DoctorService {
    public DoctorDto saveDoctorWithImage(DoctorDto doctorDto, MultipartFile imageFile) throws IOException;
    boolean isExistByEmail(String email);

    boolean isExistById(Long id);

    DoctorDto getSingleDoctorById(Long id);
    List<DoctorDto> getAllDoctors();

//    DoctorDto updateDoctorById(Long id, DoctorDto doctorDto);
    public void deleteDoctorById(Long id);

    void deletePatientById(Long id);

    Optional<DoctorDto> findDoctorByEmailId(String email);

    List<DoctorDto> getDoctorsBySpecialization();

    DoctorDto saveDoctor(DoctorDto doctor);

    void setPassword(Long doctorId, String confirmPassword);
}
