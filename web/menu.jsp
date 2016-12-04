<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : index
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
              <c:if var="x" test="${sessionScope.sesion_usuario_bienvenido != null}">
              <li><a style="color: white">Bienvenido(a) </a></li>
              <li><p class="navbar-text" style="color: white">${sessionScope.sesion_usuario_bienvenido}</p></li>
              <li><a href="./ServletLogOut">Cerrar Sesión</a></li>
              </c:if>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>
     </br>
     </br>
     </br>
     <form action="./ServletOpcion" method="post">
     <table align="center">
         <tr align="center">
             <td colspan="2">
                     <h2 class="form-signin-heading" style="color: white ">Menú</h2>
             </td>
         </tr>
         <tr>
             <td>
                 <input type="submit" name="lkGenerarPedido" class="bn btn-lg btn-link" value="Generar un Pedido"/>
             </td>
         </tr>
         <tr>
             <td>
                 <input type="submit" name="lkVerPedidos" class="bn btn-lg btn-link" value="Ver mis Pedidos"/>
             </td>
         </tr>
     </table>
    </form>
    </body>
</html>
