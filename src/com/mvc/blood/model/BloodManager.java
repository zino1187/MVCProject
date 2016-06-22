//모든 플랫폼에서 써먹을 수 있는 중립적 모델 클래스!
//결국 MVC 패턴에서 보호하고자 하는 ( 나중에 또 써먹으려고 하는) 대상은 ?
// 모델이다!!
package com.mvc.blood.model;
public class BloodManager {
	
	public String getAdvice(String blood){
		String msg=null;
		
		if(blood.equals("A")){
			msg="세심하고 예민하다";
		}else if(blood.equals("B")){
			msg="고집세고 고집세다";
		}else if(blood.equals("AB")){
			msg="왔다, 갔다리 우유부단";
		}else if(blood.equals("O")){
			msg="쓸데없이 오지랖넓다";
		}	
		return msg;
		
	}
}
