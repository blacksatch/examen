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
     
     <!-- Pantalla Registro -->
     <form class="form-signin" action="./ServletValidaUsuario" method="post">
         <table align="center" class="table2">
             <tr align="center">
                 <td colspan="2">
                     <h2 class="form-signin-heading" style="color: white ">Registro CTM</h2>
                 </td>
             </tr>
             <tr>
                 <td>
                     <label class="label2">Rut</label>
                 </td>
                 <td>
                     <input type="text" name="txtRutReg" class="form-signin" placeholder="Ingrese Rut" required autofocus>
                 </td>
                 <td class="asteriscoRojo">*</td>
             </tr>
             <tr>
                 <td>
                     <label class="label2">Clave</label>
                 </td>
                 <td>
                     <input type="password" name="txtClaveReg" class="form-signin" placeholder="Ingrese Clave" required autofocus>
                 </td>
                 <td class="asteriscoRojo">*</td>
             </tr>
             <tr>
                 <td>
                     <label class="label2">Confirmar Clave</label>
                 </td>
                 <td>
                     <input type="password" name="txtConfClaveReg" class="form-signin" placeholder="Confirme Clave" required autofocus>
                 </td>
                 <td class="asteriscoRojo">*</td>
             </tr>
             <tr>
                 <td>
                     <label class="label2">Nombre</label>
                 </td>
                 <td>
                     <input type="text" name="txtNombreReg" class="form-signin" placeholder="Ingrese Nombre" required autofocus>
                 </td>
                 <td class="asteriscoRojo">*</td>
             </tr>
             <tr>
                 <td>
                     <label class="label2">Apellido Paterno</label>
                 </td>
                 <td>
                     <input type="text" name="txtApPaternoReg" class="form-signin" placeholder="Apellido Paterno" required autofocus>
                 </td>
                 <td class="asteriscoRojo">*</td>
             </tr>
             <tr>
                 <td>
                     <label class="label2">Apellido Materno</label>
                 </td>
                 <td>
                     <input type="text" name="txtApMaternoReg" class="form-signin" placeholder="Apellido Materno" required autofocus>
                 </td>
                 <td class="asteriscoRojo">*</td>
             </tr>
             <tr>
                 <td>
                     <label class="label2">Dirección</label>
                 </td>
                 <td>
                     <input type="text" name="txtDireccionReg" class="form-signin" placeholder="Ingrese Dirección" required autofocus>
                 </td>
                 <td class="asteriscoRojo">*</td>
             </tr>
             <tr>
                 <td>
                     <label class="label2">Numeración</label>
                 </td>
                 <td>
                     <input type="text" name="txtNumeracionReg" class="form-signin" placeholder="Ingrese Numeracion" required autofocus>
                 </td>
                 <td class="asteriscoRojo">*</td>
             </tr>
             <tr>
                 <td>
                     <label class="label2">Comuna</label>
                 </td>
                 <td>
                    <select name="cmb_Ciudades">
                        <option> Seleccionar </option>
                            <c:forEach var="Ciudad" items="${sessionScope.sesion_lista_comuna}">
                                <option value="${Ciudad.getCiudad_id()}">
                                    ${Ciudad.getCiudad_nombre()}
                                </option>
                            </c:forEach>
                    </select>
                 </td>
                 <td class="asteriscoRojo">*</td>
             </tr>
             <tr>
                 <td>
                     <label class="label2">Rut</label>
                 </td>
                 <td>
                     <input type="text" name="txtRutReg" class="form-signin" placeholder="Ingrese Rut" required autofocus>
                 </td>
                 <td class="asteriscoRojo">*</td>
             </tr>
            
             <tr>
                 <td>
                     <a href="index.jsp"><button name="btnVolverReg" type="button" class="btn btn-lg btn-link">Volver</button></a>
                 </td>
                 <td>
                     <button name="btnRegistrar" style="width: 100%" class="btn btn-lg btn-warning btn-block" type="submit">REGISTRAR</button>
                 </td>
             </tr>
             <tr>
                 
             </tr>
            
         </table>
     </form>
    </body>
</html>

