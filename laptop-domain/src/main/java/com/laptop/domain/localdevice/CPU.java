package com.laptop.domain.localdevice;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.laptop.domain.api.entity.DataFromUSB;
import com.laptop.domain.data.DataInMemory;

@Mapper(componentModel = "spring")
public interface CPU {
	@Mapping(source = "data.usbDataName", target = "localDataName")
	@Mapping(source = "data.usbDataContent", target = "localDataContent")
	DataInMemory mapUSBDataToLocalData(DataFromUSB data);
}
