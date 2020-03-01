/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import ejb.BlockChainBeanLocal;
import entity.Block;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author admin
 */
public class BlockChainSubmit extends HttpServlet {

    @EJB
    BlockChainBeanLocal bcbl;

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet BlockChainSubmit</title>");
            out.println("</head>");
            out.println("<body>");
            String fileName = (String) request.getParameter("txtFileName");
            String fileData = (String) request.getParameter("txtData");

            File file = new File("F:\\sem8\\java\\assignment\\EnterpriseJavaApplications\\BlockChain\\" + fileName);
            boolean exists = file.exists();

            if (exists == false) {
                file.createNewFile();
                FileOutputStream fileOutputStream = new FileOutputStream(file, false);

                if (bcbl.getAllBlock().isEmpty()) {
                    bcbl.generateGenesis();
                } else {
                    Block block = new Block();
                    block.setFileName(fileName);
                    block.setData(fileData);
                    bcbl.addBlock(block);
                }

            } else {
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
                bufferedWriter.write(fileData);
                bufferedWriter.close();
                if (bcbl.getAllBlock().size() == 0) {
                    bcbl.generateGenesis();
                } else {
                    Block block = new Block();
                    block.setFileName(fileName);
                    block.setData(fileData);
                    bcbl.addBlock(block);
                }
            }

            out.println("</body>");
            out.println("</html>");
        }
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
