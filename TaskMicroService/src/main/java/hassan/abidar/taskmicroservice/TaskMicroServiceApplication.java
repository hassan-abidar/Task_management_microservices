package hassan.abidar.taskmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients

public class TaskMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskMicroServiceApplication.class, args);
	}

}
