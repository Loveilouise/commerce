package com.neuesoft.commerce.service;

 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.neuesoft.commerce.mapper.TurnoverMapper;
import com.neuesoft.commerce.pojo.SellerRecord;

import java.rmi.MarshalledObject;
import java.util.ArrayList;

@Controller
public class TurnoverService {

    @Autowired
    private TurnoverMapper turnoverMapper;
 
    /**
     * 查询借卖方流水
     */
    public String backDebitTurnOver(int sid, Model model){
        ArrayList<SellerRecord> turnovers = turnoverMapper.selectAllDebitTurnOverByCompanyId(sid);
        model.addAttribute("turnovers",turnovers);
        return "bvo-gmcwallerAcountList";
    }
}
