<!Doctype html>
<html>
 <head>
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jqueryui/1.12.1/jquery-ui.css"/>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.js"  ></script>
<script type="text/javascript" src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<script>
  $(document).ready(function(){
	  $("#accordion").accordion();
  });
 </script>
  </head>
 <body>
  <div id="accordion">
  
  <h3>Gravar Usuario</h3>
   <div>
     <form method="post" action="gravar.html">
       <br/>Nome<br/>
       <input type="text" name="nome"  size="50" id="nome" />
       <br/>Login<br/>
       <input type="text" name="login"  size="50" id="login" />
       <br/>Senha<br/>
       <input type="password" name="senha"  size="50" id="senha" />
       <br/>
       <button id="btn1" type="submit">Enviar Dados</button>
       </form>
       <br/>${msg}
  </div>
  
  
  
  <h3>Logar Usuario</h3>
   <div>
    <form method="post" action="logar.html">
       <br/>Login<br/>
       <input type="text" name="login"  size="50" id="login" />
       <br/>Senha<br/>
       <input type="password" name="senha"  size="50" id="senha" />
       <br/>
       <button id="btn1" type="submit">Logar</button>
       </form>
       <br/>${msg}
  </div>

  
  </div>
 
 
 
 </body>
 
 
 
</html>
