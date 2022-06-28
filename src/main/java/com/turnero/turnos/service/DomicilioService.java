package com.turnero.turnos.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.turnero.turnos.entity.Domicilio;
import com.turnero.turnos.entity.DomicilioDTO;
import com.turnero.turnos.repository.IDomicilioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class DomicilioService implements IDomicilioService{

    private IDomicilioRepository domicilioRepository;

    public DomicilioService(IDomicilioRepository domicilioRepository) {
        this.domicilioRepository = domicilioRepository;
    }
    @Autowired
    ObjectMapper mapper;

    @Override
    public void guardarDomicilio(DomicilioDTO domicilioDTO) {
        domicilioRepository.save(mapper.convertValue(domicilioDTO, Domicilio.class));
    }

    @Override
    public DomicilioDTO buscarDomicilio(Long id) {

        return mapper.convertValue(domicilioRepository.findById(id),DomicilioDTO.class) ;
    }

    @Override
    public void eliminarDomicilio(Long id) {
        domicilioRepository.deleteById(id);
    }

    @Override
    public void actualizarDomicilio(DomicilioDTO domicilioDTO) {
            if(domicilioDTO.getId()!=null){
                domicilioRepository.save(mapper.convertValue(domicilioDTO, Domicilio.class));
            }
    }

    @Override
    public List<DomicilioDTO> listarTodos() {
        List<Domicilio> domicilios=domicilioRepository.findAll();
        List<DomicilioDTO> domicilioDTOS=new ArrayList<>();
        for(Domicilio d:domicilios){
            domicilioDTOS.add(mapper.convertValue(d,DomicilioDTO.class));
        }
        return domicilioDTOS;
    }

}
