<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : Lista_pedidos
    Created on : 25-11-2016, 10:19:14 AM
    Author     : yo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="starter-template.css" rel="stylesheet">
        <link href="../../assets/css/ie10-viewport-bug-workaround.css" rel="stylesheet">
        <link href="../../dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="estilo.css" rel="stylesheet" type="text/css"/>
        <title>Donde La Abuela</title>
    </head>
    <body>
     <!--Navegador superior -->
     <nav class="navbar navbar-default navbar-fixed-top" style="background-color:  peru">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" aria-controls="navbar">   
                    
          </button>
            <a class="navbar-brand" style="color: white">Donde La Abuela</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
              <li><a style="color: white">Bienvenido(a) </a></li>
            <li class="active"><a href="./">Fixed top <span class="sr-only">(current)</span></a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>
     </br>
     </br>
     </br>
    <body>
        <h1>Listar Pedidos</h1>
        
        <form method="post" action="">
            <table>
                <tr>
                    <td>Codigo</td>
                    <td>Plato</td>
                    <td>Bedida</td>
                    <td>Entrega</td>
                    <td>Telefono</td>
                    <td>Comuna</td>
                    <td>Ingreso</td>
                    <td>Total</td>
                </tr>
                <c:forEach var="x" items="sesion_Lista_Pedidos">
                    <tr>
                        <td>x.getIdPedido()</td>
                        <td>x.getNombrePlato()</td>
                        <td>x.getNombreBebida()</td>
                        <td>x.getDireccionCliente()</td>
                        <td>x.getTelefonoCliente()</td>
                        <td>x.getNombreComuna()</td>
                        <td>x.getFechaPedido()</td>
                        <td>x.getTotal()</td>
                    </tr>
                </c:forEach>
            </table>
        </form>
        
    </body>
</html>
