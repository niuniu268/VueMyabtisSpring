package com.example.demo1;

import com.alibaba.fastjson.JSON;
import com.example.config.MyBatisConfig;
import com.example.dao.UsersDao;
import com.example.pojo.Users;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
@WebServlet("/users/*")
public class Servlet2 extends BaseServlet{

    public static void selectAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext( MyBatisConfig.class );
        UsersDao bean = annotationConfigApplicationContext.getBean( UsersDao.class );
        resp.setContentType( "text/json;char=utf-8" );
        
        List <Users> list = bean.selectAll( );

        PrintWriter writer = resp.getWriter( );
        String s = JSON.toJSONString( list );
//        request.setAttribute("list", list);
        writer.write(s);
    }
}
