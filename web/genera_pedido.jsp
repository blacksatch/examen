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
              <li><a style="color: white">Bienvenido(a) </a></li>
            <li class="active"><a href="./">Fixed top <span class="sr-only">(current)</span></a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>
     </br>
     </br>
     </br>
     
     <form>
         <table align="center">
             <tr align="center">
                 <td colspan="2">
                     <h2 class="form-signin-heading" style="color: white ">Agregar Pedido</h2>
                 </td>
             </tr>
             <tr>
                <td>
                    <label style="color: white; font-size: 15px">Plato</label>
                </td>
                <td>
                    <select name="cmb_Ciudades">
                        <option> Seleccionar Plato</option>
                        <c:forEach var="x" items="${sessionScope.sesion_obtiene_platos}">
                            <option value="${sessionScope.x.getIdPlato()}">${sessionScope.x.getIdPlato()} - $${sessionScope.x.getPrecioPlato()}</option>
                        </c:forEach>    
                    </select>
                </td>
             </tr>
             <tr>
                <td>
                    <label style="color: white; font-size: 15px">Bebida</label>
                </td>
                <td>
                    <c:forEach var="x" items="${sessionScope.sesion_obtiene_bebidas}">
                        <label class="radio-inline" style="color: whitesmoke"><input type="radio" name="optradio" value="${sessionScope.x.getIdBebida()}">
                            ${sessionScope.x.getNombreBebida()} $${sessionScope.x.getPrecioBebida()}</label>
                    </c:forEach>
                </td>
             </tr>
             <tr align="center">
                 <td colspan="2">
                     <button name="btnIngresar" style="width: 100%" class="btn btn-lg btn-warning btn-block" type="submit">INGRESAR</button>
                 </td>
             </tr>
             <tr>
                 <td>
                     <a href="./ServletValidaUsuario"><button name="btnRegistrar" type="submit" class="btn btn-lg btn-link btn-block ">Registrar</button></a>
                 </td>
             </tr>
        </table>
     </form>
     
    </body>
</html>
