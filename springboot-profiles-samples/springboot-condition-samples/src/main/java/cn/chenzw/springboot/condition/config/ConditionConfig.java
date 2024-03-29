package cn.chenzw.springboot.condition.config;

import cn.chenzw.springboot.condition.bean.HelloBean;
import cn.chenzw.springboot.condition.bean.MyBean;
import cn.chenzw.springboot.condition.support.LinuxCondition;
import cn.chenzw.springboot.condition.support.WindowsCondition;
import cn.chenzw.springboot.condition.template.AbstractTemplate;
import cn.chenzw.springboot.condition.template.LinuxTemplate;
import cn.chenzw.springboot.condition.template.WindowsTemplate;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnSingleCandidate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConditionConfig {

    /**
     * 满足WindowsCondition条件，则实例化此bean
     *
     * @return
     */
    @Bean
    @Conditional(WindowsCondition.class)
    public AbstractTemplate windowsTemplate() {
        return new WindowsTemplate();
    }

    /**
     * 满足LinuxCondition条件，则实例化此bean
     *
     * @return
     */
    @Bean
    @Conditional(LinuxCondition.class)
    public AbstractTemplate linuxTemplate() {
        return new LinuxTemplate();
    }


    /**
     * 当HelloBean类存在时才实例化此Bean
     *
     * @return
     */
    @Bean
    @ConditionalOnClass({HelloBean.class})
    public MyBean myBean() {
        return new MyBean();
    }


    @Bean
    HelloBean helloBean(){
        return new HelloBean();
    }

    /**
     * 当存在HelloBean单例时，才实例化此Bean
     *
     * @return
     */
    @Bean
    @ConditionalOnSingleCandidate(HelloBean.class)
    public MyBean myBean2() {
        return new MyBean();
    }


}
