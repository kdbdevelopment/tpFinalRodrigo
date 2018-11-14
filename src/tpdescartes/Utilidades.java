/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpdescartes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;


/**
 *
 * @author ifts16
 
 La presente es una libreria generica que permite exportar e importar los elementos de la base de datos al
 formato CSV. Este formato es de texto plano y lo que hace es muy sencillo: cada fila de una tabla está  
 representada como una linea de texto en el archivo, cada columna se encuentra separada de las otras por una
 coma y el valor de la celda encerrada entre comillas.
 Ejemplo: "Juan","Perez","23","Calle Falsa 123","juan@perez.com"
 Para utilizar esta librería se deben modificar y agregar las columnas correspondientes a su proyecto.
 * 
 * Ademas, se incluyen dos metodos para hacer conversiones entre String (texto) y Date
 * (fecha) a un formato compatible con MySQL.
 */
public class Utilidades {
    
    public static Date textoAFecha(String textoConFecha) {
        // A este metodo se le provee un String y devuelve un objeto de tipo fecha
        // con un formato compatible a MySQL
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date fecha;
        try {
           fecha = sdf.parse(textoConFecha); 
        } catch (ParseException e) {
            fecha = new Date();
            System.out.println(e.getMessage());
        }
        return fecha;
    }
    
    public static String fechaATexto(Date fecha) {
        // Este metodo recibe un objeto de tipo Date (fecha) y lo convierte a un
        // String correspondiente.
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return sdf.format(fecha);
    }
    
