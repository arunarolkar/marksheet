package com.example.result.entity;

import jakarta.persistence.*;

@Entity
public class Student
{
    @Id
    @SequenceGenerator(name = "seq_student")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_student")
    Long id;
    String firstName;
    String lastName;
    String fatherName;
    String motherName;
    String seatNo;

    public Student()
    {

    }

    public Student(String firstName, String lastName, String fatherName, String motherName, String seatNo)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.fatherName = fatherName;
        this.motherName = motherName;
        this.seatNo = seatNo;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(String seatNo) {
        this.seatNo = seatNo;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", fatherName='" + fatherName + '\'' +
                ", motherName='" + motherName + '\'' +
                ", seatNo='" + seatNo + '\'' +
                '}';
    }
}
