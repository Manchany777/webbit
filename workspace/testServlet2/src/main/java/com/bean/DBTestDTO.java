package com.bean;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class DBTestDTO {
	private String name;
	private String age;
	private String height;
	private String longtime;  //  엄격하게 하고 싶으면 Date로 받아도 된다.
	
	

	
}
