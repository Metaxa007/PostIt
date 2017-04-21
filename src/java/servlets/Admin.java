/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

/**
 *
 * @author Metaxa
 */
public class Admin {
   
    
    //Nummer vom User in der ArrayListe, dessen Post geloescht wird. Int i-nummer vom Post in der ArrayListe
    public static void postDelete(int numInArr, int postInArr){
              
        UserArrayList.userListe.get(numInArr).eintragListe.remove(postInArr);
        
    }
    
    public static void userBlock(String email){
        
       UserArrayList.userBlock.add(email);
        
    }
    
    
    
    
}
