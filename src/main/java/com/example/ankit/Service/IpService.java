package com.example.ankit.Service;

import com.example.ankit.Entity.IpInfo;
import com.example.ankit.Repository.IpInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IpService {
    @Autowired
    IpInfoRepository ipInfoRepository;
   @Autowired
    ExternalApi externalApi;
    public void saveDetails(IpInfo ipInfo){

        ipInfoRepository.save(ipInfo);
    }
    public IpInfo getDetails(String ipAddress){
       Optional<IpInfo> ipInfo= ipInfoRepository.findByQuery(ipAddress);
       if(ipInfo.isPresent()){
           return ipInfo.get();
       }
       else{
           ResponseEntity<IpInfo> response=externalApi.apiCaller(ipAddress);
           ipInfoRepository.save(response.getBody());
           return response.getBody();
       }
    }
}
