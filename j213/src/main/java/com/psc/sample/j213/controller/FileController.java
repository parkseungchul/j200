package com.psc.sample.j213.controller;

import com.psc.sample.j213.module.Utility;
import lombok.AllArgsConstructor;
import org.apache.commons.io.FileUtils;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.net.URLEncoder;

@Controller
public class FileController {

    @Value("${server.path}")
    String path;

    @Autowired
    private Utility utility;

    @RequestMapping(value = {"/fileView"}, method = RequestMethod.GET)
    public String file(Model model){
        model.addAttribute("results", utility.cmdReturn("dir/b", "ls"));
        return "file";
    }

    @RequestMapping(value = {"/file"}, method = RequestMethod.POST)
    public String fileUpload(MultipartHttpServletRequest multipartHttpServletRequest) throws Exception {
        utility.fileUpload(multipartHttpServletRequest);
        return "redirect:/fileView";
    }
    @RequestMapping(value = {"/file"}, method = RequestMethod.GET)
    public String downloadBoardFile(String fileName, String del, HttpServletResponse response) throws Exception{

       if(del.equals("N")){
           byte[] files = FileUtils.readFileToByteArray(new File(path +"/" + fileName));
           response.setContentType("application/octet-stream");
           response.setContentLength(files.length);
           response.setHeader("Content-Disposition", "attachment; fileName=\"" + URLEncoder.encode(fileName,"UTF-8")+"\";");
           response.setHeader("Content-Transfer-Encoding", "binary");

           response.getOutputStream().write(files);
           response.getOutputStream().flush();
           response.getOutputStream().close();
       }else{
           File file = new File(path +"/" + fileName);
           file.delete();
       }
        return "redirect:/fileView";
        }
}
