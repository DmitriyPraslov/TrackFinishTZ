package com.example.trackfinishtz;

import com.example.trackfinishtz.beans.PositionBean;
import com.example.trackfinishtz.dao.PositionDAO;
import com.example.trackfinishtz.data.Position;

import javax.servlet.annotation.WebServlet;

import java.io.*;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;

@WebServlet(name = "positionServlet", value = {"/position-servlet", "/createPosition", "/deletePosition", "/updatePosition", "/showAllPosition"})
public class PositionServlet extends HttpServlet{

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        PositionDAO positionDAO = new PositionDAO();
        List<Position> positions = positionDAO.findAllPosition();
        request.setAttribute("positionBean", new PositionBean(positions));
        request.getRequestDispatcher("/showAllPositionResult.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        if (requestURI.contains("/createPosition")){
            String positionName = request.getParameter("positionName");
            String canChangeWorkTimeChoice = request.getParameter("canChangeWorkTime");
            boolean canChangeWorkTime = canChangeWorkTimeChoice.equals("Yes")?true:false;
            PositionDAO positionDAO = new PositionDAO();
            String answer = positionDAO.addPosition(positionName, canChangeWorkTime);
            request.setAttribute("addPosition", answer);
            request.getRequestDispatcher("/addPositionResult.jsp").forward(request, response);
        } else if (requestURI.contains("/deletePosition")){
            String positionName = request.getParameter("selectPosition");
            PositionDAO positionDAO = new PositionDAO();
            String answer = positionDAO.deletePositionByName(positionName);
            request.setAttribute("deletePosition", answer);
            request.getRequestDispatcher("/deletePositionResult.jsp").forward(request,response);
        } else {
            String positionName = request.getParameter("updatePosition");
            String canChangeWorkTimeChoice = request.getParameter("updateCanChangeWorkTime");
            boolean canChangeWorkTime = canChangeWorkTimeChoice.equals("Yes")?true:false;
            PositionDAO positionDAO = new PositionDAO();
            String answer = positionDAO.updatePosition(positionName, canChangeWorkTime);
            request.setAttribute("updatePosition", answer);
            request.getRequestDispatcher("/updatePositionResult.jsp").forward(request,response);
        }
    }

    public void destroy() {
    }
}
