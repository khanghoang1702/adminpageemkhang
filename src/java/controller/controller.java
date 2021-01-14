/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Entity.Items;
import adminpage.DAO.adminpageDAO;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author pc
 */
@WebServlet(urlPatterns = {"/upload","/edit","/delete"})
@MultipartConfig(fileSizeThreshold = 1024*1024*2,
        maxFileSize = 1024*1024*10,
        maxRequestSize = 1024*1024*50)
public class controller extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
         String action = request.getServletPath();
        switch (action) {
            case "/upload":
                uploadFunc(request, response);
                break;
            case "/edit":
                editFunc(request, response);
                break;
            case "/delete":
               deleteFunc(request, response);
               break;
            default:
                break;
        }
        response.sendRedirect("adminpage.jsp");
    }
            /* TODO output your page here. You may use following sample code. */
//             String id=request.getParameter("itemId");
//                String itemname=request.getParameter("itemName");
//                int price=Integer.parseInt(request.getParameter("itemPrice"));
//                int quantity=Integer.parseInt(request.getParameter("itemQuantity"));
//                String itemimg=request.getParameter("itemPhoto");
//                Items item=new Items(id,itemname,price,quantity,itemimg);
//                adminpageDAO.addItem(item);
//                RequestDispatcher rd=request.getRequestDispatcher("adminpage.jsp");
//                rd.forward(request,response);
//        }
//    }
       public static final String UPLOAD_DIR = "";
    public String dbFileName = "";
        protected void uploadFunc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String id=request.getParameter("itemId");
            String itemname=request.getParameter("itemName");
            int price=Integer.parseInt(request.getParameter("itemPrice"));
            int quantity=Integer.parseInt(request.getParameter("itemQuantity"));
            Part part=request.getPart("itemPhoto");
            String fileName=extractFileName(part);
            String applicationPath = getServletContext().getRealPath("");
            String uploadPath = "E:\\adminpageofficial\\web\\img" + File.separator + UPLOAD_DIR;
             File fileUploadDirectory = new File(uploadPath);
        if (!fileUploadDirectory.exists()) {
            fileUploadDirectory.mkdirs();
        }
          String savePath = uploadPath + File.separator + fileName;
        System.out.println("savePath: " + savePath);
        String sRootPath = new File(savePath).getAbsolutePath();
        System.out.println("sRootPath: " + sRootPath);
        part.write(savePath + File.separator);
//        File fileSaveDir = new File(savePath);
          dbFileName = UPLOAD_DIR + fileName;
        part.write(savePath + File.separator);
            Items item=new Items(id,itemname,price,quantity,dbFileName,savePath);
            adminpageDAO.addItem(item);
    }

    protected void deleteFunc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id=request.getParameter("code");
        adminpageDAO.deleteItem(id); 
    }
    protected void editFunc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String id=request.getParameter("itemId");
            String itemname=request.getParameter("itemName");
            int price=Integer.parseInt(request.getParameter("itemPrice"));
            int quantity=Integer.parseInt(request.getParameter("itemQuantity"));
         Part part=request.getPart("itemPhoto");
            String fileName=extractFileName(part);
            String applicationPath = getServletContext().getRealPath("");
            String uploadPath = "E:\\adminpageofficial\\web\\img" + File.separator + UPLOAD_DIR;
             File fileUploadDirectory = new File(uploadPath);
        if (!fileUploadDirectory.exists()) {
            fileUploadDirectory.mkdirs();
        }
          String savePath = uploadPath + File.separator + fileName;
        System.out.println("savePath: " + savePath);
        String sRootPath = new File(savePath).getAbsolutePath();
        System.out.println("sRootPath: " + sRootPath);
        part.write(savePath + File.separator);
//        File fileSaveDir = new File(savePath);
          dbFileName = UPLOAD_DIR + File.separator + fileName;
        part.write(savePath + File.separator);
            Items item=new Items(id,itemname,price,quantity,dbFileName,savePath);
        adminpageDAO.updateItem(item); 
    }
    private String extractFileName(Part part){
        String contentDisp=part.getHeader("content-disposition");
        String[] items=contentDisp.split(";"); 
        for(String s : items){
            if(s.trim().startsWith("filename")){
                return s.substring(s.indexOf("=")+2,s.length()-1);
            }
        }
        return "";
    }


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
