package com.turnero.turnos.repository;

import com.turnero.turnos.entity.Domicilio;
import com.turnero.turnos.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IDomicilioRepository extends JpaRepository<Domicilio,Long> {
    @Query("select d from Domicilio d where d.calle LIKE :calle%")
  Optional<Domicilio>buscarPorCalle(String calle);

}
