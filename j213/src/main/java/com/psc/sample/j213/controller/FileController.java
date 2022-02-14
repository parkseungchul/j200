package com.psc.sample.j213.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
public class FileController {


    @RequestMapping("/cmd")
    public String cmd(Model model){

        String s;
        Process p;

        List<String> results = new ArrayList<String>();
        try {
            //이 변수에 명령어를 넣어주면 된다.
            // 윈도우
            // String[] cmd = {"/bin/sh","-c","pwd"};

            // 리눅스
            String[] cmd = {"cmd","/c","dir"};
            p = Runtime.getRuntime().exec(cmd);
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream() ,"EUC-KR"));
            while ((s = br.readLine()) != null){
                log.debug(s);
                results.add(s);
            }
            p.waitFor();
            System.out.println("exit: " + p.exitValue());
            p.destroy();
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("results", results);

        return "cmd";
    }
}
