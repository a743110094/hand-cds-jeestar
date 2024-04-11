package hand.cds.qms.config;

import org.beetl.core.GroupTemplate;
import org.beetl.ext.spring6.BeetlTemplateCustomize;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * beetl 配置
 *
 * @author Heaven96
 * @date 2024/04/09
 */
@Configuration
public class BeetlConfigsss {

    @Bean
    public BeetlTemplateCustomize beetlTemplateCustomize() {
        return groupTemplate -> {

        };
    }

}