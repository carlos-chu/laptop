package com.laptop.infra.display.xiaomitv.adapter;

import org.springframework.stereotype.Repository;

import com.laptop.domain.api.vo.ShowPosition;
import com.laptop.domain.data.DataInMemory;
import com.laptop.domain.spi.HDMIDevice;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class XiaomiAdapter implements HDMIDevice {
	@Override
	public void show(DataInMemory data, ShowPosition showPosition) {
		log.info("show data: {} at: {} on Xiaomi TV", data, showPosition);
	}
}
