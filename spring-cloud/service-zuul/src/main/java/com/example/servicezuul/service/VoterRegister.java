package com.example.servicezuul.service;

import com.example.servicezuul.event.RefreshRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.test.annotation.Rollback;

@Service
public class VoterRegister {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private RefreshRouteService refreshRouteService;
    @Rollback(false)
    public boolean registerVoter(String voterIp,String serviceId){
        String sql="INSERT INTO gateway_api_define (id, path, service_id, retryable, strip_prefix, url, enabled) VALUES (?, ?, null,0,1, ?, 1);";
        int a = jdbcTemplate.update(sql,serviceId,"/"+serviceId+"/**","http://"+voterIp+":8092");
        if(a!=0){

            return true;
        }else{
            return false;
        }
    }

}
