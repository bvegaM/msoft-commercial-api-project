package ec.edu.ups.directvservice.rest;

import ec.edu.ups.directvservice.entity.ServiceDirectv;
import ec.edu.ups.directvservice.entity.request.ServiceDirectvDTO;
import ec.edu.ups.directvservice.entity.request.ServiceDirectvRequestDTO;
import ec.edu.ups.directvservice.service.ServiceDirectvService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/servicio_api")
public class ServiceDirectvController {
    @Autowired
    ServiceDirectvService serviceDirectvService;

    private ServiceDirectvDTO convertServiceDirectvToServiceDirectvDTO(ServiceDirectv serviceDirectv){
        ServiceDirectvDTO serviceDirectvDTO = new ServiceDirectvDTO();
        serviceDirectvDTO.setSdr_id(serviceDirectv.getSdr_id());
        serviceDirectvDTO.setCli_dni(serviceDirectv.getContract().getCustomer().getCli_cedula());
        serviceDirectvDTO.setCli_contrato(serviceDirectv.getContract().getCnt_id());
        serviceDirectvDTO.setCli_nombres(serviceDirectv.getContract().getCustomer().getCli_nombre());
        serviceDirectvDTO.setDeuda_total(serviceDirectv.getSdr_deuda_total());
        serviceDirectvDTO.setDeuda_minimo(serviceDirectv.getSdr_deuda_minimo());
        serviceDirectvDTO.setDeuda_emision(serviceDirectv.getSdr_deuda_emision());
        serviceDirectvDTO.setDeuda_corte(serviceDirectv.getSdr_deuda_corte());
        serviceDirectvDTO.setDeuda_vencimiento(serviceDirectv.getSdr_deuda_vencimiento());
        serviceDirectvDTO.setObservacion(serviceDirectv.getSdr_observacion());
        return serviceDirectvDTO;
    }

    @PostMapping("/cliente")
    public List<ServiceDirectvDTO> postServicesDirectvByDNI(@RequestBody ServiceDirectvRequestDTO serviceDirectvRequestDTO){
        List<ServiceDirectvDTO> serviceDirectvDTOList = new ArrayList<>();
        List<ServiceDirectv> serviceDirectvList = serviceDirectvService.retrieveServicesDirectvByDni(serviceDirectvRequestDTO.getCli_dni());
        ServiceDirectvDTO serviceDirectvDTO;
        for(ServiceDirectv serviceDirectv : serviceDirectvList){
            serviceDirectvDTO = convertServiceDirectvToServiceDirectvDTO(serviceDirectv);
            serviceDirectvDTOList.add(serviceDirectvDTO);
        }
        return serviceDirectvDTOList;
    }
}
