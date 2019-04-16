package com.laptop.domain.api;

import com.laptop.domain.api.vo.DisplayType;
import com.laptop.domain.api.vo.ShowPosition;
import com.laptop.domain.data.DataInMemory;

public interface LaptopService {
	String pretendToWorkAtWork();

	String pretendToWorkAtHome();

	void askQuestionsInWechatGroup(String message);

	void startAJobToSendEmailToBoss(String message);

	void turnOnCameraAndShowVideo(DisplayType displayType, ShowPosition showPosition);

	void closeAllApplications();

	void standByAndAlert();

	void show(DisplayType displayType, DataInMemory dataInMemory, ShowPosition showPosition);

	Boolean checkIfAnyoneStandsBehindMe();
}