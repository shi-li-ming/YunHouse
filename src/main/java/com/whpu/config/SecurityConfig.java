package com.whpu.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired   //注入dataSource
     private DataSource dataSource;
    @Override  //重写认证方法
    protected  void configure(AuthenticationManagerBuilder auth) throws  Exception{
     //1、构建密码加密器
        BCryptPasswordEncoder  encoder =new BCryptPasswordEncoder();
        String p666=encoder.encode("666");
        String p123=encoder.encode("123");
        System.out.println("p666=:"+p666);
        System.out.println("p123=:"+p123);
        //连接jdbc认证用户信息
        auth.jdbcAuthentication().passwordEncoder(encoder).
                dataSource(dataSource).
                //根据用户名去验证密码，
                usersByUsernameQuery("select name ,pwd ,1 from users where name=?").
                //根据用户名查询权限
                authoritiesByUsernameQuery("select name ,role from users where name=?");
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http.authorizeRequests().
                antMatchers("/").permitAll(). //不拦截/和index
                 antMatchers("/house/**","/user/**","/admin","/index","front").hasAuthority("房东").
//                 antMatchers("/house/**","/user/**","/admin","/index","front").hasAuthority("租客").
                anyRequest().authenticated().and().formLogin();
    }
}
