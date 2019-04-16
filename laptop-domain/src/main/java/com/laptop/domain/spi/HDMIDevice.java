package com.laptop.domain.spi;

import com.laptop.domain.api.vo.ShowPosition;
import com.laptop.domain.data.DataInMemory;

public interface HDMIDevice {
	void show(DataInMemory data, ShowPosition showPosition);
}
