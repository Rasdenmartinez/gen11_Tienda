package ms.tienda.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.RequestInterceptor;

@Configuration
public class FeignConfig {

	@Bean
	public RequestInterceptor requestInterceptor() {
		return requestTemplate ->{
			requestTemplate.header("Authorization", "Bearer " + "your-token");
		};
	}
}
