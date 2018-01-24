package com.smartshop.vo;

import java.util.Date;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

import com.smartshop.common.util.ExportConfig;

public class CameraDetailModel {
    
    @ExportConfig(name="批次")
    private String batch_no;
    
    @ExportConfig(name="UID")
    private String uid;
    
    @ExportConfig(name="摄像头类型")
    private String camera_type;
    
    private int status;  // 库存状态（1：在库；0：出库）
    
    @ExportConfig(name="库存状态")
    private String statuStr;
    
    private Date init_time;
    
    @ExportConfig(name="初始时间")
    private String initTimeStr;
    
    private Date update_time;
    
    @ExportConfig(name="更新时间")
    private String updateTimeStr;
    
    private int is_install;
    
    @ExportConfig(name="是否安装")
    private String isInstallStr;
    
    private int is_broken;
    
    @ExportConfig(name="是否损坏")
    private String isBrokenStr;
    
    @ExportConfig(name="安装门店")
    private String shop_name;
    
    @ExportConfig(name="公司名称")
    private String company;
    
    @ExportConfig(name="城市")
    private String address;
    
    @ExportConfig(name="经手人")
    private String user_name;
    
    @ExportConfig(name="备注")
    private String remark;

    public String getBatch_no() {
        return batch_no;
    }

    public void setBatch_no(String batch_no) {
        this.batch_no = batch_no;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getCamera_type() {
        return camera_type.equals("112") ? "人脸" : "全景";
    }

    public void setCamera_type(String camera_type) {
        this.camera_type = camera_type;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getInit_time() {
        return init_time;
    }

    public void setInit_time(Date init_time) {
        this.init_time = init_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public int getIs_install() {
        return is_install;
    }

    public void setIs_install(int is_install) {
        this.is_install = is_install;
    }

    public int getIs_broken() {
        return is_broken;
    }

    public void setIs_broken(int is_broken) {
        this.is_broken = is_broken;
    }

    public String getShop_name() {
        return shop_name;
    }

    public void setShop_name(String shop_name) {
        this.shop_name = shop_name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getStatuStr() {
        
        if(status == 0){
            return "出库";
        }
        
        return "在库";
    }

    public String getIsInstallStr() {
        
        if(is_install == 0){
            return "否";
        }
        return "是";
    }

    public String getIsBrokenStr() {
        if(is_broken == 0){
            return "否";
        }
        
        return "是";
    }

    public String getInitTimeStr() {
        if(init_time == null){
            return "";
        }
        return DateFormatUtils.format(init_time, "yyyy-MM-dd");
    }

    public String getUpdateTimeStr() {
        if(update_time == null){
            return "";
        }
        return DateFormatUtils.format(update_time, "yyyy-MM-dd");
    }
    
    
    
}
