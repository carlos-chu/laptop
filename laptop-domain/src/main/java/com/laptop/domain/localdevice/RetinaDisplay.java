package com.laptop.domain.localdevice;

import org.springframework.stereotype.Component;

import com.laptop.domain.api.vo.ShowPosition;
import com.laptop.domain.data.DataInMemory;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class RetinaDisplay {
	public void show(DataInMemory data, ShowPosition showPosition) {
		log.info("display data: {} at {} on my retina", data, showPosition);
	}
}
