package com.psc.sample.j213.module;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Slf4j
@Component
public class Utility {

    @Value("${server.path}")
    String path;

    /**
     * is it window?
     * @return
     */
    public boolean isWin(){
        return System.getProperty("os.name").toLowerCase().indexOf("win") != -1?true:false;
    }


    public List<String> cmdReturn(String window, String linux){
        String s;
        Process p;

        File file = new File(path);
        List<String> results = new ArrayList<String>();
        try {
            String[] cmd = null;
            String encoding = null;
            if(isWin()){
                cmd = new String[]{"cmd","/c",window};
                encoding = "EUC-KR";
            }else{
                cmd = new String[]{"/bin/sh", "-c", linux};
                encoding = "UTF-8";
            }
            p = Runtime.getRuntime().exec(cmd, null, file);
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
        return results;
    }

    public void fileUpload(MultipartHttpServletRequest multipartHttpServletRequest) throws IOException {
        Iterator<String> iterator = multipartHttpServletRequest.getFileNames();
        String contentType;

        while(iterator.hasNext()){
            List<MultipartFile> list = multipartHttpServletRequest.getFiles(iterator.next());
            for (MultipartFile multipartFile : list){
                if(multipartFile.isEmpty() == false){
                    contentType = multipartFile.getContentType();
                    if(ObjectUtils.isEmpty(contentType)){
                        break;
                    }
                    File file = new File(path + "/" + multipartFile.getOriginalFilename());
                    multipartFile.transferTo(file);
                }
            }
        }
    }
}
