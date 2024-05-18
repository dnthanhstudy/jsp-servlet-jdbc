package com.laptrinhjavaweb.controller.web;

import com.laptrinhjavaweb.controller.model.UserModel;
import com.sun.xml.internal.ws.resources.DispatchMessages;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/trang-chu"})
public class HomePageController extends HttpServlet {

    private static final Logger LOGGER = LoggerFactory.getLogger(HomePageController.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        LOGGER.info("Controller home page begin");
        UserModel model = UserModel.builder()
                .userName("dangngocthanh")
                .fullName("Đặng Ngọc Thanh")
                .build();
        LOGGER.info("Username: {}, Fullname: {}", model.getUserName(), model.getFullName());
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/web/home-page.jsp");
        request.setAttribute("model", model);
        rd.forward(request, response);
        LOGGER.info("Controller home page end");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
