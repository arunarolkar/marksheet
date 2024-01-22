package com.example.result.repo;

import com.example.result.entity.MarksheetDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarksheetDetailsRepo extends JpaRepository<MarksheetDetails, Long>
{
        MarksheetDetails findByIdMarksheetAndIdSubject(Long idMarksheet, Long idSubject);
        List<MarksheetDetails> findByIdMarksheet(Long idMarksheet);
}
