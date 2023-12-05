package com.imd.medical_api.repository;

import com.imd.medical_api.model.Doutor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoutorRepository extends JpaRepository<Doutor, Long> {
}
