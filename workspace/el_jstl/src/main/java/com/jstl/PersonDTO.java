package com.jstl;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@AllArgsConstructor // 모든 인자가 포함된 생성자를 만드는 롬복 어노테이션
@NoArgsConstructor // 기본 생성자를 만드는 롬복 어노테이션
@RequiredArgsConstructor // 내가 원하는 인자값만 생성자로 만드는 롬복 어노테이션
@Getter
@Setter
public class PersonDTO {
	@NonNull // 해당 요소가 절대로 null 값을 가질 수 없음을 나타내는 어노테이션 (현재 name클래스 변수에만 적용한 상태)
	private String name;
	private int age;
	
}
