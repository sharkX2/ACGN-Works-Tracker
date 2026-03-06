package com.MyKr.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.MyKr.dao.WorkAdminDao;
import com.MyKr.model.WorkAdmin;
import com.MyKr.util.TableUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/work/list")
public class WorkListServlet extends HttpServlet {
    private final WorkAdminDao workAdminDao = new WorkAdminDao();
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String period = req.getParameter("period");
        String type = req.getParameter("type");
        String sort = req.getParameter("sort");

        if (period == null || period.trim().isEmpty()) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            resp.setContentType("application/json;charset=UTF-8");
            resp.getWriter().write("{\"error\":\"period参数必填\"}");
            return;
        }

        String tableName = TableUtil.getWorkTableName(req);
        List<WorkAdmin> list = workAdminDao.findByPeriodAndType(tableName, period, type, sort);

        resp.setContentType("application/json;charset=UTF-8");
        objectMapper.writeValue(resp.getWriter(), list);
    }
}
