package in.cdac.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@GetMapping("helloWorld")
	public String HelloWorld()
	{
		return "HelloWorld";
	}
}
