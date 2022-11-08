package ec.edu.ups.waterservice.service;

import ec.edu.ups.waterservice.entity.ServiceWater;

import java.util.List;

public interface ServiceWaterService {
    List<ServiceWater> retrieveServicesByCedula(String cedula);

    List<ServiceWater> retrieveServicesByContract(Long contractId);
}
