package com.laptop.infra.storage.kingstonusbflashdisk.repository;

import java.util.HashMap;

import org.springframework.stereotype.Repository;

import com.laptop.infra.storage.kingstonusbflashdisk.entity.KingstonData;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class KingstonDataRepository {
	private static HashMap<String, KingstonData> kingstonflashdisk = new HashMap<String, KingstonData>();
	static {
		KingstonData movieLeon = new KingstonData();
		movieLeon.setKingstonDataName("Movie: Leon");
		movieLeon.setKingstonDataContent("Heros never die");
		kingstonflashdisk.put("Movie: Leon", movieLeon);
	}

	public KingstonData getByName(String name) {
		KingstonData data = kingstonflashdisk.get(name);
		log.info("read data: {} from kingston USB flash disk", data);
		return data;
	}

	public void store(KingstonData data) {
		kingstonflashdisk.put(data.getKingstonDataName(), data);
	}
}
