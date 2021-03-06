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
        
    <!-- Mensaje de Registro satisfactorio -->   
    <c:if test="${sessionScope.sesion_ingreso_correcto == 1}">
        <script type="text/javascript">
            alert("Cliente registrado satisfactoriamente");
        </script>
    </c:if>
        
    <!-- Mensaje de Error loguin -->   
    <c:if test="${sessionScope.sesion_valida_mal == 1}">
        <script type="text/javascript">
            alert("Usuario/Contraseña invalido. Reintentar");
        </script>
    </c:if>
    
     <!--Navegador superior -->
     <nav class="navbar navbar-default navbar-fixed-top" style="background-color:  peru">
      <div class="container">
        <div class="navbar-header">
          <!--<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" aria-controls="navbar">   
            
          </button>-->
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
        </div>
             
      </div>
    </nav>
     </br>
     </br>
     </br>
     
     <!-- Login -->
     <form name="frmLogin" class="form-signin" action="./ServletValidaUsuario" method="post">
         <table align="center">
             <tr align="center">
                 <td colspan="2">
                     <h2 class="form-signin-heading" style="color: white ">Acceso</h2>
                 </td>
             </tr>
             <tr>
                 <td>
                     <label style="color: white; font-size: 15px">Rut</label>
                 </td>
                 <td>
                     <input type="text" name="txtRutLog" class="form-control" placeholder="Ingrese Rut" required autofocus>
                 </td>
             </tr>
             <tr>
                 <td>
                     <label style="color: white; font-size: 15px" for="inputPassword">Clave</label>
                 </td>
                 <td>
                     <input type="password" name="txtPassLog" id="inputPassword" class="form-control" placeholder="Ingrese Clave" required>
                 </td>
             </tr>
             <tr align="center">
                 <td colspan="2">
                     <button name="btnIngresar" style="width: 100%" class="btn btn-lg btn-warning btn-block" type="submit">INGRESAR</button>
                 </td>
             </tr>
        </table>  
     </form>
     <form action="./ServletValidaUsuario" method="get">
         <table align="center">
            <tr>
                 <td>
                     <input type="submit" name="btnRegistrar2" class="bn btn-lg btn-link" value="Registrar"/>
                 </td>
             </tr>
         </table>
     </form>
    </body>
</html>
