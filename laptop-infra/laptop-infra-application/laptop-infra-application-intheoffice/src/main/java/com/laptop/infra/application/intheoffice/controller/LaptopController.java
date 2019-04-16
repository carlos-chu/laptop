package com.laptop.infra.application.intheoffice.controller;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.laptop.domain.api.LaptopService;
import com.laptop.infra.application.intheoffice.vo.BaseRespVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "在公司工作")
@RestController
@RequestMapping("/laptop")
@Produces(MediaType.APPLICATION_JSON)
public class LaptopController {
	@Autowired
	LaptopService laptopService;

	@ApiOperation(value = "撸起袖子加油干")
	@GetMapping("/intheoffice")
	public BaseRespVo getWalletByUserId() {
		return BaseRespVo.builder().data(laptopService.pretendToWorkAtWork()).build();
	}

}
