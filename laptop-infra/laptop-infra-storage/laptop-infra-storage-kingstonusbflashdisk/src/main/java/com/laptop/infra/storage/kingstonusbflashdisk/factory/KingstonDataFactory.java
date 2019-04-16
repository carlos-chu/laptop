package com.laptop.infra.storage.kingstonusbflashdisk.factory;

import org.springframework.stereotype.Component;

import com.laptop.infra.storage.kingstonusbflashdisk.entity.KingstonData;

@Component
public class KingstonDataFactory {
	public KingstonData createData(String name, String content) {
		KingstonData data = new KingstonData();
		data.setKingstonDataContent(content);
		data.setKingstonDataName(name);
		return data;
	}
}
