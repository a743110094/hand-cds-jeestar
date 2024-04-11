package hand.cds.oms;

import com.alibaba.druid.spring.boot3.autoconfigure.DruidDataSourceAutoConfigure;
import org.beetl.ext.spring6.EnableBeetl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = {DruidDataSourceAutoConfigure.class})
@EnableBeetl
public class OmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(OmsApplication.class, args);
    }

}
