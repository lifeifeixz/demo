package com.example.controller;

import com.example.controller.exception.MyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author flysLi
 */
@SpringBootApplication
@RestController
public class ServiceHiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceHiApplication.class, args);
    }

    private static final Logger LOG = Logger.getLogger(ServiceHiApplication.class.getName());

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ColorDao colorDao;

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @RequestMapping("/info")
    @ResponseBody
    public String info(Integer type) {
        /*抛出异常*/
        if (type == 1) {
            throw new MyException("发生错误");
        }
        LOG.log(Level.INFO, "CALLING TRACE SERVICE-HI");
        return "i'm service-hi";
    }

    @Bean
    public AlwaysSampler defaultSampler() {
        return new AlwaysSampler();
    }

    @RequestMapping("/getByToken")
    @ResponseBody
    public List<Color> getByToken(String token) {
        return colorDao.findByColor(token);
    }
}
