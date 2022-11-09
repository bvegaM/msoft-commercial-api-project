package ec.edu.ups.servicesconsume.web;

import ec.edu.ups.servicesconsume.entity.ServicePartner;
import ec.edu.ups.servicesconsume.entity.dto.*;
import ec.edu.ups.servicesconsume.entity.request.RequestService;
import ec.edu.ups.servicesconsume.entity.respone.ResponseUserAmount;
import ec.edu.ups.servicesconsume.entity.respone.ResponseUserContract;
import ec.edu.ups.servicesconsume.entity.respone.ResponseUserPromotions;
import ec.edu.ups.servicesconsume.service.ServicePartnerService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@ApiResponses(value={
        @ApiResponse(code=400, message = "Bad request. Check out the documentation"),
        @ApiResponse(code=401, message = "Unauthorized call")
})
@RestController
@RequestMapping("/servicePartners/v1/")
public class ServicePartnerController {

    @Autowired
    private ServicePartnerService partnerService;

    @ApiOperation(value = "Get a list of all services supplied by business partners, plus its offered consumption services. For internal use purposes only.")
    @GetMapping
    public ResponseEntity<List<ServicePartnerDTO>> getServicePartner() {
        List<ServicePartner> serviceList = partnerService.findAll();
        List<ServicePartnerDTO> dtoList = serviceList.stream().map(ServicePartner::convertDTO).collect(Collectors.toList());
        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }

    @ApiOperation(value = "Get details about a specific service partner based on its unique identifier. For internal use purposes only.")
    @GetMapping("/{service-id}")
    public ResponseEntity<ServicePartnerDTO> getServicePartnerById(@PathVariable("service-id") Long serviceId) {
        ServicePartner servicePartner = partnerService.findById(serviceId);
        ServicePartnerDTO dto = servicePartner.convertDTO();
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @ApiOperation(value = "Get details about a specific service partner based on its service code. For internal use purposes only.")
    @GetMapping("/code/{service-code}")
    public ResponseEntity<ServicePartnerDTO> getServicePartnerByCode(@PathVariable("service-code") String serviceCode) {
        ServicePartner servicePartner = partnerService.findByCode(serviceCode);
        ServicePartnerDTO dto = servicePartner.convertDTO();
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @ApiOperation(value="Get a basic list of all services available for client consumption.")
    @GetMapping("/api/services")
    public ResponseEntity<List<ServicesDTO>> getAmountOfAllServicePartner() {
        List<ServicePartner> serviceList = partnerService.findAll();
        List<ServicesDTO> dtoList = serviceList.stream().map(ServicePartner::convertServiceDTO).collect(Collectors.toList());
        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }

    @ApiOperation(value="Get pending debts of an user for a specific service, based on his DNI")
    @PostMapping("/api/services/{service-name}/users")
    public ResponseEntity<List<ResponseUserAmount>> getAmountServicePartnerByDNI(@RequestBody RequestService request, @PathVariable("service-name") String serviceName) {
        List<ResponseUserAmount> dto = partnerService.getAmountServicePartnerByDNI(request, serviceName);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @ApiOperation(value="Get pending debts of an user for a specific service, based on his contract number")
    @PostMapping("/api/services/{service-name}/contract")
    public ResponseEntity<List<ResponseUserAmount>> getAmountServicePartnerByContract(@RequestBody RequestService request, @PathVariable("service-name") String serviceName) {
        List<ResponseUserAmount> dto = partnerService.getAmountServicePartnerByContract(request, serviceName);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @ApiOperation(value="Get contract information of an user for a specific service name")
    @GetMapping("/api/services/{service-name}/contract")
    public ResponseEntity<List<ResponseUserContract>> getContractServicePartnerByDNI(@RequestBody RequestService request, @PathVariable("service-name") String serviceName) {
        List<ResponseUserContract> dto = partnerService.getContractServicePartnerByDNI(request, serviceName);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @ApiOperation(value = "Get available promotions for a specific service")
    @GetMapping("/api/services/{service-name}/promotions")
    public ResponseEntity<List<ResponseUserPromotions>> getPromotionsServicePartner(@PathVariable("service-name") String serviceName) {
        List<ResponseUserPromotions> dto = partnerService.getPromotionServicePartner(serviceName);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @ApiOperation(value = "Get pending debts of an user from all specific service, based on his DNI")
    @GetMapping("/api/services/{user-dni}")
    public ResponseEntity<List<ResponseUserAmount>> getAmountOfAllServicePartnerByDNI(@PathVariable(name = "user_dni") String userDni) {
        List<ResponseUserAmount> list = partnerService.getAmountOfAllServicePartnerByDNI(userDni);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

}
