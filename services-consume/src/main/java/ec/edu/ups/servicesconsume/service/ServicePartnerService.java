package ec.edu.ups.servicesconsume.service;

import ec.edu.ups.servicesconsume.entity.ServicePartner;
import ec.edu.ups.servicesconsume.entity.request.RequestService;
import ec.edu.ups.servicesconsume.entity.respone.ResponseUserAmmount;
import ec.edu.ups.servicesconsume.entity.respone.ResponseUserContract;
import ec.edu.ups.servicesconsume.entity.respone.ResponseUserPromotions;

import java.util.List;

public interface ServicePartnerService {

    public List<ServicePartner> findAll();

    public ServicePartner findById(Long id);

    public ServicePartner findByCode(String code);


    public List<ResponseUserAmmount>  getAmmountServicePartnerByDNI(RequestService request, String service_name);

    public List<ResponseUserAmmount>  getAmmountServicePartnerByContract(RequestService request, String service_name);

    public List<ResponseUserContract>  getContractServicePartnerByDNI(RequestService request, String service_name);

    public List<ResponseUserPromotions>  getPromotionServicePartner(String service_name);


    public  List<ResponseUserAmmount> getAmmountOfAllServicePartnerByDNI(String user_dni);



}
