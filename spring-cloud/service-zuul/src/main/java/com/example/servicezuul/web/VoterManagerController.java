package com.example.servicezuul.web;

import com.example.servicezuul.service.VoterRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VoterManagerController {
    @Autowired
    private VoterRegister voterRegister;
    @RequestMapping("/registerVoter/{voterIp}/{serviceId}")
    public String registerVoter(@PathVariable String voterIp,@PathVariable String serviceId){
        boolean b = voterRegister.registerVoter(voterIp,serviceId);
        return "{\"result\":\""+b+"\"}";
    }
}
