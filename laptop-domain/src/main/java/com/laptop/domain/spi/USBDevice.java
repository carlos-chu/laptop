package com.laptop.domain.spi;

import com.laptop.domain.api.entity.DataFromUSB;

public interface USBDevice {
	public DataFromUSB getByName(String name);

	public void store(String name, String content);
}
