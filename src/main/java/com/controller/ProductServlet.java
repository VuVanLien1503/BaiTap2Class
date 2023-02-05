package com.controller;

import com.model.myClass.Category;
import com.model.myClass.Product;
import com.model.myInterface.CategoryImpl;
import com.model.myInterface.ProductImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ProductServlet", value = "/ProductServlet")
public class ProductServlet extends HttpServlet {
    static CategoryImpl iCrudCategory  = new CategoryImpl();
    static ProductImpl iCrudProduct = new ProductImpl( iCrudCategory);

    public ProductServlet() {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreate(request, response);
                break;
            case "edit":
                showEdit(request,response);
                break;
            case "delete":
                showDelete(request,response);
                break;
            default:
                listProduct(request, response);
                break;
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getParameter("action");
        if (action==null){
            action="";
        }
        switch (action){
            case "create":
                createProduct(request,response);
                break;
            case "edit":
                editProduct(request,response);
                break;
            case "delete":
                deleteProduct(request,response);
                break;
            default:
                break;
        }

    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product=iCrudProduct.findById(id);
        this.iCrudProduct.delete(product);
        try {
            response.sendRedirect("/ProductServlet");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showDelete(HttpServletRequest request, HttpServletResponse response) {
        int id= Integer.parseInt(request.getParameter("id"));
        Product product=iCrudProduct.findById(id);
        request.setAttribute("product",product);
        RequestDispatcher dispatcher=request.getRequestDispatcher("views/product/delete.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException|IOException e) {
            e.printStackTrace();
        }
    }

    private void showEdit(HttpServletRequest request, HttpServletResponse response) {
        int id= Integer.parseInt(request.getParameter("id"));
        Product product=iCrudProduct.findById(id);
        request.setAttribute("product",product);
        request.setAttribute("category",iCrudCategory.findAll());
        RequestDispatcher dispatcher=request.getRequestDispatcher("views/product/edit.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException |IOException e) {
            e.printStackTrace();
        }
    }

    private void listProduct(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/product/display.jsp");
        request.setAttribute("product", iCrudProduct.findAll());
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/product/create.jsp");
        request.setAttribute("category", iCrudCategory.findAll());
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }

    }

    private void editProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        int index = Integer.parseInt(request.getParameter("index"));
        String name = request.getParameter("name");
        String nameCategory =request.getParameter("category");
        Category category = null;
        double price = Double.parseDouble(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        for (Category c :iCrudCategory.findAll()) {
            if (c.getName().equals(nameCategory)){
                category=c;
                break;
            }
        }
        Product productNew=new Product(id,name,price,category,quantity);
        Product product=iCrudProduct.findById(index);
        this.iCrudProduct.update(iCrudProduct.findAll().indexOf(product),productNew);
        try {
            response.sendRedirect("/ProductServlet");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name =request.getParameter("name");
        String nameCategory =request.getParameter("category");
        Category category = null;
        double price = Double.parseDouble(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        for (Category c :iCrudCategory.findAll()) {
            if (c.getName().equals(nameCategory)){
                category=c;
                break;
            }
        }
        Product product=new Product(id,name,price,category,quantity);
        this.iCrudProduct.save(product);
        try {
            response.sendRedirect("/ProductServlet");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
