package ec.edu.ups.waterservice.rest;

import ec.edu.ups.waterservice.entity.ServiceWater;
import ec.edu.ups.waterservice.entity.request.ServiceWaterDTO;
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
@RequestMapping("/api/consulta_agua")
public class ServiceWaterController {
    @Autowired
    ServiceWaterService serviceWaterService;

    private ServiceWaterDTO convertServiceWaterToServiceWaterDTO(ServiceWater serviceWater){
        ServiceWaterDTO serviceWaterDTO = new ServiceWaterDTO();
        BeanUtils.copyProperties(serviceWater, serviceWaterDTO);
        serviceWaterDTO.setCedula(serviceWater.getContract().getCustomer().getCedula());
        serviceWaterDTO.setNombre(serviceWater.getContract().getCustomer().getNombre());
        serviceWaterDTO.setContrato(serviceWater.getContract().getId());
        return serviceWaterDTO;
    }

    @GetMapping("/cliente/{cedula}")
    public List<ServiceWaterDTO> getServicesWaterByCedula(@PathVariable String cedula){
        List<ServiceWaterDTO> serviceWaterDTOList = new ArrayList<>();
        List<ServiceWater> serviceWaterList = serviceWaterService.retrieveServicesByCedula(cedula);
        ServiceWaterDTO serviceWaterDTO;
        for(ServiceWater serviceWater : serviceWaterList){
            serviceWaterDTO = convertServiceWaterToServiceWaterDTO(serviceWater);
            serviceWaterDTOList.add(serviceWaterDTO);
        }
        return serviceWaterDTOList;
    }

    @GetMapping("/contrato/{contratoId}")
    public List<ServiceWaterDTO> getServicesWaterByContrato(@PathVariable Long contratoId){
        List<ServiceWaterDTO> serviceWaterDTOList = new ArrayList<>();
        List<ServiceWater> serviceWaterList = serviceWaterService.retrieveServicesByContract(contratoId);
        ServiceWaterDTO serviceWaterDTO;
        for(ServiceWater serviceWater : serviceWaterList){
            serviceWaterDTO = convertServiceWaterToServiceWaterDTO(serviceWater);
            serviceWaterDTOList.add(serviceWaterDTO);
        }
        return serviceWaterDTOList;
    }
}
