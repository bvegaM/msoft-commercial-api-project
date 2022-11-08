package ec.edu.ups.waterservice.service;

import ec.edu.ups.waterservice.entity.Contract;

import java.util.List;

public interface ContractService {
    List<Contract> retrieveContractsByCedula(String cedula);
}
