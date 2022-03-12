package com.choi.board.controller;

import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping(value = "/")
	public String home(Device device) {
		String url = "home";
		if (device.isMobile()) {
			return "m/" + url;
		}
		return url;
	}
	@GetMapping(value = "/references")
	public String references(Device device) {
		String url = "참고한자료";
		if (device.isMobile()) {
			return "m/" + url;
		}
		return url;
	}

}