package com.psc.sample.web.service;

import com.psc.sample.web.dto.DefaultDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class WebServiceImpl implements WebService{
    @Override
    public DefaultDto get(String msg) {

        DefaultDto defaultDto = new DefaultDto();
        if(msg == null){
            defaultDto.setMsg("msg is not exist");
            defaultDto.setResult(false);
        }else{
            defaultDto.setMsg(msg);
            defaultDto.setResult(true);
        }
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 1; i<101; i++){
            list.add(i);
        }
        defaultDto.setStringFlux(list);
        return defaultDto;
    }
}
