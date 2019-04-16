package com.laptop.infra.storage.wdmobilehdd.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.laptop.infra.storage.wdmobilehdd.adapter.WDDataAdapter;
import com.laptop.infra.storage.wdmobilehdd.entity.WDData;

@Mapper(componentModel = "spring")
public interface WDDataMapper {
	@Mapping(source = "data.wdDataName", target = "usbDataName")
	@Mapping(source = "data.wdDataContent", target = "usbDataContent")
	WDDataAdapter mapWDDataToDataFromUSB(WDData data);
}
