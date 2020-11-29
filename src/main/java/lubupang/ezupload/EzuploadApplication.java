package lubupang.ezupload;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan(value = "lubupang.ezupload.maps")
public class EzuploadApplication {

    public static void main(String[] args) {
        SpringApplication.run(EzuploadApplication.class, args);
    }

}
