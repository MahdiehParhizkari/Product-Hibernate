package com.helman;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet(name = "ProductAct", urlPatterns = {"/ProductAct"})
public class ProductCon extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("crud");
        ProductDao productDao = new ProductDao();

        if (action.equals("read")){
            List<Product> productList = new ArrayList<>();
            String id = req.getParameter("id");

            if (id == null || id.isEmpty()){
                productList = productDao.findAll();
            }else {
                Product product = productDao.findById(Integer.parseInt(id));
                productList.add(product);
            }

            req.setAttribute("products",productList);
            req.getRequestDispatcher("/WEB-INF/views/Product.jsp").forward(req,resp);
        }

        if (action.equals("add")){
            Product product = new Product();
            product.setId(Integer.parseInt(req.getParameter("id")));
            product.setName(req.getParameter("name"));
            product.setCountryid_fk(Integer.parseInt(req.getParameter("countryid_fk")));
            product.setCount(Integer.parseInt(req.getParameter("count")));
            product.setPrice(Float.parseFloat(req.getParameter("price")));
            product.setCreatedate(new Date());
            productDao.insert(product);
            req.setAttribute("message", "added");
            req.getRequestDispatcher("/WEB-INF/views/Product.jsp").forward(req, resp);
        }
        if (action.equals("update")){
            Product product = productDao.findById(Integer.parseInt(req.getParameter("id")));
            product.setName(req.getParameter("name"));
            product.setCountryid_fk(Integer.parseInt(req.getParameter("countryid_fk")));
            product.setCount(Integer.parseInt(req.getParameter("count")));
            product.setPrice(Float.parseFloat(req.getParameter("price")));
            product.setCreatedate(new Date());
            productDao.update(product);
            req.setAttribute("message", "updated");
            req.getRequestDispatcher("/WEB-INF/views/Product.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("crud");
        ProductDao productDao = new ProductDao();

        if (action.equals("delete")){
            Product pro = productDao.findById(Integer.parseInt(req.getParameter("id")));
            productDao.delete(pro);
            req.setAttribute("message", "updated");
            req.getRequestDispatcher("/WEB-INF/views/Product.jsp").forward(req, resp);
        }

        if (action.equals("edit")){
            Product product = productDao.findById((Integer.parseInt(req.getParameter("id"))));
            req.setAttribute("pro", product);
            req.getRequestDispatcher("WEB-INF/views/Edit.jsp").forward(req, resp);
        }

        if (action.equals("dispatcher")){
            String able= req.getParameter("able");
            req.getRequestDispatcher("WEB-INF/views/"+able+".jsp").forward(req, resp);

        }
        if (action.equals("report")){
            try{
                String path = req.getSession().getServletContext().getRealPath("/WEB-INF/Report/Product.jrxml");
                JasperReport jreport = JasperCompileManager.compileReport(path);
                JRBeanCollectionDataSource jcs = new JRBeanCollectionDataSource(productDao.findAll());
                Connection connection = Mysession.getconnection();
                JasperPrint jprint = JasperFillManager.fillReport(jreport, null, connection);
                JasperViewer.viewReport(jprint, false);
                connection.close();
                req.getRequestDispatcher("/WEB-INF/views/Product.jsp");
            } catch (JRException | SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
