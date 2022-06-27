package com.turnero.turnos.repository;

import com.turnero.turnos.entity.Domicilio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDomicilioRepository extends JpaRepository<Domicilio,Long> {
}
