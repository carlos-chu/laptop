package com.laptop.domain.localdevice;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.laptop.domain.data.DataInMemory;
import com.laptop.domain.data.factory.LocalDataFactory;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class HardDrive {
	@Autowired
	LocalDataFactory localDataFactory;
	private static HashMap<String, DataInMemory> localHardDrive = new HashMap<String, DataInMemory>();
	static {
		DataInMemory eclipse = new DataInMemory();
		eclipse.setLocalDataName("App: eclipse");
		eclipse.setLocalDataContent("Eclipse number one!");
		localHardDrive.put("App: eclipse", eclipse);
		
		DataInMemory wechat = new DataInMemory();
		wechat.setLocalDataName("App: wechat");
		wechat.setLocalDataContent("I ain't another QQ!");
		localHardDrive.put("App: wechat", wechat);
	}

	public DataInMemory getByName(String name) {
		DataInMemory data = localHardDrive.get(name);
		log.info("read data: {} from local hard drive", data);
		return localHardDrive.get(name);
	}

	public void store(String name, String content) {
		localHardDrive.put(name, localDataFactory.createData(name, content));
	}
}
