package com.turnero.turnos.service;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.turnero.turnos.controller.DomicilioController;
import com.turnero.turnos.entity.Odontologo;
import com.turnero.turnos.entity.OdontologoDTO;
import com.turnero.turnos.exception.ResourceNotFoundException;
import com.turnero.turnos.repository.IOdontologoRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class OdontologoService implements IOdontologoService{
    @Autowired
    private IOdontologoRepository odontologoRepository;
    @Autowired
    ObjectMapper mapper;
    private final static Logger logger=Logger.getLogger(OdontologoService.class);
    @Override
    public void guardarOdontologo(OdontologoDTO odontologoDTO) {
        odontologoRepository.save(mapper.convertValue(odontologoDTO, Odontologo.class));
        logger.info("Odontólogo creado con exito.");
    }

    @Override
    public Optional<OdontologoDTO> buscarOdontologo(Long id) throws ResourceNotFoundException {
       Optional<Odontologo> odontologo= odontologoRepository.findById(id);
       OdontologoDTO odontologoDTO=null;
       if (odontologo.isPresent()) {
           odontologoDTO = mapper.convertValue(odontologo, OdontologoDTO.class);
           Optional<OdontologoDTO> optionalOdontologoDTO=Optional.ofNullable(odontologoDTO);

           return optionalOdontologoDTO;
       }else {
           throw new ResourceNotFoundException("No se encontro ningún odontólogo con id "+id);
       }
    }

    @Override
    public void eliminarOdontologo(Long id) throws ResourceNotFoundException {
        if (buscarOdontologo(id).isPresent()){
            logger.info("Odontologo con id "+id+ " fue eliminado con exito.");
            odontologoRepository.deleteById(id);
        } else
            throw new  ResourceNotFoundException("El odontologo con id "+id+" No existe.");

    }

    @Override
    public void actualizarOdontologo(OdontologoDTO odontologoDTO)  throws ResourceNotFoundException {
            if(odontologoDTO.getId() !=null &&odontologoDTO.getId()==odontologoRepository.findById(odontologoDTO.getId()).get().getId()) {
                odontologoRepository.save(mapper.convertValue(odontologoDTO, Odontologo.class));
                logger.info("Odontologo con id "+odontologoDTO.getId()+ " fue actualizado con exito.");
            }else
                throw new ResourceNotFoundException("No se envió el id dentro del cuerpo de la petición.");
    }

    @Override
    public Set<OdontologoDTO> listarTodos() throws ResourceNotFoundException {
        List<Odontologo> odontologos=odontologoRepository.findAll();
        Set<OdontologoDTO> odontologoDTOS=new HashSet<>();
        if (odontologos.size()>0){
            for (Odontologo o:odontologos){
                odontologoDTOS.add(mapper.convertValue(o,OdontologoDTO.class));
            }
            return odontologoDTOS;
        }else
            throw new ResourceNotFoundException("La lista de odontólogos esta vacia.");

    }

    @Override
    public Optional<OdontologoDTO> buscarOdontologoPorApellido(String apellido) throws ResourceNotFoundException {
        Optional<OdontologoDTO> optionalOdontologoDTO=null;
        if (odontologoRepository.buscarOdontologoPorApellido(apellido).isPresent()){
            OdontologoDTO optionalOdontologo= mapper.convertValue(odontologoRepository.buscarOdontologoPorApellido(apellido).get(),OdontologoDTO.class);
            optionalOdontologoDTO=Optional.ofNullable(optionalOdontologo);
            return optionalOdontologoDTO;
        }else
            throw new ResourceNotFoundException("No existe un odontólogo con ese apellido.");


    }
}