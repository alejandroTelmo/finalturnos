package com.turnero.turnos.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.turnero.turnos.controller.DomicilioController;
import com.turnero.turnos.entity.Domicilio;
import com.turnero.turnos.entity.DomicilioDTO;
import com.turnero.turnos.exception.ResourceNotFoundException;
import com.turnero.turnos.repository.IDomicilioRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DomicilioService implements IDomicilioService{

    private IDomicilioRepository domicilioRepository;
    private final static Logger logger=Logger.getLogger(DomicilioService.class);
    public DomicilioService(IDomicilioRepository domicilioRepository) {
        this.domicilioRepository = domicilioRepository;
    }
    @Autowired
    ObjectMapper mapper;

    @Override
    public void guardarDomicilio(DomicilioDTO domicilioDTO) {
        domicilioRepository.save(mapper.convertValue(domicilioDTO, Domicilio.class));
        logger.info("Se creo el domicilio correctamente");
    }

    @Override
    public Optional<DomicilioDTO> buscarDomicilio(Long id) throws ResourceNotFoundException {
        DomicilioDTO domicilioDto= mapper.convertValue(domicilioRepository.findById(id),DomicilioDTO.class);
        Optional<DomicilioDTO> domicilio=Optional.ofNullable(domicilioDto);
        if (domicilio.isPresent()) {
            logger.info("Se encontro el domicilio con id : " + id + " .");
            return domicilio;
        }else
            throw new ResourceNotFoundException("No se encontro el domicilio con id "+id+".");

    }

    @Override
    public void eliminarDomicilio(Long id) throws ResourceNotFoundException {
        if(buscarDomicilio(id).isPresent()){
            logger.info("Domicilio con id "+id+" fue exitosamente borrado.");
            domicilioRepository.deleteById(id);

        }else
            throw new ResourceNotFoundException("Domicilio con id "+id+" inexistente");
    }

    @Override
    public void actualizarDomicilio(DomicilioDTO domicilioDTO) throws ResourceNotFoundException{
            if(domicilioDTO.getId()!=null &&domicilioDTO.getId()==domicilioRepository.findById(domicilioDTO.getId()).get().getId()){
                domicilioRepository.save(mapper.convertValue(domicilioDTO, Domicilio.class));
                logger.info("Domicilio con id "+domicilioDTO.getId()+"fue exitosamente actualizado.");
            } else
                throw new ResourceNotFoundException("No se envió el id en el cuerpo de la petición.");
    }

    @Override
    public Optional<List<DomicilioDTO>> listarTodos() {
        List<Domicilio> domicilios=domicilioRepository.findAll();
         List<DomicilioDTO> domicilioDTOS=new ArrayList<>();
        for(Domicilio d:domicilios){
            domicilioDTOS.add(mapper.convertValue(d,DomicilioDTO.class));
        }
        Optional<List<DomicilioDTO>> list=Optional.ofNullable(domicilioDTOS);
        return list;
    }

    @Override
       public Optional<DomicilioDTO>  buscarPorNombre(String name) {
             DomicilioDTO domicilioDto= mapper.convertValue(domicilioRepository.buscarPorCalle(name).get(),DomicilioDTO.class);
             Optional<DomicilioDTO> domicilioDTO=Optional.ofNullable(domicilioDto);

            return domicilioDTO;
        }
}
