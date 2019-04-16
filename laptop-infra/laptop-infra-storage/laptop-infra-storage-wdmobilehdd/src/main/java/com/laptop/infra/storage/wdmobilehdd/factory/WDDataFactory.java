package com.laptop.infra.storage.wdmobilehdd.factory;

import org.springframework.stereotype.Component;

import com.laptop.infra.storage.wdmobilehdd.entity.WDData;

@Component
public class WDDataFactory {
	public WDData createData(String name, String content) {
		WDData data = new WDData();
		data.setWdDataContent(content);
		data.setWdDataName(name);
		return data;
	}
}
