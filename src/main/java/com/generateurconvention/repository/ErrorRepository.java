package com.generateurconvention.repository;


import com.generateurconvention.model.Error;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ErrorRepository extends JpaRepository<Error, Long> {
    // Méthode pour récupérer toutes les erreurs liées à une convention
    List<Error> findByConventionId(Long conventionId);
}

