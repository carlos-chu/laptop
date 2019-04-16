package com.laptop.infra.storage.wdmobilehdd.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.laptop.domain.api.entity.DataFromUSB;
import com.laptop.domain.spi.USBDevice;
import com.laptop.infra.storage.wdmobilehdd.factory.WDDataFactory;
import com.laptop.infra.storage.wdmobilehdd.mapper.WDDataMapper;
import com.laptop.infra.storage.wdmobilehdd.repository.WDDataRepository;

@Repository
public class WDAdapter implements USBDevice {

	@Autowired
	WDDataRepository wdDataRepository;

	@Autowired
	WDDataMapper dataMapper;

	@Autowired
	WDDataFactory wdDataFactory;

	@Override
	public DataFromUSB getByName(String name) {
		return dataMapper.mapWDDataToDataFromUSB(wdDataRepository.getByName(name));
	}

	@Override
	public void store(String name, String content) {
		wdDataRepository.store(wdDataFactory.createData(name, content));
	}

}
