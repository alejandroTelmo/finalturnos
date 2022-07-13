package com.turnero.turnos.service;

import com.turnero.turnos.entity.OdontologoDTO;
import com.turnero.turnos.exception.ResourceNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class OdontologoServiceTest {

    @Autowired
    IOdontologoService odontologoService;

    @Test
    void guardarOdontologo() throws ResourceNotFoundException {
        Set<OdontologoDTO> odontologoDTOS= odontologoService.listarTodos();
        Integer cantidadAntes=odontologoDTOS.size();

        OdontologoDTO odontologoDTO=new OdontologoDTO();
        odontologoDTO.setNombre("franco");
        odontologoDTO.setApellido("telmo1");
        odontologoDTO.setNumeroMatricula(1);
        odontologoService.guardarOdontologo(odontologoDTO);
        Set<OdontologoDTO> odontologoDTOS1= odontologoService.listarTodos();
        Integer cantidadDespues=odontologoDTOS1.size();

        assertEquals(cantidadAntes+1,cantidadDespues);
    }

    @Test
    void getOdontologo() throws ResourceNotFoundException {
        OdontologoDTO odontologoDTO1=new OdontologoDTO();
        odontologoDTO1.setNombre("franco");
        odontologoDTO1.setApellido("telmo telmo");
        odontologoDTO1.setNumeroMatricula(1);
        odontologoService.guardarOdontologo(odontologoDTO1);
        Optional<OdontologoDTO> optionalOdontologoDTO=odontologoService.buscarOdontologoPorApellido("telmo telmo");
        Optional<OdontologoDTO> odontologoDTO=odontologoService.buscarOdontologo(optionalOdontologoDTO.get().getId());

        assertEquals(optionalOdontologoDTO.get().getId(),odontologoDTO.get().getId());
    }

    @Test //@Test(expected=BRException.class)
    void eliminarOdontologo() throws ResourceNotFoundException {
        OdontologoDTO odontologoDTO=new OdontologoDTO();
        odontologoDTO.setNombre("franco");
        odontologoDTO.setApellido("eliminar");
        odontologoDTO.setNumeroMatricula(1);
        odontologoService.guardarOdontologo(odontologoDTO);

        Optional<OdontologoDTO> optionalOdontologoDTO=odontologoService.buscarOdontologoPorApellido("eliminar");
        odontologoService.eliminarOdontologo(optionalOdontologoDTO.get().getId());

        assertThrows(ResourceNotFoundException.class,()->odontologoService.buscarOdontologoPorApellido("eliminar"));;

    }

    @Test
    void actualizarOdontologo() throws ResourceNotFoundException {


        OdontologoDTO odontologoDTO=new OdontologoDTO();
        odontologoDTO.setNombre("franco");
        odontologoDTO.setApellido("actualizar");
        odontologoDTO.setNumeroMatricula(111);
        odontologoService.guardarOdontologo(odontologoDTO);
        Set<OdontologoDTO> odontologoDTOS= odontologoService.listarTodos();
        Integer cantidadAntes=odontologoDTOS.size();


        Optional<OdontologoDTO> optionalOdontologoDTO=odontologoService.buscarOdontologoPorApellido("actualizar");
        OdontologoDTO odontologoDTO1=new OdontologoDTO();
        odontologoDTO1.setId(optionalOdontologoDTO.get().getId());
        odontologoDTO1.setNombre("federico");
        odontologoDTO1.setApellido("actualizar");
        odontologoDTO1.setNumeroMatricula(9685);
        odontologoService.actualizarOdontologo(odontologoDTO1);
        Set<OdontologoDTO> odontologoDTOS1= odontologoService.listarTodos();
        Integer cantidadDespues=odontologoDTOS1.size();
        Optional<OdontologoDTO> optionalOdontologoDTO1=odontologoService.buscarOdontologoPorApellido("actualizar");

        assertEquals(cantidadAntes,cantidadDespues);
        assertEquals(optionalOdontologoDTO.get().getId(),optionalOdontologoDTO1.get().getId());
    }

    @Test
    void listarTodos() throws ResourceNotFoundException {
        OdontologoDTO odontologoDTO1=new OdontologoDTO();
        odontologoDTO1.setNombre("franco");
        odontologoDTO1.setApellido("telmo2");
        odontologoDTO1.setNumeroMatricula(1);
        odontologoService.guardarOdontologo(odontologoDTO1);
        Set<OdontologoDTO>odontologoDTOSet=odontologoService.listarTodos();

        assertTrue(odontologoDTOSet.size()>0);
    }
}