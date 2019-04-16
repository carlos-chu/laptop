package com.laptop.infra.storage.wdmobilehdd.adapter;

import com.laptop.domain.api.entity.DataFromUSB;

import lombok.Data;

@Data
public class WDDataAdapter implements DataFromUSB {
	private String usbDataName;
	private String usbDataContent;
}
