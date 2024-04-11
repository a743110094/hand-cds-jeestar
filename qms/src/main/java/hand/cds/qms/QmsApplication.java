package hand.cds.qms;

import com.alibaba.druid.spring.boot3.autoconfigure.DruidDataSourceAutoConfigure;
import org.beetl.ext.spring6.EnableBeetl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = {DruidDataSourceAutoConfigure.class})
@EnableBeetl
public class QmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(QmsApplication.class, args);
    }

}
