package com.psc.sample.j213.controller;

import com.psc.sample.j213.module.Utility;
import lombok.AllArgsConstructor;
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
@AllArgsConstructor
public class CmdController {

    final Utility utility;

    @RequestMapping("/cmd")
    public String cmd(Model model){
        String s;
        Process p;
        List<String> results = new ArrayList<String>();
        try {
            String[] cmd = null;
            String encoding = null;
            if(utility.isWin()){
                cmd = new String[]{"cmd","/c","dir"};
                encoding = "EUC-KR";
            }else{
                cmd = new String[]{"/bin/sh", "-c", "ls -al"};
                encoding = "UTF-8";
            }
            p = Runtime.getRuntime().exec(cmd);
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream() ,encoding));
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
