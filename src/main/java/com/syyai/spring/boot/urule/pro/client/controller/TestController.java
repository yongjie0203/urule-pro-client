package com.syyai.spring.boot.urule.pro.client.controller;

import java.io.IOException;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bstek.urule.Utils;
import com.bstek.urule.runtime.KnowledgePackage;
import com.bstek.urule.runtime.KnowledgeSession;
import com.bstek.urule.runtime.KnowledgeSessionFactory;
import com.bstek.urule.runtime.service.KnowledgeService;
import com.syyai.spring.boot.urule.pro.domain.Test;

@RestController
@RequestMapping("test")
public class TestController {

		@RequestMapping("/rule")
	    public Object rule() throws IOException {
	    	//创建一个KnowledgeSession对象
	        KnowledgeService knowledgeService = (KnowledgeService) Utils.getApplicationContext().getBean(KnowledgeService.BEAN_ID);
	        KnowledgePackage knowledgePackage = knowledgeService.getKnowledge("test/test");
	        KnowledgeSession session = KnowledgeSessionFactory.newKnowledgeSession(knowledgePackage);

	        Test test = new Test();
	        test.setLevel(5);
	        session.insert(test);
	        session.fireRules();
	        
	        return test;
	    }
	}