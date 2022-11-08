package ec.edu.ups.directvservice.service;

import ec.edu.ups.directvservice.entity.ServiceDirectv;

import java.util.List;

public interface ServiceDirectvService {
    List<ServiceDirectv> retrieveServicesDirectvByDni(String dni);
}
