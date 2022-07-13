package com.turnero.turnos.service;

import com.turnero.turnos.entity.DomicilioDTO;
import com.turnero.turnos.entity.Paciente;
import com.turnero.turnos.entity.PacienteDTO;
import com.turnero.turnos.exception.ResourceNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PacienteServiceTest {

    @Autowired
    IPacienteService pacienteService;


    @Test
    public void crearPacienteTest() throws ResourceNotFoundException {
        DomicilioDTO domicilioDTO=new DomicilioDTO();
        domicilioDTO.setCalle("crear domicilio");
        domicilioDTO.setNumero(198);
        domicilioDTO.setCiudad("lg");
        domicilioDTO.setProvincia("rn");

        PacienteDTO pacienteDTO=new PacienteDTO();
        pacienteDTO.setNombre("daniel");
        pacienteDTO.setApellido("telmo");
        pacienteDTO.setDni("26215823");
        pacienteDTO.setDomicilio(domicilioDTO);

        pacienteService.guardarPaciente(pacienteDTO);

        Optional<PacienteDTO> optionalPacienteDTO=pacienteService.buscarPorNombre("daniel");
        assertEquals(1L,optionalPacienteDTO.get().getId());
        assertEquals("daniel",optionalPacienteDTO.get().getNombre());

    }
    @Test
    public void actualizarPaciente() throws ResourceNotFoundException {
        DomicilioDTO domicilioDTO=new DomicilioDTO();
        domicilioDTO.setCalle("crear domicilio");
        domicilioDTO.setNumero(198);
        domicilioDTO.setCiudad("lg");
        domicilioDTO.setProvincia("rn");

        PacienteDTO pacienteDTO=new PacienteDTO();
        pacienteDTO.setNombre("para actualizar");
        pacienteDTO.setApellido("telmo");
        pacienteDTO.setDni("26215823");
        pacienteDTO.setDomicilio(domicilioDTO);

        pacienteService.guardarPaciente(pacienteDTO);
        Optional<PacienteDTO> optionalPacienteDTO=pacienteService.buscarPorNombre("para actualizar");
        PacienteDTO pacienteDTO1=new PacienteDTO();
        pacienteDTO1.setId(1L);
        pacienteDTO1.setNombre("actualizado");
        pacienteDTO1.setApellido("telmo");
        pacienteDTO1.setDni("26215823");
        pacienteDTO1.setDomicilio(domicilioDTO);


        pacienteService.actualizarPaciente(pacienteDTO1);
        Optional<PacienteDTO> optionalPacienteDTO1=pacienteService.buscarPorNombre("actualizado");

        assertEquals("actualizado",optionalPacienteDTO1.get().getNombre());

    }
    @Test
    public void eliminarPaciente() throws ResourceNotFoundException {
        DomicilioDTO domicilioDTO=new DomicilioDTO();
        domicilioDTO.setCalle("crear domicilio");
        domicilioDTO.setNumero(198);
        domicilioDTO.setCiudad("lg");
        domicilioDTO.setProvincia("rn");

        PacienteDTO pacienteDTO=new PacienteDTO();
        pacienteDTO.setNombre("eliminar");
        pacienteDTO.setApellido("telmo");
        pacienteDTO.setDni("26215823");
        pacienteDTO.setDomicilio(domicilioDTO);

        pacienteService.guardarPaciente(pacienteDTO);
        Optional<PacienteDTO> optionalPacienteDTO1=pacienteService.buscarPorNombre("eliminar");
        pacienteService.eliminarPaciente(optionalPacienteDTO1.get().getId());

        assertEquals(null,pacienteService.buscarPaciente(optionalPacienteDTO1.get().getId()) );

    }

    @Test
    public void buscarPacientePorId() throws ResourceNotFoundException {

        DomicilioDTO domicilioDTO=new DomicilioDTO();
        domicilioDTO.setCalle("crear domicilio");
        domicilioDTO.setNumero(198);
        domicilioDTO.setCiudad("lg");
        domicilioDTO.setProvincia("rn");

        PacienteDTO pacienteDTO=new PacienteDTO();
        pacienteDTO.setNombre("daniel");
        pacienteDTO.setApellido("telmo");
        pacienteDTO.setDni("26215823");
        pacienteDTO.setDomicilio(domicilioDTO);

        pacienteService.guardarPaciente(pacienteDTO);
     PacienteDTO pacienteDTO1=pacienteService.buscarPaciente(1L);
     assertEquals(1L,pacienteDTO1.getId());
    }
    @Test
    public void buscarPacientePorNombre() throws ResourceNotFoundException {
        DomicilioDTO domicilioDTO=new DomicilioDTO();
        domicilioDTO.setCalle("crear domicilio");
        domicilioDTO.setNumero(198);
        domicilioDTO.setCiudad("lg");
        domicilioDTO.setProvincia("rn");

        PacienteDTO pacienteDTO=new PacienteDTO();
        pacienteDTO.setNombre("federico");
        pacienteDTO.setApellido("telmo");
        pacienteDTO.setDni("26215823");
        pacienteDTO.setDomicilio(domicilioDTO);

        pacienteService.guardarPaciente(pacienteDTO);
        Optional<PacienteDTO> optionalPacienteDTO1=pacienteService.buscarPorNombre("federico");

        assertEquals("federico",optionalPacienteDTO1.get().getNombre());
    }
    @Test
    public void buscarTodosLosPacientes(){
        List<PacienteDTO> pacienteList=pacienteService.listarTodos();
        Integer cantidadPacientesAntes=pacienteList.size();
        DomicilioDTO domicilioDTO=new DomicilioDTO();
        domicilioDTO.setCalle("domicilio 1");
        domicilioDTO.setNumero(1977);
        domicilioDTO.setCiudad("lg");
        domicilioDTO.setProvincia("rn");

        PacienteDTO pacienteDTO=new PacienteDTO();
        pacienteDTO.setNombre("alejandro");
        pacienteDTO.setApellido("telmo");
        pacienteDTO.setDni("26215823");
        pacienteDTO.setDomicilio(domicilioDTO);

        pacienteService.guardarPaciente(pacienteDTO);

        DomicilioDTO domicilioDTO1=new DomicilioDTO();
        domicilioDTO.setCalle("domicilio 2");
        domicilioDTO.setNumero(1980);
        domicilioDTO.setCiudad("lg");
        domicilioDTO.setProvincia("rn");

        PacienteDTO pacienteDTO1=new PacienteDTO();
        pacienteDTO.setNombre("paola");
        pacienteDTO.setApellido("sepulveda");
        pacienteDTO.setDni("27898714");
        pacienteDTO.setDomicilio(domicilioDTO1);

        pacienteService.guardarPaciente(pacienteDTO1);

        DomicilioDTO domicilioDTO2=new DomicilioDTO();
        domicilioDTO.setCalle("domicilio 3");
        domicilioDTO.setNumero(2004);
        domicilioDTO.setCiudad("bb");
        domicilioDTO.setProvincia("bsas");

        PacienteDTO pacienteDTO2=new PacienteDTO();
        pacienteDTO.setNombre("lauty");
        pacienteDTO.setApellido("telmo");
        pacienteDTO.setDni("45454545");
        pacienteDTO.setDomicilio(domicilioDTO2);

        pacienteService.guardarPaciente(pacienteDTO2);
        List<PacienteDTO> pacienteDTOS=pacienteService.listarTodos();
        assertEquals(cantidadPacientesAntes+3,pacienteDTOS.size());
        assertNotEquals(2,pacienteDTOS.size());

    }
}