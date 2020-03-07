package com.neuesoft.commerce.controller;

import com.neuesoft.commerce.pojo.CompanyRecord;
import com.neuesoft.commerce.pojo.SellerRecord;
import com.neuesoft.commerce.service.AuditService;
import com.neuesoft.commerce.vo.AuditVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuditController {
    /*@Autowired
    private CompanyRecord crecord;
    @Autowired
    private SellerRecord srecord;*/
    @Autowired
    private AuditService auditService;
    //展示全部流水

    @RequestMapping("/admin-withdraw-audit")
    public String showrlist( Model model){
        return auditService.showallrecords(model);
    }
  /*  //审核
    @RequestMapping("/audit")
    public String Audit(@RequestParam("cr_status") int status, CompanyRecord crecord,SellerRecord srecord, Model model){
//        System.out.println(crecord.getCr_id());
        return auditService.audit(status,srecord, crecord,model);
    }*/
    
    @RequestMapping("updateAudit")
    @ResponseBody
    public void updateAudit(@RequestBody AuditVo obj) {
    	System.out.println(obj.getType()+"nishigesha");
    	auditService.updateMoney(obj);
    }
}
