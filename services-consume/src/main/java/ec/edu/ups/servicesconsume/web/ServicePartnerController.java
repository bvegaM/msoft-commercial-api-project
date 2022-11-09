package ec.edu.ups.servicesconsume.web;

import ec.edu.ups.servicesconsume.entity.ServicePartner;
import ec.edu.ups.servicesconsume.entity.dto.*;
import ec.edu.ups.servicesconsume.entity.request.RequestService;
import ec.edu.ups.servicesconsume.entity.respone.ResponseUserAmmount;
import ec.edu.ups.servicesconsume.entity.respone.ResponseUserContract;
import ec.edu.ups.servicesconsume.entity.respone.ResponseUserPromotions;
import ec.edu.ups.servicesconsume.service.ServicePartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/servicePartners/v1/")
public class ServicePartnerController {

    @Autowired
    private ServicePartnerService partnerService;


    @GetMapping
    public ResponseEntity<List<ServicePartnerDTO>> getServicePartner() {
        List<ServicePartner> serviceList = partnerService.findAll();
        List<ServicePartnerDTO> dtoList = serviceList.stream().map(ServicePartner::convertDTO).collect(Collectors.toList());
        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }


    @GetMapping("/{serviceId}")
    public ResponseEntity<ServicePartnerDTO> getServicePartnerById(@PathVariable Long serviceId) {
        ServicePartner servicePartner = partnerService.findById(serviceId);
        ServicePartnerDTO dto = servicePartner.convertDTO();
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @GetMapping("/code/{serviceCode}")
    public ResponseEntity<ServicePartnerDTO> getServicePartnerByCode(@PathVariable String serviceCode) {
        ServicePartner servicePartner = partnerService.findByCode(serviceCode);
        ServicePartnerDTO dto = servicePartner.convertDTO();
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }


    @GetMapping("/api/services")
    public ResponseEntity<List<ServicesDTO>> getAmmountOfAllServicePartner() {
        List<ServicePartner> serviceList = partnerService.findAll();
        List<ServicesDTO> dtoList = serviceList.stream().map(ServicePartner::convertServiceDTO).collect(Collectors.toList());
        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }


    @PostMapping("/api/services/{service_name}/users")
    public ResponseEntity<List<ResponseUserAmmount>> getAmmountServicePartnerByDNI(@RequestBody RequestService request, @PathVariable String service_name) {
        List<ResponseUserAmmount> dto = partnerService.getAmmountServicePartnerByDNI(request, service_name);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PostMapping("/api/services/{service_name}/contract")
    public ResponseEntity<List<ResponseUserAmmount>> getAmmountServicePartnerByContract(@RequestBody RequestService request, @PathVariable String service_name) {
        List<ResponseUserAmmount> dto = partnerService.getAmmountServicePartnerByContract(request, service_name);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }


    @GetMapping("/api/services/{service_name}/contract")
    public ResponseEntity<List<ResponseUserContract>> getContractServicePartnerByDNI(@RequestBody RequestService request, @PathVariable String service_name) {
        List<ResponseUserContract> dto = partnerService.getContractServicePartnerByDNI(request, service_name);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }


    @GetMapping("/api/services/{service_name}/promotions")
    public ResponseEntity<List<ResponseUserPromotions>> getPromotionsServicePartner(@PathVariable String service_name) {
        List<ResponseUserPromotions> dto = partnerService.getPromotionServicePartner(service_name);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }



    @GetMapping("/api/services/{user_dni}")
    public ResponseEntity<List<ResponseUserAmmount>> getAmmountOfAllServicePartnerByDNI(@PathVariable String user_dni) {
        List<ResponseUserAmmount> list = partnerService.getAmmountOfAllServicePartnerByDNI(user_dni);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }


}
