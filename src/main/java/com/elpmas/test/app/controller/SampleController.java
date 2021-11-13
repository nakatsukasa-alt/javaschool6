package com.elpmas.test.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.elpmas.test.app.form.SampleForm;
import com.elpmas.test.domain.service.SampleService;

@Controller
public class SampleController {
	@Autowired
	SampleService sampleService;
	
	//初期表示ページ
	@RequestMapping(path="/")
	public String index(Model model) {
		String toServiceString="サービスからviewに渡す文字列";
		//サービスに渡したtoServiceStringをviewに渡すメソッド
		sampleService.sampleView01(toServiceString,model);
		//viewに/resouces/templates/index.htmlを表示するように依頼
		return "view/index";
	}
	
	@RequestMapping(path="/sample01",method=RequestMethod.POST)
	public String sample(Model model,SampleForm sampleForm) {
		//beanに詰めた値をviewに渡すメソッド
		sampleService.sampleView02(sampleForm,model);
		return "view/sample01";
	}
	
	@RequestMapping(path="/sample02",method=RequestMethod.GET)
	public String sample(Model model) {
		//repositoryを使用し検索したDBの値をviewに渡すメソッド
		sampleService.sampleView03(model);
		return "view/sample02";
	}
}
