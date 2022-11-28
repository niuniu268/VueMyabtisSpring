package com.example.demo1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
@WebServlet("/users/test")
public class BaseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String uri = req.getRequestURI( );
        String[] strings = uri.split( "/" );
        String string = strings[strings.length - 1];
        String substring = string.substring( 0 );
        Class <? extends BaseServlet> aClass = this.getClass( );
        Method method = null;
        try {
            method = aClass.getMethod( substring, HttpServletRequest.class, HttpServletResponse.class );
        } catch (NoSuchMethodException e) {
            throw new RuntimeException( e );
        }
        try {
            Object invoke = method.invoke( this, req, resp );
        } catch (IllegalAccessException e) {
            throw new RuntimeException( e );
        } catch (InvocationTargetException e) {
            throw new RuntimeException( e );
        }


    }
}
