package com.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.User.Service;
import com.User.User;
import com.alibaba.fastjson.JSON;

@Controller
public class UserController {
	@RequestMapping(value="/getSelect"
			,produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public Object testAjax(@RequestParam String id){
		Service service = new Service();
		List<User> users = service.addUsers();
		String usersStr = JSON.toJSONString(users);
		return usersStr;
	}
	
	@RequestMapping(value="/upload" ,method=RequestMethod.GET)
	public String upload(){
		return "upload";
	}
	@RequestMapping(value="/upload",method=RequestMethod.POST)
	public String upload(String username,@RequestParam("useridpic") MultipartFile[] useridpic,HttpServletRequest request){
		//System.out.println("用户名："+username);
//		if(useridpic.isEmpty()){
//			//System.out.println("tupian");
//			return "upload";
//		}else{
//			String fileName = useridpic.getOriginalFilename();
//			String suffix = fileName.substring(fileName.lastIndexOf("."));
//			Random ran = new Random();
//			String newName = ran.nextInt(1000000)+""+System.currentTimeMillis() + suffix;
//			String savePath = request.getServletContext().getRealPath("idpics");
//			File saveFile = new File(savePath,newName);
//			try {
//				useridpic.transferTo(saveFile);
//			}catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//				request.setAttribute("msg","文件上传失败！");
//				return "upload";
//			}
//			System.out.println(saveFile);
//			request.setAttribute("msg",newName);
//			return "index";
//		}
		String savePath = request.getServletContext().getRealPath("idpics");
		for(int i = 0;i < useridpic.length; i ++){
			String newName = uploadImage(useridpic[i], savePath);
			if(newName != null){
				if(i == 0){
					request.setAttribute("msg1",newName);
				}else{
					request.setAttribute("msg2", newName);
				}
			}
		}
		return "index";
	}
	
	private String uploadImage(MultipartFile multipart,String savePath){
		if(!multipart.isEmpty()){
			String fileName = multipart.getOriginalFilename();
			String suffix = fileName.substring(fileName.lastIndexOf("."));
			Random ran = new Random();
			String newName = ran.nextInt(1000000)+""+System.currentTimeMillis()+suffix;
			File saveFile = new File(savePath,newName);
			try {
				multipart.transferTo(saveFile);
				return newName;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		}else{
			return null;
		}
	}
}
