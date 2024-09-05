package egovframework.msa.minuk.controller;

//import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import egovframework.msa.minuk.service.ServiceAService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/serviceA")
public class ServiceAController {
	private final RestTemplate restTemplate;
	private String serviceBUrl = "http://localhost:8082/serviceB";
	//private final HttpServletRequest request;
	
	private final ServiceAService serviceAService;

	@GetMapping
	public String getServiceA() {
		return serviceAService.getServiceA();
	}
	
	@GetMapping("/serviceB")
	public ResponseEntity<String> callServiceB() {
	    String response = restTemplate.getForObject(serviceBUrl, String.class);
	    return ResponseEntity.ok(response);
	}
	
	@GetMapping("/serviceB/{message}")
	public ResponseEntity<String> callServiceB(@PathVariable String message) {
		String response = restTemplate.getForObject(serviceBUrl + ("/" + message), String.class);
        return ResponseEntity.ok(response);
	}
    
    @GetMapping("/{message}")
    public String callServiceBWithMessage(@PathVariable String message) {
    	//String requestUri = request.getRequestURI();

        return serviceAService.getServiceAMessage(message);
    }
}