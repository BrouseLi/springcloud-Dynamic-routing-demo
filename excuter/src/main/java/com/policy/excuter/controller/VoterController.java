package com.policy.excuter.controller;

import com.policy.excuter.util.SystemUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VoterController {
    @RequestMapping("/voterStrategy")
    public String majorityVoting(@RequestParam(name = "policy")String policy){
        switch (policy){
            case "majorityVoting":
                if(!"".equals(SystemUtil.excuteShell("/home/majority.sh"))){
                    return "success";
                }else{
                    return "error";
                }
            case "consensusVoting":
                if(!"".equals(SystemUtil.excuteShell("/home/consensus.sh"))){
                    return "success";
                }else{
                    return "error";
                }
        }
        return policy;
    }
    @RequestMapping("/setupSoft")
    public String setupSoftWare(@RequestParam(name = "nginx")String filename){
        String result=SystemUtil.excuteShell("wget http://ip/"+filename+" /home/software");
        String result1=SystemUtil.excuteShell("/home/setup.sh");
        if (!"".equals(result)&&!"".equals(result1)){
            return "success";
        }else{
            return "error";
        }
    }
}
