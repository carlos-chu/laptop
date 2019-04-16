package com.laptop.domain.data.factory;

import org.springframework.stereotype.Component;

import com.laptop.domain.data.DataInMemory;

@Component
public class LocalDataFactory {
	public DataInMemory createData(String name, String content) {
		DataInMemory data = new DataInMemory();
		data.setLocalDataName(name);
		data.setLocalDataContent(content);
		return data;
	}
}
