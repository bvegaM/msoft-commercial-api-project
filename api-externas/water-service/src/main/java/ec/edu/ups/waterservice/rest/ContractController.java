package ec.edu.ups.waterservice.rest;

import ec.edu.ups.waterservice.entity.Contract;
import ec.edu.ups.waterservice.entity.ServiceWater;
import ec.edu.ups.waterservice.entity.request.ContractDTO;
import ec.edu.ups.waterservice.entity.request.ServiceWaterDTO;
import ec.edu.ups.waterservice.service.ContractService;
import ec.edu.ups.waterservice.service.ServiceWaterService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/contratos")
public class ContractController {
    @Autowired
    ContractService contractService;

    private ContractDTO convertContractToContractDTO(Contract contract){
        ContractDTO contractDTO = new ContractDTO();
        BeanUtils.copyProperties(contract, contractDTO);
        contractDTO.setClienteId(contract.getCustomer().getId());
        return contractDTO;
    }

    @GetMapping("/cliente/{cedula}")
    public List<ContractDTO> getContractsByCedula(@PathVariable String cedula){
        List<ContractDTO> contractDTOList = new ArrayList<>();
        List<Contract> contractList = contractService.retrieveContractsByCedula(cedula);
        ContractDTO contractDTO;
        for(Contract contract : contractList){
            contractDTO = convertContractToContractDTO(contract);
            contractDTOList.add(contractDTO);
        }
        return contractDTOList;
    }
}
