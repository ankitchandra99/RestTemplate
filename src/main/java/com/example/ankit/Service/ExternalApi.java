package com.example.ankit.Service;

import com.example.ankit.Entity.IpInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ExternalApi {



    RestTemplate restTemplate=new RestTemplate();


    public ResponseEntity<IpInfo> apiCaller(String query ){
        String url="http://ip-api.com/json/"+query;
        System.out.println(url);
        ResponseEntity<IpInfo> responseEntity=restTemplate.getForEntity(url, IpInfo.class);
        //System.out.print(responseEntity);
        return responseEntity;
    }
}
