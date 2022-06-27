package com.turnero.turnos.service;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.turnero.turnos.entity.Odontologo;
import com.turnero.turnos.entity.OdontologoDTO;
import com.turnero.turnos.repository.IOdontologoRepository;
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
    @Override
    public void guardarOdontologo(OdontologoDTO odontologoDTO) {
        odontologoRepository.save(mapper.convertValue(odontologoDTO, Odontologo.class));
    }

    @Override
    public OdontologoDTO getOdontologo(Long id) {
       Optional<Odontologo> odontologo= odontologoRepository.findById(id);
       OdontologoDTO odontologoDTO=null;
       if (odontologo != null)
           odontologoDTO=mapper.convertValue(odontologo,OdontologoDTO.class);

        return odontologoDTO;
    }

    @Override
    public void eliminarOdontologo(Long id) {
        odontologoRepository.deleteById(id);
    }

    @Override
    public void actualizarOdontologo(OdontologoDTO odontologoDTO) {
            if(odontologoDTO.getId() !=null)
             odontologoRepository.save(mapper.convertValue(odontologoDTO,Odontologo.class));

    }

    @Override
    public Set<OdontologoDTO> listarTodos() {
        List<Odontologo> odontologos=odontologoRepository.findAll();
        Set<OdontologoDTO> odontologoDTOS=new HashSet<>();
        for (Odontologo o:odontologos){
            odontologoDTOS.add(mapper.convertValue(o,OdontologoDTO.class));
        }
        return odontologoDTOS;
    }
}