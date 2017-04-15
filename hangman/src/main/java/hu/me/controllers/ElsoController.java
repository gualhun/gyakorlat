package hu.me.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import hu.me.modell.getMunkakModell;
import hu.me.service.MunkaService;
import hu.me.service.MunkaServiceImpl;

@Controller
public class ElsoController {
	
	private MunkaService munkaService;
	
	
//	public ElsoController(MunkaService munkaService) {
//		this.munkaService = munkaService;
//	}
//	
	
	@Autowired
	public void setMunkaService(MunkaService munkaService) {
		this.munkaService = munkaService;
	}


	@PostMapping("/posttest")
	@ResponseBody
	public String getMunkaString(){
		return "POST valasz";
	}

	@GetMapping("/")
	@ResponseBody
	public String getMunkaString(@Valid getMunkakModell munkakModell, BindingResult bindingResult) {
		String rv;
		if(bindingResult.hasErrors()) {
			rv = "TILOS";
		} else {
		rv = munkaService.getMessage(munkakModell);
		}
		return  rv;
	}
}
