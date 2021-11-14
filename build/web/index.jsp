<html>
    <head>
        <title>Universidad </title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/estilo.css" />
    </head>
    <body>

                <div align="center" class="container">
                      <img align="center" class= "logo" src="imagenes/logo.jpg" alt="logo">

                    <section style ="text-align: center" class="section1"> 

                        <fieldset>   
                        <h1 style ="text-align: center;">LOGIN</h1>

                         <img align="center" class= "logousuario" src="imagenes/logousuario.jpg" alt="logo"><br>
                         <a href="principal.html" > Principal </a>
                         
            <form method="post" action="ControladorUsuario">
                            <input type="text" id="usuario" placeholder="Usuario" name="usuario"><br>
                            <input type="password" id="contraseña" placeholder="Contraseña" name="clave"><br><br>

                            <input class="botonppal" type="submit" value="Ingresar" name="btnIngreso"><br>

                            </form>
                        </fieldset>

                    </section>

                </div>
                      
        <script src="js/js.js">
        </script><br>
    </body>
</html>