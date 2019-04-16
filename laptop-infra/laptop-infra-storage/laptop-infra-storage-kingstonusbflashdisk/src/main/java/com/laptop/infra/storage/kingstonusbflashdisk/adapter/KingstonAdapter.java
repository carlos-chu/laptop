package com.laptop.infra.storage.kingstonusbflashdisk.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.laptop.domain.api.entity.DataFromUSB;
import com.laptop.domain.spi.USBDevice;
import com.laptop.infra.storage.kingstonusbflashdisk.factory.KingstonDataFactory;
import com.laptop.infra.storage.kingstonusbflashdisk.mapper.KingstonDataMapper;
import com.laptop.infra.storage.kingstonusbflashdisk.repository.KingstonDataRepository;

@Repository
public class KingstonAdapter implements USBDevice {

	@Autowired
	KingstonDataRepository kingstonusbflashdiskDataRepository;

	@Autowired
	KingstonDataMapper dataMapper;

	@Autowired
	KingstonDataFactory kingstonusbflashdiskDataFactory;

	@Override
	public DataFromUSB getByName(String name) {
		return dataMapper.mapKingstondataToMydata(kingstonusbflashdiskDataRepository.getByName(name));
	}

	@Override
	public void store(String name, String content) {
		kingstonusbflashdiskDataRepository.store(kingstonusbflashdiskDataFactory.createData(name, content));
	}

}
