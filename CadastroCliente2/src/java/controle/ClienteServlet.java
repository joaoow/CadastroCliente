/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Cliente;

/**
 *
 * @author sala305b
 */
@WebServlet(name = "ClienteServlet", urlPatterns = {"/ClienteServlet"})
public class ClienteServlet extends HttpServlet {

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

        String nomecompleto = request.getParameter("nome");
        String tipodocumento = request.getParameter("tpdocumento");
        String documento = request.getParameter("documento");
        String sexo = request.getParameter("sexo");
        String dddtelefone = request.getParameter("dddtelefone");
        String email = request.getParameter("email");
//        String cep = request.getParameter("cep");
//        String logradouro = request.getParameter("logradouro");
//        String numero = request.getParameter("numero");
//        String bairro = request.getParameter("bairro");
//        String cidade = request.getParameter("cidade");
//        String uf = request.getParameter("uf");
        String escolaridade = request.getParameter("escolaridade");
        Date dtnascimento = Date.valueOf(
                request.getParameter("datanascimento"));

        Cliente cli = new Cliente();
        cli.setNome(nomecompleto);
        cli.setDocumento(documento);
        cli.setDtNascimento(dtnascimento);
        cli.setEmail(email);
        cli.setEscolaridade(escolaridade);
        cli.setSexo(sexo);
        cli.setTpDocumento(tipodocumento);

        String dddTelLimpo = dddtelefone.replace(" ", "")
                .replace("-", "")
                .replace("(", "")
                .replace(")", "");

        //27987654321
        String ddd = dddTelLimpo.substring(0, 2);
        String telefone = "";

        // Jeito  de IF Ternário
//        String telefone = dddTelLimpo.length() == 10
//                ? dddTelLimpo.substring(2, 6)
//                + "-" + dddTelLimpo.substring(6)
//                : dddTelLimpo.substring(2, 7)
//                + "-" + dddTelLimpo.substring(7);
        if (dddTelLimpo.length() == 10) {
            telefone = dddTelLimpo.substring(2, 6)
                    + "-" + dddTelLimpo.substring(6);
        } else {
            telefone = dddTelLimpo.substring(2, 7)
                    + "-" + dddTelLimpo.substring(7);
        }
        cli.setDdd(ddd);
        cli.setTelefone(telefone);
        
        long novoId = cli.Cadastrar();
        
        if (novoId > 0) {
//            idcliente = 1,ou 2,ou 3, etc.
//            request.setAttribute("idcliente", novoId);
//            request.getRequestDispatcher("listar.jsp")
//                    .forward(request, response);
            
            response.sendRedirect("listar.jsp");
            
        } else {
            String mensagem
                    = "<h1>Cadastro não Efetuado</h1>";
            response.getWriter().print(mensagem);
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
