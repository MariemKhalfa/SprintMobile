/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codename1.gui.pheonixui;

import com.codename1.util.regex.RE;
import java.util.Date;
import com.codename1.Entite.Activite;

/**
 *
 * @author Lynda
 */
public class ControleSaisie {

     
  

    public static boolean isString(String text) {

        RE d = new RE("^[a-zA-Z]+$");

        if (d.match(text)) {

            return true;

        } 

            return false;

    }

     public static boolean isNull(String text){

         if(text == ""){

             return true; //null

         }

         return false ;//n'est pas vide

     }

     
     public static boolean isValidDate(Date date) {
 
         return date.getTime()>=new Date().getTime();
       
        

    }

          public static boolean isNumberAge(String text) {


        if ( Integer.parseInt(text)>0 && Integer.parseInt(text)<18) {

            return true;

        } else {

            return false;

        }

    }
           public static boolean isHeure(String text) {


        RE h = new RE("[00-23]:[00-59]");
      if (h.match(text)) {

            return true;

        } 

            return false;

    }
         

    
           public static boolean isNumber(String text) {


    
        if ( Integer.parseInt(text)>0 && Integer.parseInt(text)<100) {

            return true;

        } else {

            return false;

        }

    }

    
}
