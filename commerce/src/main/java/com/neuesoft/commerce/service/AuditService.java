package com.neuesoft.commerce.service;

import com.neuesoft.commerce.mapper.AuditMapper;
import com.neuesoft.commerce.pojo.CompanyRecord;
import com.neuesoft.commerce.pojo.SellerRecord;
import com.neuesoft.commerce.vo.AuditVo;
import com.neuesoft.commerce.vo.CompanyAccountRecordVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.ArrayList;

@Service
public class AuditService {
        @Autowired
    private AuditMapper auditMapper;

        public String showallrecords(Model model){
        	  	
        	/* ArrayList<CompanyAccountRecordVo> accountRecordlist = new ArrayList<CompanyAccountRecordVo>();
        	
        	 CompanyAccountRecordVo  carv = new CompanyAccountRecordVo();       	*/        	
            //显示流水
            ArrayList<CompanyRecord> calist=new ArrayList<CompanyRecord>();
            calist=auditMapper.showallCrecords();
           
//            System.out.println(calist);
           model.addAttribute("calist",calist);
            System.out.println("calist"+calist.size());

            ArrayList<SellerRecord> salist=new ArrayList<SellerRecord>();
            salist=auditMapper.showallSrecords();
            model.addAttribute("salist",salist);
            System.out.println("salist"+salist.size());
            return "admin-withdraw-audit";

        }
      
        
        public void updateMoney(AuditVo obj) {
        	int status=obj.getStatus();
        	if(obj.getType().equals("提现")) {
        		if(status==1) {
        			float yue = auditMapper.queryMoney2(obj.getId()).getCa_money() -obj.getMoney();
        			auditMapper.divMoney(obj.getId(), yue);
        		}
        		auditMapper.updateCaStatus(obj.getId(), obj.getStatus());
        	}
        	else if(obj.getType().equals("充值")) {
        		if(status==1) {
        			float primary=auditMapper.queryMoney(obj.getId()).getSa_money();
        			float total=primary+obj.getMoney();
        			auditMapper.addMoney(obj.getId(), total);;
        		}
        		auditMapper.updateCaStatus2(obj.getId(), obj.getStatus());
        	}
        }
        
       
}
