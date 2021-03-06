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
        <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.6.2/css/bootstrap-select.min.css" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.1/js/i18n/defaults-*.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.1/js/bootstrap-select.min.js"></script>
        <link rel="stylesheet" type="text/css" href="yourPath/silviomoreto-bootstrap-select-83d5a1b/dist/css/bootstrap-select.css">
        <link href="yourPath/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="starter-template.css" rel="stylesheet">
        <link href="../../assets/css/ie10-viewport-bug-workaround.css" rel="stylesheet">
        <link href="../../dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="estilo.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.1/css/bootstrap-select.css">
        <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.6.3/css/bootstrap-select.min.css" />
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
     
     <!-- Mensaje de Error Rut -->   
    <c:if test="${sessionScope.sesion_valida_rut_error == 1}">
        <div class="alert alert-danger">
            <strong>Error !!</strong> Ingrese rut válido.
        </div>
    </c:if>
     
     <!-- Pantalla Registro -->
     <form class="form-signin" action="./ServletValidaUsuario" method="post">
         <table align="center" class="table2">
             <tr align="center">
                 <td colspan="2">
                     <h2 class="form-signin-heading" style="color: white ">Registro</h2>
                 </td>
             </tr>
             <tr>
                 <td>
                     <label class="label2">Rut</label>
                 </td>
                 <td>
                     <input type="text" name="txtRutReg" class="form-singin" placeholder="Ingrese Rut" required autofocus>
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
                    
                     <select name="cmb_Comuna">
                        <option> Seleccionar </option>
                        <c:forEach var="x" items="${sessionScope.sesion_lista_comuna}">
                            <option value="${x.getIdComuna()}">
                                    ${x.getNombreComuna()}
                            </option>
                        </c:forEach>    
                    </select>
                 </td>
                 
                 <td class="asteriscoRojo">*</td>
             </tr>
             <tr>
                 <td>
                     <label class="label2">Teléfono</label>
                 </td>
                 <td>
                     <input type="text" name="txtTelefonoReg" class="form-signin" placeholder="Ingrese Teléfono" required autofocus>
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

