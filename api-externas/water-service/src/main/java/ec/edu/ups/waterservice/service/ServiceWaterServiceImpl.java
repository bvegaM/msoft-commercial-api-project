package ec.edu.ups.waterservice.service;

import ec.edu.ups.waterservice.repository.ServiceWaterRepository;
import ec.edu.ups.waterservice.entity.ServiceWater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceWaterServiceImpl implements ServiceWaterService {
    @Autowired
    ServiceWaterRepository serviceRepository;


    @Override
    public List<ServiceWater> retrieveServicesByCedula(String cedula) {
        return (List<ServiceWater>)serviceRepository.findServicesByCedula(cedula);
    }

    @Override
    public List<ServiceWater> retrieveServicesByContract(Long contractId) {
        return (List<ServiceWater>)serviceRepository.findServicesByContract(contractId);
    }
}
