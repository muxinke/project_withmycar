package com.qf.j1902.config;

import com.qf.j1902.util.ImgCode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Administrator on 2019/6/27.
 */
@Configuration
public class GetImage {
    @Bean
    public ImgCode getImgCode(){
        return new ImgCode();
    }
}
