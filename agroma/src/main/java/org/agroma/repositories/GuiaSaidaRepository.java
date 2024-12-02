package org.agroma.repositories;

import org.agroma.entities.GuiaSaidaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuiaSaidaRepository extends JpaRepository<GuiaSaidaEntity, Long> {
}
