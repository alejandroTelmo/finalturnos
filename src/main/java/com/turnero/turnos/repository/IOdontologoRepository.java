package com.turnero.turnos.repository;


import com.turnero.turnos.entity.Domicilio;
import com.turnero.turnos.entity.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IOdontologoRepository extends JpaRepository<Odontologo,Long> {
    @Query("select o from Odontologo o where o.apellido LIKE :unApellido%")
    Optional<Odontologo> buscarOdontologoPorApellido(String unApellido);

}
