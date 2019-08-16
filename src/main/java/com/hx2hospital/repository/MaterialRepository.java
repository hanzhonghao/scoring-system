package com.hx2hospital.repository;

import com.hx2hospital.model.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MaterialRepository extends JpaRepository<Material, Long>, JpaSpecificationExecutor<Material> {

    Material findById(long id);

    void deleteById(Long id);
}