package com.wangrui;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author:wangrui
 * @Date:2020/3/5 15:34
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private void printMessage(HttpServletResponse resp,String message) throws IOException {
        resp.getWriter().printf("<p>%S</p>",message);
        System.out.println(message);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      //这里设置的请求的编码，告诉tomcat,按照utf-8的字符集解析用户提交上来的信息
       req.setCharacterEncoding("utf-8");
       //这里设置的相应的编码，告诉浏览器，按照utf-8的字符集编码，读得到的响应信息
       resp.setContentType("text/html;charset=utf-8");
        printMessage(resp,"用户名="+req.getParameter("username"));
        printMessage(resp,"昵称="+req.getParameter("nickname"));
        printMessage(resp,"密码="+req.getParameter("password"));
        printMessage(resp,"确认密码="+req.getParameter("password-confirm"));
        printMessage(resp,"个性签名="+req.getParameter("brief"));
    }
}
