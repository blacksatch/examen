/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Blacksatch
 */
public class Util 
{
    public void RegistrarLog(String tipo, String mensaje)
    {
        
        Calendar calendario = new GregorianCalendar();
        
        int hora;
        int minutos;
        int segundos;
        int fecha;    
        
        String minutosFormat = "";
        
        try
        {
            
            hora = calendario.get(Calendar.HOUR);
            minutos =  calendario.get(Calendar.MINUTE);
            segundos =  calendario.get(Calendar.SECOND);
            fecha = calendario.get(Calendar.DATE);
            
            if(minutos < 10) minutosFormat = "0" + minutos;
            else minutosFormat = String.valueOf(minutos);
            
            String ContenidoMsj =  fecha + " // " + hora + ":" + minutosFormat + ":" + segundos + ":" 
                    + " // " + tipo + " // " + mensaje; 
            
            File file = new File("C:/TestLog/Log.txt");
            
            if(!file.exists())
            {
                file.createNewFile();
            }
            
            FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
            BufferedWriter bw = new BufferedWriter(fw);
            
            bw.newLine();
            bw.write(ContenidoMsj);
            bw.close();
            
        }
        catch(Exception ex)
        {
              ex.printStackTrace();
        }
        
        
        
    }
}
