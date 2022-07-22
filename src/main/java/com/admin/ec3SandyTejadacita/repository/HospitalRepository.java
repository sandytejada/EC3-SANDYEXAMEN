package com.admin.ec3SandyTejadacita.repository;

import com.admin.ec3SandyTejadacita.model.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Integer> {
}
