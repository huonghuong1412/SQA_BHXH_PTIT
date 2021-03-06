package com.example.demo.controller;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.dto.auth.LoginDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest()
@AutoConfigureMockMvc
@RunWith(SpringJUnit4ClassRunner.class)
//@Transactional
public class TestLoginController {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	// Test trường hợp đăng nhập thành công, tài khoản và mật khẩu đúng
	@Test
	public void testLoginSuccessful() throws JsonProcessingException, Exception {
		LoginDto test = new LoginDto();
		test.setUsername("0000000001");
		test.setPassword("123456789");
		try {
			mockMvc.perform(post("http://localhost:8085/api/auth/login", 42L)
					.contentType("application/json")
					.content(objectMapper.writeValueAsString(test)))
					.andExpect(status().isOk())
					.andExpect(content().string(containsString("token")));
		} catch (Exception e) {
			// TODO: handle exception
		}
		// Status trả về là 200: OK,
	}

	// Test trường hợp đăng nhập không thành công, tài khoản đúng, mật khẩu sai
	@Test
	public void testLoginFailure1() throws JsonProcessingException, Exception {
		LoginDto test = new LoginDto();
		test.setUsername("0000000001");
		test.setPassword("123456");
		// Mật khẩu đúng là 123456789
		try {
			mockMvc.perform(post("http://localhost:8085/api/auth/login", 42L)
					.contentType("application/json")
					.content(objectMapper.writeValueAsString(test)))
					.andExpect(status().isUnauthorized())
					.andExpect(content().string(containsString("Tài khoản hoặc mật khẩu không chính xác!")));
		} catch (Exception e) {
			// TODO: handle exception
		}
		// Status trả về là 401: Unauthorized
	}

	// Test trường hợp đăng nhập không thành công, tài khoản sai, mật khẩu đúng
	@Test
	public void testLoginFailure2() throws JsonProcessingException, Exception {
		LoginDto test = new LoginDto();
		test.setUsername("0000000002");
		test.setPassword("123456789");
		try {
			mockMvc.perform(post("http://localhost:8085/api/auth/login", 42L)
					.contentType("application/json")
					.content(objectMapper.writeValueAsString(test)))
					.andExpect(status().isUnauthorized())
					.andExpect(content().string(containsString("Tài khoản hoặc mật khẩu không chính xác!")));
		} catch (Exception e) {
			// TODO: handle exception
		}
		// Status trả về là 401: Unauthorized
	}

	// Test trường hợp đăng nhập không thành công, tài khoản để trống, mật khẩu đúng
	@Test
	public void testLoginFailure3() throws JsonProcessingException, Exception {
		LoginDto test = new LoginDto();
		test.setUsername("");
		test.setPassword("123456789");
		try {
			mockMvc.perform(post("http://localhost:8085/api/auth/login", 42L)
					.contentType("application/json")
					.content(objectMapper.writeValueAsString(test)))
					.andExpect(status().isUnauthorized())
					.andExpect(content().string(containsString("Tài khoản hoặc mật khẩu không chính xác!")));
			// Status trả về là 401: Unauthorized
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	// Test trường hợp đăng nhập không thành công, tài khoản đúng, mật khẩu để trống
	@Test
	public void testLoginFailure4() throws JsonProcessingException, Exception {
		LoginDto test = new LoginDto();
		test.setUsername("0000000001");
		test.setPassword("");
		try {
			mockMvc.perform(post("http://localhost:8085/api/auth/login", 42L)
					.contentType("application/json")
					.content(objectMapper.writeValueAsString(test)))
					.andExpect(status().isUnauthorized())
					.andExpect(content().string(containsString("Tài khoản hoặc mật khẩu không chính xác!")));
			// Status trả về là 401: Unauthorized
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	// Test trường hợp đăng nhập không thành công, để trống cả tài khoản và mật khẩu
	@Test
	public void testLoginFailure5() throws JsonProcessingException, Exception {
		LoginDto test = new LoginDto();
		test.setUsername("");
		test.setPassword("");
		try {
			mockMvc.perform(post("http://localhost:8085/api/auth/login", 42L)
					.contentType("application/json")
					.content(objectMapper.writeValueAsString(test)))
					.andExpect(status().isUnauthorized())
					.andExpect(content().string(containsString("Tài khoản hoặc mật khẩu không chính xác!")));
			// Status trả về là 401: Unauthorized
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	// Test trường hợp đăng nhập không thành công, tài khoản và mật khẩu đều sai
		@Test
		public void testLoginFailure6() throws JsonProcessingException, Exception {
			LoginDto test = new LoginDto();
			test.setUsername("00000000001");
			test.setPassword("1234567899");
			try {
				mockMvc.perform(post("http://localhost:8085/api/auth/login", 42L)
						.contentType("application/json")
						.content(objectMapper.writeValueAsString(test)))
						.andExpect(status().isUnauthorized())
						.andExpect(content().string(containsString("Tài khoản hoặc mật khẩu không chính xác!")));
				// Status trả về là 401: Unauthorized
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

}
