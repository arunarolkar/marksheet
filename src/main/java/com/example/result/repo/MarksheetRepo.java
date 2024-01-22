package com.example.result.repo;

import com.example.result.entity.Marksheet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarksheetRepo extends JpaRepository<Marksheet, Long>
{
    Marksheet findOneByIdStudent(Long idStudent);
}
