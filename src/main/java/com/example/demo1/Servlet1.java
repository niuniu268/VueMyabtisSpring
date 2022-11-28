package com.example.demo1;

import com.example.config.MyBatisConfig;
import com.example.dao.UsersDao;
import com.example.pojo.Users;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@WebServlet( "/Servlet1")
public class Servlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext( MyBatisConfig.class );
        UsersDao bean = annotationConfigApplicationContext.getBean( UsersDao.class );
        List <Users> list = bean.selectAll( );
        request.setAttribute("list", list);

        request.getRequestDispatcher( "/index.jsp" ).forward( request,response );


    }



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet( request,response );

    }
}