    public static void exportar(File archivoSeleccionado, Query consulta) {
         // El método exportar requiere dos argumentos, el primero que debemos proveerlo es el archivo seleccionado
        // con el JFileChooser para ser guardado. Este método está pensado para ser usado justo después de que se haya
        // seleccionado el archivo con el JFileChooser para exportar.
        // El segundo argumento tiene el tipo Query y se trata de un objeto capaz de hacer consultas directamente 
        // a la tabla con los elementos, en este método lo usaremos para traer todos los elementos de la tabla y volcarlos
        // al archivo Utilidades que crearemos.
        
        
       // FileWriter es una utilidad básica de Java para escribir archivos de texto plano. Básicamente a esta utilidad
       // luego le asociaremos un archivo al cual le pasaremos cadenas de texto que se irán incluyendo en el mismo.
        // Para ello se utiliza el método write y como argumento requiere un String. El valor null que se asigna ahora
        // significa que ese valor es nulo, esto se hace normalmente cuando la variable nos pide un valor (null es un valor)
        // pero todavía no podemos asignarle uno real.
        // La segunda línea hace que el objeto consulta o query se conecte directamente con la base de datos para traer todas las 
        // filas que se encuentren en la misma y las vuelca una a una en una lista de las Entidades de la tabla
        FileWriter nuevoArchivo = null;
       List<DescartesDeTallado> lista = consulta.getResultList();
        
           // La estructura try catch es el principal mecanismo para trabajar con errores en Java. El programa ejecutará
           // todo lo que se encuentre dentro del bloque try se intentará ejecutar. Si se presenta alguna falla en la 
           // ejecución de los mismos pasará al bloque catch y ejecutará lo que se encuentre en el mismo. En el bloque
           // catch debemos escribir el código indicando al programa cómo comportarse en caso de error y de ser
           // posible asegurar que el sistema siga funcionando en un estado deseable. Pueden existir más de un bloque
           // catch para un único try donde cada uno de ellos se encarga de un tipo de error particular. A su vez, podemos
           // tener bloques try catch dentro de otros. Al final tenemos un bloque finally que se ejecutará al terminar todos
           // los bloques anteriores e independientemente del éxito o fracaso que hayan tenido. Éste último bloque es
           // opcional.
           try {
               // En las siguientes dos líneas de código nos encargamos de crear el archivo y dejarlo abierto para ir
               // escribiéndolo a medida que lo necesitemos. La primer línea crea un objeto de tipo archivo al que
               // le asignamos el archivo seleccionado en el diálogo. En la segunda línea asignamos un valor (que 
               // hasta ahora era null al FileWriter, para crearlo en su constructor debemos indicarle el archivo específico
               // que queremos crear o sobre el que queremos escribir. Para ello utilizamos el método getAbsolutePath()
               // que devuelve un String con la dirección completa del archivo en el sistema operativo (empezando por C:
               // o / en Linux o Mac OS X) y terminando con el nombre del archivo y su extensión. Esta variable nuevoArchivo
               // es nuestro acceso al archivo en el disco rígido y sobre el que estaremos escribiendo.
               File archivo = archivoSeleccionado;
               nuevoArchivo = new FileWriter(new File(archivo.getAbsolutePath()));
               
               // Ésta es una manera especial de escribir un for loop cuando tenemos que iterar sobre una lista. El lenguaje
               // de programación sabe dónde empieza, termina y cómo avanzar sobre cualquier lista, por lo que nos podemos
               // saltear esas explicaciones. El segundo elemento que se encuentra detrás de los dos puntos es la lista 
               // sobre la que se debe iterar, el primero es como se dará en llamar el elemento de la lista sobre el que
               // se esté trabajando en esa iteración y cuál es su tipo. Esto funciona de manera análoga a la variable i
               // en el for loop tradicional, cuyo valor va variando a lo largo de las iteraciones. 
               for (DescartesDeTallado entidad : lista) {
                   // Dentro del bloque del for loop se avanza elemento por elemento dentro de la tabla, cada iteración completa
                   // se corresponderá con una línea dentro del archivo Utilidades. Una línea dentro del archivo Utilidades corresponde
                   // a una fila dentro de la base de datos, los atributos de la clase Entidad se corresponden con las columnas
                   // de la tabla. Por ello, para acceder a cada celda debemos crear un objeto con toda la fila y de allí acceder
                   // a cada celda a través de los getters del objeto. Los valores deben estar entre comillas al escribirlos
                   // al archivo
                   nuevoArchivo.write('"' + entidad.getDtaid().toString() + '"');
                   nuevoArchivo.write(",");
                   nuevoArchivo.write('"' + entidad.getDtamotivo()+ '"');
                   nuevoArchivo.write(",");
                   nuevoArchivo.write('"' + entidad.getDtacant().toString() + '"');
                   nuevoArchivo.write(",");
                   nuevoArchivo.write('"' + entidad.getDtamaterial()+ '"');
                   nuevoArchivo.write(",");
                   nuevoArchivo.write('"' + entidad.getDtatratamiento()+ '"');
                   nuevoArchivo.write(",");
                   nuevoArchivo.write('"' + entidad.getDtacolor()+ '"');
                   nuevoArchivo.write(",");
                   nuevoArchivo.write('"' + entidad.getDtaojo()+ '"');
                   nuevoArchivo.write(",");
                   nuevoArchivo.write('"' + entidad.getDtabase()+ '"');
                   nuevoArchivo.write(",");
                   nuevoArchivo.write('"' + entidad.getDtafecha()+ '"');
                   nuevoArchivo.write(",");
                   nuevoArchivo.write('"' + entidad.getDtanumtrab()+ '"');
                   nuevoArchivo.write(System.lineSeparator()); 
               }
               System.out.println("Tabla convertida a CSV");
           } catch (IOException e) {
               System.out.println("Error al escribir archivo");
	       e.printStackTrace();
           } finally {
               try {
                   System.out.println("Cerrando");
                   nuevoArchivo.close();
               } catch (IOException e) {
                    System.out.println("Error al cerrar archivo");
	            e.printStackTrace();
               }
           }
            
    }
    
