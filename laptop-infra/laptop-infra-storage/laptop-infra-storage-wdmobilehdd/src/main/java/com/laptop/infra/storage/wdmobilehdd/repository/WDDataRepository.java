package com.laptop.infra.storage.wdmobilehdd.repository;

import java.util.HashMap;

import org.springframework.stereotype.Repository;

import com.laptop.infra.storage.wdmobilehdd.entity.WDData;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class WDDataRepository {
	private static HashMap<String, WDData> wdHdd = new HashMap<String, WDData>();
	static {
		WDData movieTheMule = new WDData();
		movieTheMule.setWdDataName("Movie: The mule");
		movieTheMule.setWdDataContent("Don't let the old man in!");
		wdHdd.put("Movie: The mule", movieTheMule);
	}
	
	public WDData getByName(String name) {
		WDData data = wdHdd.get(name);
		log.info("read data: {} from West Data mobile hard drive", data);
		return data;
	}

	public void store(WDData data) {
		wdHdd.put(data.getWdDataName(), data);
	}
}
