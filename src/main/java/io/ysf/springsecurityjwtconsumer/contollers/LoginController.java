package io.ysf.springsecurityjwtconsumer.contollers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class LoginController {
	@GetMapping("/login")
	public ModelAndView getLoginPage() {
		ModelAndView modelAndView = new ModelAndView("login");
		return modelAndView;
	}

	@PostMapping("/loginSubmit")
	public ModelAndView getLoginSubmit(@RequestBody Object user,
			HttpServletRequest request, HttpServletResponse response) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("ysfjwt", request.getHeader("ysfjwt"));
		String url = "http://localhost:9193/api/auth/signin";
		HttpEntity entity = new HttpEntity(user, headers);
		Class responseType = String.class;
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity responseT = restTemplate.exchange(url, HttpMethod.POST,
				entity, responseType);
		ModelAndView modelAndView = new ModelAndView("loginsubmit");
		HttpHeaders respHeaders = responseT.getHeaders();
		String set_cookie = respHeaders.getFirst(HttpHeaders.SET_COOKIE);
		modelAndView.addObject("user", responseT.getBody());
		return modelAndView;
	}

	@GetMapping("/loginCode")
	public ModelAndView getLoginByCodePage() {
		ModelAndView modelAndView = new ModelAndView("logincode");
		return modelAndView;
	}

	@PostMapping("/loginCodeSubmit")
	public ModelAndView getLoginCodeSubmit(@RequestBody Object user,
			HttpServletRequest request, HttpServletResponse response) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("ysfjwt", request.getHeader("ysfjwt"));
		String url = "http://localhost:9193/api/auth/signincode";
		HttpEntity entity = new HttpEntity(user, headers);
		Class responseType = String.class;
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity responseT = restTemplate.exchange(url, HttpMethod.POST,
				entity, responseType);
		ModelAndView modelAndView = new ModelAndView("loginsubmit");
		HttpHeaders respHeaders = responseT.getHeaders();
		String set_cookie = respHeaders.getFirst(HttpHeaders.SET_COOKIE);
		modelAndView.addObject("user", responseT.getBody());
		return modelAndView;
	}

}
