package com.example.jwt;

import com.example.jwt.service.JwtService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.HashMap;

@SpringBootTest
class JwtApplicationTests {

	@Autowired
	private JwtService jwtService;

	@Test
	void contextLoads() {
	}
// 얘부터 해서 토근을 생성하고
	@Test
	void tokenCreate(){
		var claims = new HashMap<String,Object>();

		var expiredAt = LocalDateTime.now().plusMinutes(10); // 10분동안 토큰이 유지된다.

		var jwtToken = jwtService.create(claims,expiredAt);

		System.out.println(jwtToken);
	}

	// 토큰 고친 후 실행 시켜주기
	@Test
	void tokenValidation(){
		var token = "eyJhbGciOiJIUzI1NiJ9.eyJleHAiOjE3MjAxMDQyMDF9.jySeOuPjezbR7pMOAGUkXAtoqBT77IssuCOs9zJXb0E"; // 생성한 토큰 그때마다 고체해주고
		jwtService.validation(token);

	}

}
