package member.core.singleton;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import java.beans.BeanProperty;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {
    @Test
    void statefulServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext();
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);
        
        //ThreadA : A사용자가 10000원 주문
        int userAprice = statefulService1.order("userA", 10000);
        //ThreadB : B사용자가 20000원 주문
        int userBprice = statefulService1.order("userB", 20000);
        
        //ThreadA : 사용자 A주문금액 조회
//        int price = statefulService1.getPrice();
    }

    static class TestConfig {

        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }
    
}