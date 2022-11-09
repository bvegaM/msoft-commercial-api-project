package ec.edu.ups.servicesconsume.service;

import ec.edu.ups.servicesconsume.entity.ServicePartner;
import ec.edu.ups.servicesconsume.entity.request.RequestService;
import ec.edu.ups.servicesconsume.entity.respone.ResponseUserAmount;
import ec.edu.ups.servicesconsume.entity.respone.ResponseUserContract;
import ec.edu.ups.servicesconsume.entity.respone.ResponseUserPromotions;

import java.util.List;

public interface ServicePartnerService {

    public List<ServicePartner> findAll();

    public ServicePartner findById(Long id);

    public ServicePartner findByCode(String code);

    public List<ResponseUserAmount> getAmountServicePartnerByDNI(RequestService request, String service_name);

    public List<ResponseUserAmount> getAmountServicePartnerByContract(RequestService request, String service_name);

    public List<ResponseUserContract>  getContractServicePartnerByDNI(RequestService request, String service_name);

    public List<ResponseUserPromotions>  getPromotionServicePartner(String service_name);

    public  List<ResponseUserAmount> getAmountOfAllServicePartnerByDNI(String user_dni);



}
