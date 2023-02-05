package com.controller;

import com.model.myClass.Category;
import com.model.myClass.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CategoryServlet", value = "/CategoryServlet")
public class CategoryServlet extends HttpServlet {
    ProductServlet productServlet=new ProductServlet();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action=request.getParameter("action");
        if (action==null){
            action="";
        }
        switch (action){
            case "edit":
                shoeEdit(request,response);
                break;
            case "delete":
                showDelete(request,response);
                break;
            default:
                showList(request,response);
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
                createCategory(request,response);
                break;
            case "edit":
                editCategory(request,response);
                break;
            case "delete":
                deleteCategory(request,response);
                break;
        }
    }

    private void deleteCategory(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name=request.getParameter("name");
        this.productServlet.iCrudCategory.delete(productServlet.iCrudCategory.findById(id));
        List<Product>listNew=new ArrayList<>();
        for (Product p : productServlet.iCrudProduct.findAll()) {
            if (!p.getCategory().getName().equals(name)){
                listNew.add(p);
            }
        }
        productServlet.iCrudProduct.findAll().removeAll(productServlet.iCrudProduct.findAll());
        productServlet.iCrudProduct.findAll().addAll(listNew);
        try {
            response.sendRedirect("/CategoryServlet");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void editCategory(HttpServletRequest request, HttpServletResponse response) {
        int id= Integer.parseInt(request.getParameter("id"));
        String name=request.getParameter("name");
        int idNew = Integer.parseInt(request.getParameter("idNew"));
        String nameNew=request.getParameter("nameNew");
        Category editCategory=new Category(idNew,nameNew);
       Category category= productServlet.iCrudCategory.findById(id);
        this.productServlet.iCrudCategory.update(productServlet.iCrudCategory.findAll().indexOf(category),editCategory);
        for (Product p : this.productServlet.iCrudProduct.findAll()) {
            if (p.getCategory().getName().equals(name)){
                p.setCategory(editCategory);
            }
        }
        try {
            response.sendRedirect("/CategoryServlet");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void shoeEdit(HttpServletRequest request, HttpServletResponse response) {
        int id=Integer.parseInt(request.getParameter("id"));
        request.setAttribute("category",productServlet.iCrudCategory.findById(id));
        RequestDispatcher dispatcher=request.getRequestDispatcher("views/category/edit.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher= request.getRequestDispatcher("views/category/display.jsp");
        request.setAttribute("category",productServlet.iCrudCategory.findAll());
        try {
            dispatcher.forward(request,response);
        } catch (ServletException |IOException e) {
            e.printStackTrace();
        }
    }


    private void createCategory(HttpServletRequest request, HttpServletResponse response) {
        int id= Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        Category category=new Category(id,name);
        this.productServlet.iCrudCategory.save(category);
        try {
            response.sendRedirect("/CategoryServlet");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void showDelete(HttpServletRequest request, HttpServletResponse response) {
        int id= Integer.parseInt(request.getParameter("id"));
        request.setAttribute("category",productServlet.iCrudCategory.findById(id));
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/category/delete.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

}
