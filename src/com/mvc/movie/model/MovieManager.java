//모든 플랫폼에서 써먹을 수 있는 중립적 모델 클래스!
//결국 MVC 패턴에서 보호하고자 하는 ( 나중에 또 써먹으려고 하는) 대상은 ?
// 모델이다!!
package com.mvc.movie.model;
public class MovieManager {
	
	public String getAdvice(String movie){
		String msg=null;
		
		if(movie.equals("정글북")){
			msg="3D로 봤어?";
		}else if(movie.equals("엑스맨 아포칼립스")){
			msg="엑스맨 시리즈중 걸작이야";
		}else if(movie.equals("워크래프트")){
			msg="워크래프트";
		}else if(movie.equals("컨저링")){
			msg="컨저링1 보다 무서워?";
		}else if(movie.equals("곡성")){
			msg="곡성 정말 무서!";
		}		
		return msg;
		
	}
}
