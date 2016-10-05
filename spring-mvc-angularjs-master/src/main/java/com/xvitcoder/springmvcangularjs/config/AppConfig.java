package com.xvitcoder.springmvcangularjs.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by xvitcoder on 12/24/15.
 */
@Configuration
@ComponentScan("com.xvitcoder.springmvcangularjs")
public class AppConfig extends WebMvcConfigurerAdapter{
}
