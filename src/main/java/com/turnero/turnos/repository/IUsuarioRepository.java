package com.turnero.turnos.repository;

import com.turnero.turnos.entity.Paciente;
import com.turnero.turnos.entity.Usuario;
import com.turnero.turnos.entity.UsuarioDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario,Long> {
    @Query("select u from Usuario u where u.username LIKE :nombre%")
    Optional<Usuario> buscarPorNombreUsuario(String nombre);
}
