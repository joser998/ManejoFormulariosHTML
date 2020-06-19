package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        response.setContentType("text/html;charset=UTF-8");
        
        //Generamos la respuesta
        PrintWriter out = response.getWriter();
        
        String usuario = request.getParameter("usuario");//la variable usuario tiene que ser la misma que agregamos en nuestro formulario
        String password = request.getParameter("password");//variable que recibe el password del index.html
        
        /*Se declara una arreglo, y se solicita con getParameterValues por que puede pedir varios valores*/
        String tecnologias[] = request.getParameterValues("tecnologia");
        String genero = request.getParameter("genero");
        String ocupacion = request.getParameter("ocupacion");
        String musica[] = request.getParameterValues("musica");
        String comentarios = request.getParameter("comentarios");
        
        /*Incrustamos codigo HTML en una clase de Java como lo es este Servlet*/
        out.print("<html>");
        out.print("<head>");
        out.print("<tittle>Resultado Servlet</tittle>");
        out.print("</head>");
        out.print("<body>");
        out.print("<h1>Parametros procesados por el Servlet: </h1>");
        out.print("<table border='1'> ");
        
        /* Para poder observar el campo de Usuario y la variable*/
        out.print("<tr>");
        out.print("<td>");
        out.print("Usuario");
        out.print("</td>");
        out.print("<td>");
        out.print(usuario);
        out.print("</td>");
        out.print("</tr>");
        
        
        /*Para poder observar el campo de Password y el password*/
        out.print("<tr>");
        out.print("<td>");
        out.print("Password: ");
        out.print("</td>");
        out.print("<td>");
        out.print(password);
        out.print("</td>");
        out.print("</tr>");
        
        
        out.print("<tr>");
        out.print("<td>");
        out.print("Tecnologias: ");
        out.print("</td>");
        out.print("<td>");
        /*Para poder ver todos los valores*/
        for(String tecnologia: tecnologias){
            out.print(tecnologia);
            out.print(" / ");
        }
        out.print("</td>");
        out.print("</tr>");
        
   
        out.print("<tr>");
        out.print("<td>");
        out.print("Genero: ");
        out.print("</td>");
        out.print("<td>");
        out.print(genero);
        out.print("</td>");
        out.print("</tr>");
        
  
        out.print("<tr>");
        out.print("<td>");
        out.print("Ocupacion: ");
        out.print("</td>");
        out.print("<td>");
        out.print(ocupacion);
        out.print("</td>");
        out.print("</tr>");
        
  
        out.print("<tr>");
        out.print("<td>");
        out.print("Musica Favorita: ");
        out.print("</td>");
        out.print("<td>");
        /*Hacemos una condicion con 'if' que dice que musica es diferente de null muestre la info de lo contrario
            mostrar un texto de que no se proporciono ese dato... */
        /*Para poder ver todos los valores*/
        if(musica!= null){
        for(String m: musica){
            out.print(m);
            out.print(" / ");
        }
        }else{
            out.print("Valor no Proporcionado");
        }
        out.print("</td>");
        out.print("</tr>");
        
        out.print("<tr>");
        out.print("<td>");
        out.print("Comentarios: ");
        out.print("</td>");
        out.print("<td>");
        out.print(comentarios);
        out.print("</td>");
        out.print("</tr>");
        
        out.print("</table>");
        out.print("</body>");
        out.print("</html>");
    }
}