package com.backend.model.dtos;

import com.backend.model.Role;

import java.util.List;

public class DirectorDto {

    private String directorIdentificationNumber;
    private String directorIdentificationType;
    private String directorName;
    private String directorEmail;
    private String directorUsername;
    private String directorPassword;
    private List<String> teacherIdentificationNumbersInChargeOfDirector;
    private Role role = Role.DIRECTOR;

    public DirectorDto(String directorIdentificationNumber,
                       String directorIdentificationType,
                       String directorName,
                       String directorEmail,
                       String directorUsername,
                       String directorPassword,
                       List<String> teacherIdentificationNumbersInChargeOfDirector) {
        this.directorIdentificationNumber = directorIdentificationNumber;
        this.directorIdentificationType = directorIdentificationType;
        this.directorName = directorName;
        this.directorEmail = directorEmail;
        this.directorUsername = directorUsername;
        this.directorPassword = directorPassword;
        this.teacherIdentificationNumbersInChargeOfDirector = teacherIdentificationNumbersInChargeOfDirector;
    }

    public String getDirectorIdentificationNumber() {return directorIdentificationNumber;}
    public void setDirectorIdentificationNumber(String directorIdentificationNumber) {this.directorIdentificationNumber = directorIdentificationNumber;}
    public String getDirectorIdentificationType() {return directorIdentificationType;}
    public void setDirectorIdentificationType(String directorIdentificationType) {this.directorIdentificationType = directorIdentificationType;}
    public String getDirectorName() {return directorName;}
    public void setDirectorName(String directorName) {this.directorName = directorName;}
    public String getDirectorEmail() {return directorEmail;}
    public void setDirectorEmail(String directorEmail) {this.directorEmail = directorEmail;}
    public String getDirectorPassword() {return this.directorPassword;}
    public void setDirectorPassword(String directorPassword) {this.directorPassword = directorPassword;}
    public String getDirectorUsername() {return directorUsername;}
    public void setDirectorUsername(String directorUsername) {this.directorUsername = directorUsername;}
    public Role getRole() {return role;}
    public void setRole(Role role) {this.role = role;}
    public List<String> getTeacherIdentificationNumbersInChargeOfDirector() {return this.teacherIdentificationNumbersInChargeOfDirector;}
    public void setTeacherIdentificationNumbersInChargeOfDirector(List<String> teacherIdentificationNumbersInChargeOfDirector) {this.teacherIdentificationNumbersInChargeOfDirector = teacherIdentificationNumbersInChargeOfDirector;}
}