<%-- 
    Document   : listar
    Created on : 28/03/2022, 08:06:26
    Author     : sala305b
--%>

<%@page import="java.util.List"%>
<%@page import="modelo.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listagem</title>
    </head>
    <body>

        <%
            List<Cliente> clientes = new Cliente().ListarTodos();
        %>

        <table border="1" cellspacing="0" cellpadding="5">
            <tr>
                <th>ID</th>
                <th>Nome</th>
                <th>Documento</th>
                <th>DDD/Telefone</th>
                <th>Data Cadastro</th>
                <th>Ações</th>
            </tr>
            <%
                for (Cliente c : clientes) {
                    out.print("<tr>");

                    out.print("<td>");
                    out.print(c.getId());
                    out.print("</td>");

                    out.print("<td>");
                    out.print(c.getNome());
                    out.print("</td>");

                    out.print("<td>");
                    out.print(c.getTpDocumento() + " - " + c.getDocumento());
                    out.print("</td>");

                    out.print("<td>");
                    out.print("(" + c.getDdd() + ") " + c.getTelefone());
                    out.print("</td>");

                    out.print("<td>");
                    out.print(c.getDtCadastro());
                    out.print("</td>");

                    out.print("<td>");
                    out.print("<form action='ClienteServlet' method='POST'>");
                    out.print("<input name='editar' type='hidden' value='" + c.getId() + "' />");
                    out.print("<button type='submit'>Editar</button>");
                    out.print("</form>");
                    out.print("</td>");
                    
                    out.print("<td>");
                    out.print("<form action='ClienteServlet' method='POST'>");
                    out.print("<input name='apagar' type='hidden' value='" + c.getId() + "' />");
                    out.print("<button type='submit'>Deletar</button>");
                    out.print("</form>");
                    out.print("</td>");

                    out.print("</tr>");
                }
            %>

        </table>

    </body>
</html>
