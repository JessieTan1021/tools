package com.smartshop.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.smartshop.common.util.ExportUtil;
import com.smartshop.mongo.MongoSmartShop;
import com.smartshop.vo.CameraDetailModel;

public class Demo {
    
    @RequestMapping("/camera/excel")
    public void downloadExcel(
            @RequestParam(required = false) String batchNo, 
            @RequestParam(required = false) String cameraType, // 全景：113, 人脸：112
            @RequestParam(required = false) Integer status, // 在库：1，出库：0
            @RequestParam(required = false) Integer isInstall, // 已安装：1，未安装：0
            @RequestParam(required = false) String uid,
            @RequestParam(required = false) String company,
            @RequestParam(required = false) String city, 
            HttpServletResponse response){
        
        String fileName = "device";
        setFileName(response, fileName);
        
        ExportUtil<CameraDetailModel> exportUtil = new ExportUtil<>();
        
        Criteria criteria = getCameraDetailCriteria(batchNo, cameraType, status, isInstall, uid, company, city);
        
        Query query = Query.query(criteria);
        
        List<CameraDetailModel> listData = mongoTemplate.find(query, CameraDetailModel.class, MongoSmartShop.CAMERA_INFO);
        
        try {
            exportUtil.exportCsvFile(response.getOutputStream(), fileName, listData, CameraDetailModel.class);
        } catch (IOException e) {
            log.info("export fail at controller method exportUserProfiles()"+e.getMessage());
        }
    }
    
    private void setFileName(HttpServletResponse response,String fileName){
        response.setContentType("application/csv");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".csv");
    }

}
