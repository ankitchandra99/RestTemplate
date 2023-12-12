package com.example.ankit.Controller;


import com.example.ankit.Entity.IpInfo;
import com.example.ankit.Service.IpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController

public class IpInfoController {

    @Autowired
    private IpService ipService;

    @PostMapping("/ip-info")
    public ResponseEntity<IpInfo> getIpInfo(@RequestBody Map<String, String> request) {
        String ipAddress = request.get("ip_address");
        if (ipAddress == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        IpInfo ipInfo = ipService.getDetails(ipAddress);
        return new ResponseEntity<>(ipInfo, HttpStatus.OK);
    }
}
