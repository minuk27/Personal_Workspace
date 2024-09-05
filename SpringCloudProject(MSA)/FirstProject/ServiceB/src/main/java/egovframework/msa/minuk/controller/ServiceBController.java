package egovframework.msa.minuk.controller;

//import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import egovframework.msa.minuk.service.ServiceBService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/serviceB")
public class ServiceBController {
	private final RestTemplate restTemplate;
	private String serviceBUrl = "http://localhost:8081/serviceA";
	//private final HttpServletRequest request;
	
	private final ServiceBService serviceBService;

	@GetMapping
	public String getServiceA() {
		return serviceBService.getServiceB();
	}
	
	@GetMapping("/serviceA")
	public ResponseEntity<String> callServiceA() {
	    String response = restTemplate.getForObject(serviceBUrl, String.class);
	    return ResponseEntity.ok(response);
	}
	
	@GetMapping("/serviceA/{message}")
	public ResponseEntity<String> callServiceA(@PathVariable String message) {
		String response = restTemplate.getForObject(serviceBUrl + ("/" + message), String.class);
        return ResponseEntity.ok(response);
	}
    
    @GetMapping("/{message}")
    public String callServiceAWithMessage(@PathVariable String message) {
    	//String requestUri = request.getRequestURI();

        return serviceBService.getServiceBMessage(message);
    }
}