    public static void importar(File archivoSeleccionado, EntityManager gestorBaseDatos) {
        // El método importar requiere dos argumentos, el primero que debemos proveerlo es el archivo seleccionado
        // con el JFileChooser para ser abierto. Este método está pensado para ser usado justo después de que se haya
        // seleccionado el archivo con el JFileChooser para importar.
        // El segundo argumento es del tipo EntityManager, es la clase que nos brinda JPA para interactuar con la  
        // base de datos. Éste nos permite hacer transacciones nativas o a través de objetos tal como lo trabajamos
        // previamente. La misma tiene que estar disponible una vez que sincronizamos nuestra tabla con 
        // Se puede poner cualquier extensión al archivo, pero se recomienda darle .csv para que otros programas
        // (como Microsoft Excel o LibreOffice Calc) lo puedan reconocer.
 
       
        BufferedReader buffer = null;

            // La estructura try catch es el principal mecanismo para trabajar con errores en Java. El programa ejecutará
           // todo lo que se encuentre dentro del bloque try se intentará ejecutar. Si se presenta alguna falla en la 
           // ejecución de los mismos pasará al bloque catch y ejecutará lo que se encuentre en el mismo. En el bloque
           // catch debemos escribir el código indicando al programa cómo comportarse en caso de error y de ser
           // posible asegurar que el sistema siga funcionando en un estado deseable. Pueden existir más de un bloque
           // catch para un único try donde cada uno de ellos se encarga de un tipo de error particular. A su vez, podemos
           // tener bloques try catch dentro de otros. Al final tenemos un bloque finally que se ejecutará al terminar todos
           // los bloques anteriores e independientemente del éxito o fracaso que hayan tenido. Éste último bloque es
           // opcional.
            try {
                // En las siguientes dos líneas de código nos encargamos de crear el archivo y dejarlo abierto para ir
               // escribiéndolo a medida que lo necesitemos. La primer línea crea un objeto de tipo archivo al que
               // le asignamos el archivo seleccionado en el diálogo. En la segunda línea asignamos un valor (que 
               // hasta ahora era null al BufferedReader, para crearlo en su constructor debemos indicarle el archivo específico
               // que queremos crear o sobre el que queremos escribir. Para ello utilizamos el método getAbsolutePath()
               // que devuelve un String con la dirección completa del archivo en el sistema operativo (empezando por C:
               // o / en Linux o Mac OS X) y terminando con el nombre del archivo y su extensión. Esta variable nuevoArchivo
               // es nuestro acceso al archivo en el disco rígido y sobre el que estaremos escribiendo.
                String linea = "";
                File archivo = archivoSeleccionado;
                buffer = new BufferedReader(new FileReader(archivo.getAbsolutePath()));
                
                gestorBaseDatos.getTransaction().begin();
                gestorBaseDatos.createNativeQuery("DELETE FROM descartes.descartes_de_tallado").executeUpdate();
                gestorBaseDatos.createNativeQuery("ALTER TABLE descartes.descartes_de_tallado AUTO_INCREMENT = 1").executeUpdate();
                gestorBaseDatos.getTransaction().commit();
                
                // Inciamos una transaccion donde tomamos el archivo linea por linea.
                // A cada linea se la divide donde encuentre las comas que separan las
                // columnas. Lo que queda como resultado es un vector de Strings.
                // Luego necesitamos trabajar con cada String particular donde le
                // iremos sacando las comillas.
                // Finalmente, creamos una nueva entidad y utilizamos los setters
                // para asignar los valores y persistirlos en la base de datos.
                gestorBaseDatos.getTransaction().begin();
                while ((linea = buffer.readLine()) != null) {
                   String[] valores = linea.split(","); 
                    String stId= valores[0].replace("\"","");
                   Integer intId = Integer.parseInt(stId);
                   
                   String stMotivo = valores[1].replace("\"","");
                   String stCant = valores[2].replace("\"","");
                   Integer intCant = Integer.parseInt(stCant);                   
                   String stMaterial = valores[3].replace("\"","");
                   String stTratamiento = valores[4].replace("\"","");
                   String stColor = valores[5].replace("\"","");
                   String stOjo = valores[6].replace("\"","");
                   String stBase = valores[7].replace("\"","");
                   String stFecha = valores[8].replace("\"","");
                   String stNumTrab = valores[9].replace("\"","");
                   
                   DescartesDeTallado entidad =new DescartesDeTallado();
                   
                   entidad.setDtaid(intId);
                   entidad.setDtanumtrab(stNumTrab);
                   entidad.setDtabase(stBase);
                   entidad.setDtacant(intCant);
                   entidad.setDtacolor(stColor);
                   entidad.setDtafecha(stFecha);
                   entidad.setDtamaterial(stMaterial);
                   entidad.setDtamotivo(stMotivo);
                   entidad.setDtaojo(stOjo);
                   entidad.setDtatratamiento(stTratamiento);
                   
                   gestorBaseDatos.persist(entidad);
                   
                }
                gestorBaseDatos.getTransaction().commit();
                System.out.println("Tabla convertida desde CSV");
            } catch (IOException e) {
               System.out.println("Error al abrir archivo");
	       e.printStackTrace();
            } finally {
                try {
                    buffer.close();
                } catch (IOException e) {
                    System.out.println("Error al cerrar buffer");
                    e.printStackTrace();
                }
            }

    }                                     

    
}
