package phuongnd.fudn.chapter2_ex1.configs;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import phuongnd.fudn.chapter2_ex1.aspects.LoggingAspect;
import phuongnd.fudn.chapter2_ex1.services.StudentService;
import phuongnd.fudn.chapter2_ex1.services.StudentServiceImpl;

@Configuration
@EnableAspectJAutoProxy
public class AppConfig {

    @Bean
    public StudentService studentService() {
        return new StudentServiceImpl();
    }

    @Bean
    public LoggingAspect loggingAspect() {
        return new LoggingAspect();
    }

}
