package hu.me.service;

import org.springframework.stereotype.Service;

import hu.me.modell.getMunkakModell;

@Service
public class MunkaServiceImpl implements MunkaService{
	
	public String getMessage(getMunkakModell munkakModell){
		return "hello: " + munkakModell.getNev() + ": " + munkakModell.getEletkor();
	}
	

}
