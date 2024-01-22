package com.example.result.repo;

import com.example.result.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long>
{
        Student findBySeatNoAndMotherName(String seatNo, String motherName);
}
