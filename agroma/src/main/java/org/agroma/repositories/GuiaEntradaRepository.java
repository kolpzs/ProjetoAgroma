package org.agroma.repositories;

import org.agroma.entities.GuiaEntradaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuiaEntradaRepository extends JpaRepository<GuiaEntradaEntity, Long> {
}
