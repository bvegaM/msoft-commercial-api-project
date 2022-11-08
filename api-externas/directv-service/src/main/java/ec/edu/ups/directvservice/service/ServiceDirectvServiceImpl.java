package ec.edu.ups.directvservice.service;

import ec.edu.ups.directvservice.entity.ServiceDirectv;
import ec.edu.ups.directvservice.repository.ServiceDirectvRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServiceDirectvServiceImpl implements ServiceDirectvService{
    @Autowired
    ServiceDirectvRepository serviceDirectvRepository;

    @Override
    public List<ServiceDirectv> retrieveServicesDirectvByDni (String dni){
        return (List<ServiceDirectv>)serviceDirectvRepository.findServicesByDNI(dni);
    }
}
