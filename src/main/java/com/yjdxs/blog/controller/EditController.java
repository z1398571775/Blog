package com.yjdxs.blog.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.yjdxs.blog.service.ArticalService;
import com.yjdxs.blog.utils.Utils;

@Controller
public class EditController {
	static boolean Success;
	@Autowired
	ArticalService articleService;
	@PostMapping("/saveMD")
	@ResponseBody
	public boolean SaveMDText(String title,String introduce,String content) {
		try{		
			int num = articleService.saveArtical(title, introduce, content);
			if(num > 0) {
				Success = true;
			}else {
				Success = false;
			}
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return Success;
	}
	
	public boolean SaveCommentText() {
		
		return Success;
	}
	
	@PostMapping("/saveimg")
	@ResponseBody
	public Map< String, Object> getImage(@RequestParam(value = "editormd-image-file", required = true) MultipartFile file, HttpServletRequest request,HttpServletResponse response,MultipartFile attach)
	{
		String rootPath = request.getSession().getServletContext().getRealPath("/image");
		System.out.println(rootPath);
		File filePath = new File(rootPath);
        if (!filePath.exists()) {
            filePath.mkdirs();
        }
		String trueFileName = file.getOriginalFilename();
        String suffix = trueFileName.substring(trueFileName.lastIndexOf("."));
        String fileName = Utils.GetUUID()+suffix;
        File targetFile = new File(rootPath, fileName);
        
        System.out.println("图片的路径："+targetFile.getPath());
        try {
			file.transferTo(targetFile);
			articleService.saveImage(targetFile);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }
        Map<String, Object> res = new HashMap<String,Object>();
        res.put("url","/image/"+fileName);
        res.put("success", 1);
        res.put("message", "upload success!");
		return res;
	}

}
