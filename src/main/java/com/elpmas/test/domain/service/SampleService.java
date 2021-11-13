package com.elpmas.test.domain.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.elpmas.test.app.bean.SampleOutputBean;
import com.elpmas.test.app.form.SampleForm;
import com.elpmas.test.domain.entity.SampleEntity;
import com.elpmas.test.domain.repository.SampleRepository;

@Service
public class SampleService {

	@Autowired
	SampleRepository sampleRepository;
	
	//変数sampleStringをstringという名称でビューに渡すメソッド
	public void sampleView01(String fromController,Model model) {
		String sampleString=fromController;
		model.addAttribute("string",sampleString);
	}
	
	//コントローラから送られてきたformの値をbeanに代入し、sampleOutputBeanという名称でビューに渡すメソッド
	public void sampleView02(SampleForm sampleForm,Model model) {
		SampleOutputBean sampleOutputBean=new SampleOutputBean();
		sampleOutputBean.setBeanString01(sampleForm.getFormString01());
		sampleOutputBean.setBeanSelect01(sampleForm.getFormSelect01());
		sampleOutputBean.setBeanString02("sampleOutputBeanクラスのbeanString02に詰めた文字列");
		model.addAttribute("sampleOutputBean",sampleOutputBean);
	}
	
	
	//リポジトリからsampleテーブルのレコードをすべて取得し、それをlistSampleOutputBeanという名称でビューに渡すメソッド
	public void sampleView03(Model model) {
		List<SampleEntity> allSampleTableRecord=sampleRepository.findAll();
		List<SampleOutputBean> listSampleOutputBean=new ArrayList<>();
		for(int i=0;i<allSampleTableRecord.size();i++) {
			SampleOutputBean sampleOutputBean=new SampleOutputBean();
			sampleOutputBean.setBeanSelect01(allSampleTableRecord.get(i).getId());
			sampleOutputBean.setBeanString01(allSampleTableRecord.get(i).getString());
			listSampleOutputBean.add(sampleOutputBean);
		}
		model.addAttribute("listSampleOutputBean",listSampleOutputBean);
	}
}
