
/**
 * Ejercicio final de subir nota de Programación 1º DAW 2017 - 2018:
 *
 * @author Adan
 */

package subirnota;

import java.io.BufferedReader;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SubirNota {

    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        Scanner s2 = new Scanner(System.in);
        
        System.out.println("Introduce el Nº de lineas:");
        int numLineas = Integer.parseInt(s.nextLine());
        
        System.out.println("Introduce 1 o 2 para elegir alguna de estas opciones a la hora de generar el fichero: ");
        System.out.println("1) Fichero con numeros");
        System.out.println("2) Fichero sin numeros");
        int tipoFichero = Integer.parseInt(s.nextLine());
        
        File f = new File("generado.html");
        
        f.delete();
        
        BufferedWriter bw = new BufferedWriter(new FileWriter("generado.html", true));
        
        bw.write("<!DOCTYPE html>\n");
        bw.write("<html>\n");
        bw.write("<head>\n");
        bw.write("\n");
        bw.write("<meta charset=\"utf-8\">\n");
        bw.write("\n");
        bw.write("<title>Ejercicio para subir nota DAW 2017 - 2018</title>\n");
        bw.write("\n");
        bw.write("<style type=\"text/css\">\n");
        bw.write("\n");
        bw.write("#titulo {color: black;\n");
        bw.write("font-family: Verdana;\n");
        bw.write("text-align: center;\n");
        bw.write("text-shadow: 0 0 0.2em #8F7;\n");
        bw.write("padding: 10px;\n");
        bw.write("margin-top: 10px;\n");
        bw.write("background-color: silver;\n");
        bw.write("border-width: thick;\n");
        bw.write("border-style: solid;\n");
        bw.write("border-color: black;}\n");
        bw.write("\n");
        bw.write("#resultado {color: black;\n");
        bw.write("font-family: Verdana;\n");
        bw.write("text-align: center;\n");
        bw.write("border-width: thick;\n");
        bw.write("border-style: solid;\n");
        bw.write("border-color: black;\n");
        bw.write("background-color: white;\n");
        bw.write("padding-bottom: 25px;}\n");
        bw.write("\n");
        bw.write("strong {color: black;\n");
        bw.write("font-family: Verdana;\n");
        bw.write("text-shadow: 0 0 0.2em red;}\n");
        bw.write("\n");
        bw.write("</style>\n");
        bw.write("\n");
        bw.write("</head>\n");
        bw.write("<body>\n");
        bw.write("\n");
        bw.write("<div id=\"titulo\">\n");
        bw.write("<h1>EJERCICIO PARA SUBIR NOTA DAW 2017 - 2018</h1>\n");
        bw.write("</div>\n");
        bw.write("\n");
        bw.write("<div id=\"resultado\">\n");
        bw.write("<h3>RESULTADO DEL FICHERO GENERADO ALEATORIAMENTE</h3>\n");
        bw.write("\n");
        
        int index = -1;
        
        String[] elementosCN={"0","1","2","3","4","5","6","7","8","9" ,"a",
                "b","c","d","e","f","g","h","i","j","k","l","m","n","ñ","o","p",
                "q","r","s","t","u","v","w","x","y","z","á","é","í","ó","ú"};
            
        String[] elementosSN={"a","b","c","d","e","f","g","h","i","j","k",
                "l","m","n","ñ","o","p","q","r","s","t","u","v","w","x","y","z",
                "á","é","í","ó","ú"};
        
        
        if (tipoFichero == 2) {
        
            try {
                
                String fin = "";
                
                File texto=new File("lemario.txt");
                
                for (int i = 1; i <= numLineas ; i++) {
                    
                    BufferedReader lector;
                    lector=new BufferedReader(new FileReader("lemario.txt"));
                    String palabraDic = "";
                
                    String linea = "";
                
                    for (int x = 0; x <= 100; x ++) {
                        int numAleatorio = (int)Math.floor(Math.random() * (elementosSN.length - 1));
                        linea = linea.concat(elementosSN[numAleatorio]);

                    }
                    
                    while (palabraDic != null) {
                        
                        palabraDic = lector.readLine();
            
                        if (palabraDic == null){
                            lector.close();
                            break;
                        }
                        
                        if ((linea.contains(palabraDic)) && (palabraDic.length() >= 3 )) {
                            System.out.println("Encontrado: " + palabraDic);
                            index = linea.indexOf(palabraDic);
                            
                            String resultado = "<strong>"+linea.substring(index, (index + palabraDic.length()))+"</strong>";
//                            System.out.println(resultado);
                            fin = linea.replace(palabraDic, resultado);
                            bw.write(fin+"</br>");
                            linea = "";
                        }
                        
                    }
                    
                    if (linea == "") {
                        bw.write(linea+"\n");
                    } else {
                        bw.write(linea+"</br>\n");
                    }
                    
                }
            
                System.out.println("Fichero generado correctamente!");
        
            } catch (IOException e) {
                e.printStackTrace();
            }
        
        } else if (tipoFichero == 1) {
            
            try {
                
                String fin = "";
                
                File texto=new File("lemario.txt");
            
                for (int i = 1; i <= numLineas ; i++) {
                
                    BufferedReader lector;
                    lector=new BufferedReader(new FileReader("lemario.txt"));
                    String palabraDic = "";
                    
                    String linea = "";
                
                    for (int x = 0; x <= 100; x ++) {
                        int numAleatorio = (int)Math.floor(Math.random() * (elementosCN.length - 1));
                        linea = linea.concat(elementosCN[numAleatorio]);
                    
                    }
                    
                    while (palabraDic != null) {
                        
                        palabraDic = lector.readLine();
            
                        if (palabraDic == null){
                            lector.close();
                            break;
                        }
                        
                        if ((linea.contains(palabraDic)) && (palabraDic.length() >= 3 )) {
                            System.out.println("Encontrado: " + palabraDic);
                            index = linea.indexOf(palabraDic); 
                            
                            String resultado = "<strong>"+linea.substring(index, (index + palabraDic.length()))+"</strong>";
//                            System.out.println(resultado);
                            
//                            System.out.println("TAG----");
//                            System.out.println(linea);
//                            System.out.println(linea.replace(palabraDic, resultado));
                            fin = linea.replace(palabraDic, resultado);
                            bw.write(fin+"</br>");
                            linea = "";
                        }                
                    }
                    if (linea == "") {
                        bw.write(linea+"\n");
                    } else {
                        bw.write(linea+"</br>\n");
                    }
                }
            
                System.out.println("Fichero generado correctamente!");
        
            } catch (IOException e) {
                e.printStackTrace();
            }
            
        } else {
            System.out.println("Numero introducido incorrecto. Por favor, introduce un numero válido");
        }
        
        bw.write("\n");
        bw.write("</div>\n");
        bw.write("\n");
        bw.write("</body>\n");
        bw.write("</html>\n");
        bw.close();
    }
}
