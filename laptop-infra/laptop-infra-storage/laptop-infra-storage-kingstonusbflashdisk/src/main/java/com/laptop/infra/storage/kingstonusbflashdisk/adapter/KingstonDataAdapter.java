package com.laptop.infra.storage.kingstonusbflashdisk.adapter;

import com.laptop.domain.api.entity.DataFromUSB;

import lombok.Data;

@Data
public class KingstonDataAdapter implements DataFromUSB {
	private String usbDataName;
	private String usbDataContent;
}
