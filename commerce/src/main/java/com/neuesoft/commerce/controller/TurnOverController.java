package com.neuesoft.commerce.controller;

 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.neuesoft.commerce.service.TurnoverService;

@Controller
public class TurnOverController {

    @Autowired
    private TurnoverService turnoverService;

     
    /**
     * 借卖商流水显示逻辑
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/backDebitTurnOver/{sid}")
    public String backDebitTurnOver(@PathVariable int sid, Model model){
        System.out.println("back debit turnover info");
        return turnoverService.backDebitTurnOver(sid,model);
    }
}
