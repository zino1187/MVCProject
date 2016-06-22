/*
 * 의존성을 낮추기 위해, 앞으로 어플리케이션에서 사용할 모든 객체는 
 * 외부의 설정파일로 관리하겠다!! 
 * 여기서 설정파일이란 java의 클래스가 아닌 일반 텍스트파일, xml, json...기타
 * 텍스트기반의 파일이면 상관없다!!
 * 
 * 실행중인 자바 프로그램에서 외부 자원의 내용을 읽어들이기 위해서는 스트림제어가
 * 필요하다!!
 * */
package com.mvc.context;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.mvc.controller.Controller;

public class ApplicationContext {
	FileInputStream fis; //파일을 읽어들일 수 있는 스트림 
	Properties props; //스트림으로 읽어들일 대상이  key=value로 되어있을 경우 
	//해당 데이터를 해석할 수 있는 객체...
	
	//이 생성자를 호출하는 자가 경로를 넘겨줘야 한다!! 
	public ApplicationContext(String path) {
		try {
			fis = new FileInputStream(path);
			props = new Properties();
			
			props.load(fis);
						
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	//클라이언트의 요청에 따라서, 알맞는 동생 컨트롤러를 반환하는 메서드 
	public Controller getController(String uri){
		String className=props.getProperty(uri); 
		
		//new연산자만이 인스턴스를 메모리에 생성할 수 잇는것이 아니다!! (고정관념 버리자)
		Controller obj=null;
		try {
			Class controllerClass=Class.forName(className);//클래스 로드!!
			obj = (Controller)controllerClass.newInstance();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return obj;
	}
	
	//실제 뷰페이지 반환 
	public String getViewPage(String key){
		return props.getProperty(key);
	}
}













