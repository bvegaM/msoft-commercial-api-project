package ec.edu.ups.servicesconsume.service;

import ec.edu.ups.servicesconsume.entity.ApiDetail;
import ec.edu.ups.servicesconsume.entity.ServicePartner;
import ec.edu.ups.servicesconsume.entity.dto.*;
import ec.edu.ups.servicesconsume.entity.request.RequestService;
import ec.edu.ups.servicesconsume.entity.respone.ResponseUserAmmount;
import ec.edu.ups.servicesconsume.entity.respone.ResponseUserContract;
import ec.edu.ups.servicesconsume.entity.respone.ResponseUserPromotions;
import ec.edu.ups.servicesconsume.enums.ApiMethod;
import ec.edu.ups.servicesconsume.enums.ApiType;
import ec.edu.ups.servicesconsume.repository.ServicePartnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ServicePartnerServiceImpl implements  ServicePartnerService {

    @Autowired
    private ServicePartnerRepository servicePartnerRepository;

    @Autowired
    private RestTemplate restTemplate;

    private List<ResponseUserAmmount> responseUserAmmount;
    private List<ResponseUserContract> responseUserContract;
    private List<ResponseUserPromotions> responseUserPromotions;
    private boolean reset_variables = true;


    @Override
    public List<ServicePartner> findAll() {
        return (List<ServicePartner>) servicePartnerRepository.findAll();
    }

    @Override
    public ServicePartner findById(Long id) {
        Optional<ServicePartner> optional = servicePartnerRepository.findById(id);
        ServicePartner servicePartner = optional.orElseThrow();
        return servicePartner;
    }

    @Override
    public ServicePartner findByCode(String code) {
        Optional<ServicePartner> optional = servicePartnerRepository.findByCode(code);
        ServicePartner servicePartner = optional.orElseThrow();
        return servicePartner;
    }


    @Override
    public List<ResponseUserAmmount> getAmmountServicePartnerByDNI(RequestService request, String service_name) {
        reset_variables = true;
        getAmmountServicePartner(request, service_name, ApiType.AMMOUNT, "dni");
        return this.responseUserAmmount;
    }

    @Override
    public List<ResponseUserAmmount> getAmmountServicePartnerByContract(RequestService request, String service_name) {
        reset_variables = true;
        getAmmountServicePartner(request, service_name, ApiType.AMMOUNT, "contract");
        return this.responseUserAmmount;
    }

    @Override
    public List<ResponseUserContract> getContractServicePartnerByDNI(RequestService request, String service_name) {
        reset_variables = true;
        getAmmountServicePartner(request, service_name, ApiType.CONTRACT, "dni");
        return this.responseUserContract;
    }

    @Override
    public List<ResponseUserPromotions> getPromotionServicePartner(String service_name) {
        reset_variables = true;
        RequestService request = new RequestService("", "");
        getAmmountServicePartner(request, service_name, ApiType.PROMOTION, "date");
        return this.responseUserPromotions;
    }

    @Override
    public List<ResponseUserAmmount> getAmmountOfAllServicePartnerByDNI(String user_dni) {
        RequestService request = new RequestService(user_dni, "");
        reset_variables = true;

        List<ServicePartner> list = (List<ServicePartner>) servicePartnerRepository.findAll();
        list.stream().forEach((item) -> {
            getAmmountServicePartner(request, item.getCode(), ApiType.AMMOUNT, "dni");
            reset_variables = false;
        });

        return this.responseUserAmmount;
    }

    private void getAmmountServicePartner(RequestService request, String service_name, ApiType apiType, String type) {
        Optional<ServicePartner> optional = servicePartnerRepository.findByCode(service_name);
        ServicePartner servicePartner = optional.orElseThrow();

        List<ApiDetail> apiDetails = servicePartner.getApiDetails().stream()
                .filter(item -> apiType.equals(item.getType()))
                .filter(item -> item.getUri().contains("{{" + type + "}}") || item.getBody().contains("{{" + type + "}}") )
                .collect(Collectors.toList());

        if(reset_variables) {
            this.responseUserAmmount = new ArrayList<>();
            this.responseUserContract = new ArrayList<>();
            this.responseUserPromotions = new ArrayList<>();
        }

        apiDetails.stream().forEach((item) -> {
            item.setUri(request.getStringReplace(item.getUri()));
            item.setBody(request.getStringReplace(item.getBody()));
            if(apiType.equals(ApiType.AMMOUNT)) {
                switch (service_name) {
                    case "S0001": FindAmmountService_S0001(item); break;
                    case "S0002": FindAmmountService_S0002(item);  break;
                }
            }
            if(apiType.equals(ApiType.CONTRACT)) {
                switch (service_name) {
                    case "S0001": FindContractService_S0001(item); break;
                }
            }
            if(apiType.equals(ApiType.PROMOTION)) {
                switch (service_name) {
                    case "S0002": FindPromotionService_S0002(item); break;
                }
            }
        });

        if(this.responseUserAmmount != null) {
            this.responseUserAmmount.stream().forEach((item) -> {
                item.setServiceCode(servicePartner.getCode());
                item.setServiceName(servicePartner.getName());
            });
        }
        if(this.responseUserContract != null) {
            this.responseUserContract.stream().forEach((item) -> {
                item.setServiceCode(servicePartner.getCode());
                item.setServiceName(servicePartner.getName());
            });
        }
        if(this.responseUserPromotions != null) {
            this.responseUserPromotions.stream().forEach((item) -> {
                item.setServiceCode(servicePartner.getCode());
                item.setServiceName(servicePartner.getName());
            });
        }
    }

    private void FindAmmountService_S0001(ApiDetail detail) {
        ResponseEntity<S0001_ServiceWaterAmmountDTO[]> response = null;
        if(ApiMethod.GET.equals(detail.getMethod())) {
            response = restTemplate.getForEntity(detail.getUri(), S0001_ServiceWaterAmmountDTO[].class);
        } else {
            response = restTemplate.postForEntity(detail.getUri(), detail.getHTTPBody(), S0001_ServiceWaterAmmountDTO[].class);
        }
        if(response == null) { throw  new RuntimeException("Error al consultar el detalle del servicio!!!"); }
        S0001_ServiceWaterAmmountDTO[] dtos = response.getBody();
        if(dtos == null) { throw  new RuntimeException("Error al consultar el detalle del servicio!!!"); }

        Arrays.stream(dtos).forEach((item) -> {
            this.responseUserAmmount.add(item.convertoToResponseUser());
        });
    }

    private void FindAmmountService_S0002(ApiDetail detail) {
        ResponseEntity<S0002_DirectvAmountDTO[]> response = null;
        if(ApiMethod.GET.equals(detail.getMethod())) {
            response = restTemplate.getForEntity(detail.getUri(), S0002_DirectvAmountDTO[].class);
        } else {
            response = restTemplate.postForEntity(detail.getUri(), detail.getHTTPBody(), S0002_DirectvAmountDTO[].class);
        }
        if(response == null) { throw  new RuntimeException("Error al consultar el detalle del servicio!!!"); }
        S0002_DirectvAmountDTO[] dtos = response.getBody();
        if(dtos == null) { throw  new RuntimeException("Error al consultar el detalle del servicio!!!"); }

        Arrays.stream(dtos).forEach((item) -> {
            this.responseUserAmmount.add(item.convertoToResponseUser());
        });
    }

    private void FindContractService_S0001(ApiDetail detail) {
        ResponseEntity<S0001_ServiceWaterContractDTO[]> response = null;
        if(ApiMethod.GET.equals(detail.getMethod())) {
            response = restTemplate.getForEntity(detail.getUri(), S0001_ServiceWaterContractDTO[].class);
        } else {
            response = restTemplate.postForEntity(detail.getUri(), detail.getHTTPBody(), S0001_ServiceWaterContractDTO[].class);
        }
        if(response == null) { throw  new RuntimeException("Error al consultar el detalle del servicio!!!"); }
        S0001_ServiceWaterContractDTO[] dtos = response.getBody();
        if(dtos == null) { throw  new RuntimeException("Error al consultar el detalle del servicio!!!"); }

        Arrays.stream(dtos).forEach((item) -> {
            this.responseUserContract.add(item.convertToResponseUser());
        });
    }

    private void FindPromotionService_S0002(ApiDetail detail) {
        ResponseEntity<S0002_DirectvPromotionDTO[]> response = null;
        if(ApiMethod.GET.equals(detail.getMethod())) {
            response = restTemplate.getForEntity(detail.getUri(), S0002_DirectvPromotionDTO[].class);
        } else {
            response = restTemplate.postForEntity(detail.getUri(), detail.getHTTPBody(), S0002_DirectvPromotionDTO[].class);
        }
        if(response == null) { throw  new RuntimeException("Error al consultar el detalle del servicio!!!"); }
        S0002_DirectvPromotionDTO[] dtos = response.getBody();
        if(dtos == null) { throw  new RuntimeException("Error al consultar el detalle del servicio!!!"); }

        Arrays.stream(dtos).forEach((item) -> {
            this.responseUserPromotions.add(item.convertToResponseUser());
        });
    }


}
