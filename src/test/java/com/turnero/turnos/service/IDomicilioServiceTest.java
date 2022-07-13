package com.turnero.turnos.service;

import com.turnero.turnos.entity.DomicilioDTO;
import com.turnero.turnos.exception.ResourceNotFoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class IDomicilioServiceTest {
    @Autowired
    private IDomicilioService domicilioService;


    @DisplayName("Actualizar domicilio")
    @Test
    public void actualizarDomicilioTest() throws ResourceNotFoundException {
        DomicilioDTO domicilioDTO = new DomicilioDTO();
//creo un domicilio y le seteo las propiedades que necesito
        domicilioDTO.setCalle("bahia");
        domicilioDTO.setNumero(198);
        domicilioDTO.setCiudad("lg");
        domicilioDTO.setProvincia("rn");
        //llamo al service para que me persista el objeto Domicilio
        domicilioService.guardarDomicilio(domicilioDTO);

       Optional< DomicilioDTO> dom1=domicilioService.buscarPorNombre("bahia");
        DomicilioDTO modificador=new DomicilioDTO();
        modificador.setId(dom1.get().getId());
        modificador.setCalle("LA bombonera");
        modificador.setNumero(555);
        modificador.setCiudad("Las Grutas");
        modificador.setProvincia("Provincia de Rio Negro");

        domicilioService.actualizarDomicilio(modificador);
        Optional< DomicilioDTO> dom2=domicilioService.buscarPorNombre("LA bombonera");
        System.out.println(dom2.get().getNumero());
        System.out.println(dom2.get().getId());

        assertEquals(555,dom2.get().getNumero());
        assertEquals("Las Grutas",dom2.get().getCiudad());
        assertNotEquals(198,dom2.get().getNumero());

    }

    @Test
    public void crearDomicilioTest(){
        DomicilioDTO domicilioDTO=new DomicilioDTO();
        domicilioDTO.setCalle("crear domicilio");
        domicilioDTO.setNumero(198);
        domicilioDTO.setCiudad("lg");
        domicilioDTO.setProvincia("rn");
        domicilioService.guardarDomicilio(domicilioDTO);

       Optional<DomicilioDTO>  domicilioDTO1=domicilioService.buscarPorNombre("crear domicilio");

        assertEquals( "crear domicilio",domicilioDTO1.get().getCalle());
        assertEquals(198,domicilioDTO1.get().getNumero());
        assertEquals("lg",domicilioDTO1.get().getCiudad());
        assertEquals("rn",domicilioDTO1.get().getProvincia());

    }

    @Test
    public void eliminarDomicilioTest() throws ResourceNotFoundException {
        DomicilioDTO domicilioDTO = new DomicilioDTO();
        domicilioDTO.setCalle("ribbber");
        domicilioDTO.setNumero(198);
        domicilioDTO.setCiudad("lg");
        domicilioDTO.setProvincia("rn");
        domicilioService.guardarDomicilio(domicilioDTO);
        Optional<DomicilioDTO> optionalDomicilioDTO=domicilioService.buscarPorNombre("ribbber");
        domicilioService.eliminarDomicilio(optionalDomicilioDTO.get().getId());

        assertThrows(ResourceNotFoundException.class,()->domicilioService.buscarDomicilio(optionalDomicilioDTO.get().getId()));

    }

    @Test
    public void probandoSettersDomicilioTest(){
        DomicilioDTO domicilioDTO=new DomicilioDTO();

        domicilioDTO.setCalle("condor");
        domicilioDTO.setNumero(930);
        domicilioDTO.setCiudad("LG");
        domicilioDTO.setProvincia("sao");
        domicilioService.guardarDomicilio(domicilioDTO);

        Optional<DomicilioDTO> optionalDomicilioDTO=domicilioService.buscarPorNombre("condor");
        System.out.println(optionalDomicilioDTO.get().getId());
        optionalDomicilioDTO.get().setId(22L);
        System.out.println(optionalDomicilioDTO.get().getId());
    }
  @Test
    public void buscarPorIdTest(){

      Optional<List<DomicilioDTO>> domicilioDTOS=domicilioService.listarTodos();
      Integer cantidadDomiciliosAntes= domicilioDTOS.get().size();
      System.out.println(cantidadDomiciliosAntes);
        DomicilioDTO domicilioDTO=new DomicilioDTO();

      domicilioDTO.setCalle("cabralitolotp");
      domicilioDTO.setNumero(930);
      domicilioDTO.setCiudad("LG");
      domicilioDTO.setProvincia("sao");
      domicilioService.guardarDomicilio(domicilioDTO);
      Optional<DomicilioDTO> optionalDomicilioDTO=domicilioService.buscarPorNombre("cabralitolotp");

      assertNotEquals(cantidadDomiciliosAntes,optionalDomicilioDTO.get().getId());

      assertEquals(cantidadDomiciliosAntes+2,optionalDomicilioDTO.get().getId());

  }
  @Test
    public void buscarPorNombreTest(){


      DomicilioDTO domicilioDTO=new DomicilioDTO();

      domicilioDTO.setCalle("aguila");
      domicilioDTO.setNumero(930);
      domicilioDTO.setCiudad("LG");
      domicilioDTO.setProvincia("sao");
      domicilioService.guardarDomicilio(domicilioDTO);
     Optional<DomicilioDTO> domicilioDTO1=domicilioService.buscarPorNombre("aguila");
      assertNotEquals("bahia",domicilioDTO1.get().getCalle());
      assertEquals("aguila",domicilioDTO1.get().getCalle());
  }
    @Test
    public void buscarTodosLosDomiciliosTest(){
        Optional<List<DomicilioDTO>> domicilioDTOS=domicilioService.listarTodos();
        Integer cantidadDomiciliosAntes= domicilioDTOS.get().size();

        DomicilioDTO domicilioDTO=new DomicilioDTO();

        domicilioDTO.setCalle("sin rumbo");
        domicilioDTO.setNumero(930);
        domicilioDTO.setCiudad("LG");
        domicilioDTO.setProvincia("sao");
        domicilioService.guardarDomicilio(domicilioDTO);

        DomicilioDTO domicilioDTO1=new DomicilioDTO();

        domicilioDTO.setCalle("calle 1");
        domicilioDTO.setNumero(930);
        domicilioDTO.setCiudad("LG");
        domicilioDTO.setProvincia("sao");
        domicilioService.guardarDomicilio(domicilioDTO1);

        DomicilioDTO domicilioDTO2=new DomicilioDTO();

        domicilioDTO.setCalle("cueva 2");
        domicilioDTO.setNumero(930);
        domicilioDTO.setCiudad("LG");
        domicilioDTO.setProvincia("sao");
        domicilioService.guardarDomicilio(domicilioDTO2);

        DomicilioDTO domicilioDTO3=new DomicilioDTO();

        domicilioDTO.setCalle("basta");
        domicilioDTO.setNumero(930);
        domicilioDTO.setCiudad("LG");
        domicilioDTO.setProvincia("sao");
        domicilioService.guardarDomicilio(domicilioDTO3);

        Optional<List<DomicilioDTO>> domicilioDTOS2=domicilioService.listarTodos();

        assertNotEquals(2,domicilioDTOS2.get().size());
        assertEquals(cantidadDomiciliosAntes+4,domicilioDTOS2.get().size());
    }
}