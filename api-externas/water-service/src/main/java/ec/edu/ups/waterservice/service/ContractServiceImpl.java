package ec.edu.ups.waterservice.service;

import ec.edu.ups.waterservice.entity.Contract;
import ec.edu.ups.waterservice.entity.ServiceWater;
import ec.edu.ups.waterservice.repository.ContractRepository;
import ec.edu.ups.waterservice.repository.ServiceWaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractServiceImpl implements ContractService{
    @Autowired
    ContractRepository contractRepository;


    @Override
    public List<Contract> retrieveContractsByCedula(String cedula) {
        return (List<Contract>)contractRepository.findContractsByCedula(cedula);
    }
}
