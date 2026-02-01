package com.backend.model.entities;

import com.backend.model.Role;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "directors_tbl")
public class DirectorEntity {
    @Id
    @Column(name = "director_identification_number")
    private String directorIdentificationNumber;

    @Column(name = "director_name")
    private String directorName;

    @Column(name = "director_email")
    private String directorEmail;

    @Column(name = "director_identification_type")
    private String directorIdentificationType;

    @Column(name = "director_username", unique = true)
    private String directorUsername;

    @Column(name = "director_password")
    private String directorPassword;

    @Enumerated(EnumType.STRING)
    private Role role = Role.DIRECTOR;

    @OneToMany(mappedBy = "teacherManagedByDirector", fetch = FetchType.LAZY)
    private List<TeacherEntity> directorManagedTeachers;

    public DirectorEntity(String directorIdentificationNumber,
                          String directorName,
                          String directorEmail,
                          String directorIdentificationType,
                          String directorUsername,
                          String directorPassword,
                          Role role) {
        this.directorIdentificationNumber = directorIdentificationNumber;
        this.directorName = directorName;
        this.directorEmail = directorEmail;
        this.directorIdentificationType = directorIdentificationType;
        this.directorUsername = directorUsername;
        this.directorPassword = directorPassword;
        this.role = role;
    }

    public DirectorEntity() {}

    public String getDirectorIdentificationNumber() {return directorIdentificationNumber;}

    public void setDirectorIdentificationNumber(String directorIdentificationNumber) {this.directorIdentificationNumber = directorIdentificationNumber;}

    public String getDirectorName() {return directorName;}

    public void setDirectorName(String directorName) {this.directorName = directorName;}

    public String getDirectorIdentificationType() {return directorIdentificationType;}

    public void setDirectorIdentificationType(String directorIdentificationType) {this.directorIdentificationType = directorIdentificationType;}

    public String getDirectorEmail() {return directorEmail;}

    public void setDirectorEmail(String directorEmail) {this.directorEmail = directorEmail;}

    public String getDirectorUsername() {return directorUsername;}

    public void setDirectorUsername(String directorUsername) {this.directorUsername = directorUsername;}

    public String getDirectorPassword() {return directorPassword;}

    public void setDirectorPassword(String directorPassword) {this.directorPassword = directorPassword;}

    public Role getRole() {return this.role;}

    public List<TeacherEntity> getDirectorManagedTeachers() {return this.directorManagedTeachers;}

    public void setDirectorManagedTeachers(List<TeacherEntity> directorManagedTeachers) {this.directorManagedTeachers = directorManagedTeachers;}


}
