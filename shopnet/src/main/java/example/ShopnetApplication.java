package example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "main.java.mapper")
public class ShopnetApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopnetApplication.class, args);
    }

}
