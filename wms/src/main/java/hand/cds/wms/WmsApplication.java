package hand.cds.wms;

import com.alibaba.druid.spring.boot3.autoconfigure.DruidDataSourceAutoConfigure;
import org.beetl.ext.spring6.EnableBeetl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * WMS 应用程序
 *
 * @author Heaven96
 * @date 2024/04/09
 */
@SpringBootApplication(exclude = {DruidDataSourceAutoConfigure.class})
@EnableBeetl
public class WmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(WmsApplication.class, args);
    }

}
