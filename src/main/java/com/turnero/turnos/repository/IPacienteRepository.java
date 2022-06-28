package com.turnero.turnos.repository;

import com.turnero.turnos.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IPacienteRepository extends JpaRepository<Paciente,Long> {

    @Query("select p from Paciente p where p.nombre = ?1")
    Optional<Paciente>buscarPorNombre(String nombre);
}
