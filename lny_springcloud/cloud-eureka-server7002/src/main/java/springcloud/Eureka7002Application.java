package springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer //说明这个启动类是eureka服务中心
public class Eureka7002Application {
    public static void main(String[] args) {
        SpringApplication.run(Eureka7002Application.class,args);
    }
}
