package com.example.result.entity;

import jakarta.persistence.*;

@Entity
public class Marksheet
{
    @Id
    @SequenceGenerator(name = "seq_marksheet")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_marksheet")
    Long id;
    Long idStudent;

    public Marksheet()
    {

    }



    public Marksheet(Long idStudent)
    {
        this.idStudent = idStudent;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(Long idStudent) {
        this.idStudent = idStudent;
    }

    @Override
    public String toString() {
        return "Marksheet{" +
                "id=" + id +
                ", idStudent=" + idStudent +
                '}';
    }
}
