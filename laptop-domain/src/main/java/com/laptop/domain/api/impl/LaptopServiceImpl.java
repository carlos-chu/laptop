package com.laptop.domain.api.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptop.domain.api.LaptopService;
import com.laptop.domain.api.vo.DisplayType;
import com.laptop.domain.api.vo.ShowPosition;
import com.laptop.domain.data.DataInMemory;
import com.laptop.domain.localdevice.CPU;
import com.laptop.domain.localdevice.HardDrive;
import com.laptop.domain.localdevice.RetinaDisplay;
import com.laptop.domain.spi.HDMIDevice;
import com.laptop.domain.spi.USBDevice;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class LaptopServiceImpl implements LaptopService {
	@Autowired
	HDMIDevice hdmiDevice;
	@Autowired
	USBDevice usbDevice;
	@Autowired
	CPU cpu;
	@Autowired
	HardDrive hardDrive;
	@Autowired
	RetinaDisplay retinaDisplay;

	@Override
	public String pretendToWorkAtWork() {
		log.info("start to work at 9:00am");
		DataInMemory eclipse = hardDrive.getByName("App: eclipse");
		this.show(DisplayType.LOCAL_RETINA, eclipse, ShowPosition.MIDDLE);

		DataInMemory movie = cpu.mapUSBDataToLocalData(usbDevice.getByName("Movie: Leon"));
		this.show(DisplayType.EXTERNAL_DEVICE, movie, ShowPosition.BOTTOM_LEFT_CORNER);

		turnOnCameraAndShowVideo(DisplayType.EXTERNAL_DEVICE, ShowPosition.TOP_RIGHT_CORNER);

		standByAndAlert();
		
		log.info("ready to go home at 21:00pm");

		return "success";
	}

	@Override
	public String pretendToWorkAtHome() {
		DataInMemory movie = cpu.mapUSBDataToLocalData(usbDevice.getByName("Movie: The mule"));
		this.show(DisplayType.LOCAL_RETINA, movie, ShowPosition.MIDDLE);

		DataInMemory wechat = hardDrive.getByName("App: wechat");
		this.show(DisplayType.EXTERNAL_DEVICE, wechat, ShowPosition.TOP_LEFT_CORNER);

		startAJobToSendEmailToBoss(
				"Hey boss, I have been thinking about your idea the whole day. I must admit it is absolutely doable!");
		return "success";

	}

	@Override
	public void startAJobToSendEmailToBoss(String message) {
		log.info("This job is going to send an email : [{}] to my boss at 2:00 am", message);

	}

	@Override
	public void askQuestionsInWechatGroup(String message) {
		log.info("askQuestionsInWechatGroup: {}", message);

	}

	@Override
	public void turnOnCameraAndShowVideo(DisplayType displayType, ShowPosition showPosition) {
		DataInMemory dataInMemory = new DataInMemory();
		dataInMemory.setLocalDataName("Device: camera");
		dataInMemory.setLocalDataContent("stay alert!");

		if (displayType.equals(DisplayType.LOCAL_RETINA)) {
			retinaDisplay.show(dataInMemory, showPosition);
		} else {
			hdmiDevice.show(dataInMemory, showPosition);
		}
		log.info("turn on camera and show video on: {} at {}", displayType, showPosition);
	}

	@Override
	public void closeAllApplications() {
		log.info("closeAllApplications");

	}

	@Override
	public void standByAndAlert() {
		log.info("standByAndAlert");
		if (checkIfAnyoneStandsBehindMe()) {
			closeAllApplications();
		}
	}

	@Override
	public Boolean checkIfAnyoneStandsBehindMe() {
		log.info("checkIfAnyoneStandsBehindMe");
		return false;
	}

	@Override
	public void show(DisplayType displayType, DataInMemory dataInMemory, ShowPosition showPosition) {
		if (displayType.equals(DisplayType.LOCAL_RETINA)) {
			retinaDisplay.show(dataInMemory, showPosition);
		} else {
			hdmiDevice.show(dataInMemory, showPosition);
		}
	}

}
