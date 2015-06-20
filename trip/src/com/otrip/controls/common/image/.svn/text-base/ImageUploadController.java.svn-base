package com.otrip.controls.common.image;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.otrip.controls.BaseController;
import com.otrip.controls.trip.activity.ActiInfoPubController;
import com.otrip.domain.DomainUtils;
import com.otrip.domain.system.OtImage;
import com.otrip.domain.trip.OtActiInfo;
import com.otrip.service.system.ImageService;

/**   
 * @Filename:    ImageUploadController.java
 * @Copyright:   Copyright (c)2015  
 * @Company:     otrip 
 * @Author:      zhongJc  
 * @version:     v1.0   
 * @since:  	 JDK 1.7.0_21  
 * @Create at:   2015年4月12日 下午10:06:36  
 * @Description: 实现异步图片上传
 *   
 * Modification History:   
 * Date    		 Author       Version     Description   
 * ----------------------------------------------------------------- 
 * 2015年4月12日 	 	 zhongJc      1.0     	  1.0 Version   
 */
@Controller
@RequestMapping("/common/image")
public class ImageUploadController extends BaseController implements ServletContextAware{
	static Logger log=Logger.getLogger(ImageUploadController.class);
	
	private static final String UPLOAD_PATH="/otImage";
	
	private ServletContext servletContext;
	public void setServletContext(ServletContext servletContext) { // 实现接口中的setServletContext方法
		this.servletContext = servletContext;
	}
	
	private ImageService imageService;
	@Autowired
	public void setImageService(ImageService imageService) {
		this.imageService = imageService;
	}
	
	/**
	 * @see 异步上传文件
	 * @param uFile
	 * @param request
	 * @param response
	 * @param otImage
	 * @param result
	 * @throws Exception
	 */
	@SuppressWarnings("static-access")
	@RequestMapping(value="/upload.html",method={RequestMethod.POST})
	@ResponseBody
	public String uploadPhoto(@RequestParam("pic") CommonsMultipartFile pic,@ModelAttribute("otImage") OtImage otImage, HttpServletRequest request, HttpServletResponse response)throws Exception{
		final String[] suff = { ".jpg", ".jpeg", ".bmp", ".gif",".png" }; 
		super.operatro_state_code_object.put(super.operator_state_code, "fail");
		log.info(otImage.getFsObjTabName()+"::objId:"+otImage.getFsObjId());
		String tabName=otImage.getFsObjTabName();
		String tableName=null;//业务关联表名
		String saveDir=null;//存放图片的文件夹
		if(tabName.equals("ot_acti_day")) //活动日程图片
		{
			saveDir="acti_days";
			otImage.setFsObjTabName("ot_acti_day");
			otImage.setFsObjSign("活动详情图片");
			tableName="ot_acti_day";  
		}
		else if(tabName.equals("ot_acti_info"))//活动封面图片
		{
			saveDir="acti_info";
			tableName="ot_acti_info";
			otImage.setFsObjTabName("ot_acti_info");
			otImage.setFsObjSign("活动封面图片");
			
		}
		else if(tabName.equals("ot_acti_type"))
		{
			saveDir="acti_type";
			tableName="ot_acti_type";
			otImage.setFsObjTabName("ot_acti_type");
			otImage.setFsObjSign("活动类型图片");
		}
		else if(tabName.equals("ot_icon"))//图标
		{
			saveDir="acti_icon";
			tableName="ot_image";
		}
		else
		{ 
			saveDir="default";
			tableName="default";
			otImage.setFsObjTabName("default");
			otImage.setFsObjSign("图片暂未使用");
		}
		if (!pic.isEmpty()) {
			String picFileName=pic.getOriginalFilename();
			log.info("picFileName:"+picFileName);
	       if (pic == null || pic.getSize()> 4194304) {  //文件过大// 限定文件大小是4MB  
	    	   super.operatro_state_code_object.put(super.operator_state_code, "fail");
	       }  
	       for (String s : suff) {  
	    	   if (picFileName.endsWith(s)) {  
	    		   String realPath = servletContext.getRealPath(UPLOAD_PATH);// 在Tomcat中保存图片的实际路径  ==  "webRoot/uploadpic/"
	    		   log.info("realPath: "+servletContext.getRealPath("/"));
	    		   String realSavePath=realPath+File.separator+saveDir;
	    
	    		   final String newSaveFileName=DomainUtils.generalUuid()+ s;
	    		   String savePath=realSavePath+File.separator+newSaveFileName;
	    		   log.info("savePath:"+savePath);
	
	    		   //File saveFile = new File(new File(realPath), newSaveFileName); // 在该实际路径下实例化一个文件 
	    		  // log.info(" path:"+realPath+File.separator+newSaveFileName+";name:"+picFileName);
	               //if (!saveFile.getParentFile().exists()) {  // 判断父目录是否存在  
	               //     saveFile.getParentFile().mkdirs();  
	              // }  
	              // FileUtils.copyInputStreamToFile(pic.getInputStream(),saveFile);
	               
	               File imageFile=new File(savePath);
            	   if(!imageFile.getParentFile().exists())
            	   {
            		   imageFile.getParentFile().mkdirs();
            	   }
            	   FileUtils.copyInputStreamToFile(pic.getInputStream(), imageFile);
	               
	               super.operatro_state_code_object.put("path", File.separator+newSaveFileName);
	               otImage.setFsId(DomainUtils.generalUuid());
	               //otImage.setFsPath(this.UPLOAD_PATH+File.separator+newSaveFileName);
	               otImage.setFsName(picFileName);
	               otImage.setFdCreateTime(new Date());
	               otImage.setFsContentType(pic.getContentType());
	               otImage.setFsUrl(savePath.substring(savePath.indexOf("otImage")-1));
	               imageService.saveOtImage(otImage);
	               super.operatro_state_code_object.put(super.operator_state_code, "success");
	    	   }
	       }
		}
		return super.operatro_state_code_object.toString();
	}
	
	/**
	 * @see 删除图片
	 * @param request
	 * @param response
	 * @param id
	 * @return
	 * @throws Exception 
	 */
	@SuppressWarnings("static-access")
	@RequestMapping(value="/delete.html",params="json",method=RequestMethod.POST)
	@ResponseBody
	public String delete(HttpServletRequest request,HttpServletResponse response,@RequestParam("id") String id) throws Exception{		 
		 if(StringUtils.isNotBlank(id)){
 			log.info("delete Resources id:"+id);
 			//resourceService.delSysResourceById(id);
 			imageService.deleteRealFile(id, servletContext.getRealPath("/"));
 			imageService.deleteOtImageById(id);
 			super.operatro_state_code_object.put(super.operator_state_code, "success");
 		}else{
 			super.operatro_state_code_object.put(super.operator_state_code, "fail");
 		}
		log.info(" Operator status#####:"+super.operatro_state_code_object.toString());
		return super.operatro_state_code_object.toString();
	}
	
	@InitBinder("otImage")      
	public void initBinder1(ServletRequestDataBinder binder) throws Exception{              
		binder.setFieldDefaultPrefix("im.");     
	}  

}
