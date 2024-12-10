package org.agroma.repositories;

import org.agroma.entities.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
    @Query(value = "select * from usuarios where username = ?1", nativeQuery = true)
    Optional<UsuarioEntity> findByUsername(String login);
}
