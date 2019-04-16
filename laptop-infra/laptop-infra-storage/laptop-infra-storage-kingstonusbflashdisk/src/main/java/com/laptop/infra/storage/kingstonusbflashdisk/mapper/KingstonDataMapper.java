package com.laptop.infra.storage.kingstonusbflashdisk.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.laptop.infra.storage.kingstonusbflashdisk.adapter.KingstonDataAdapter;
import com.laptop.infra.storage.kingstonusbflashdisk.entity.KingstonData;

@Mapper(componentModel = "spring")
public interface KingstonDataMapper {
	@Mapping(source = "data.kingstonDataName", target = "usbDataName")
	@Mapping(source = "data.kingstonDataContent", target = "usbDataContent")
	KingstonDataAdapter mapKingstondataToMydata(KingstonData data);
}
