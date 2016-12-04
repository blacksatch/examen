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
     
     <!-- Login -->
     <form class="form-signin" action="./ServletValidaUsuario" method="post">
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
             <tr>
                 <td>
                     <a href="registro.jsp"><button name="btnRegistrar" type="button" class="btn btn-lg btn-link">Registrar</button></a>
                 </td>
             </tr>
            
         </table>
     </form>
    </body>
</html>
