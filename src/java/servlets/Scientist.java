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
public class Scientist  {
  
    //Anzahl von gesamten User
    public static int usersAnzahl(){
        
        int anzahl=UserArrayList.userListe.size();
        
        return anzahl;
        
    }
    
    public static int postAnzahl(){
        
        int counter=0;
        
        for(int i=0;i<UserArrayList.userListe.size();i++){
        
            counter=counter+UserArrayList.userListe.get(i).eintragListe.size();
            
        }    
            
        return counter;
        
    }
    
    
    public static double freundeDurchschnitt(){
        
        double counter=0.0;
        
        for(int i=0;i<UserArrayList.userListe.size();i++){
        
            counter=counter+UserArrayList.userListe.get(i).friends.size();
            
        }    
            
        counter = counter/(double)UserArrayList.userListe.size();
        counter=Math.round(100.0*counter)/100.0;
        
        return counter;
        
    }
    
    public static double maxFreunde(){
        double max=0;
        for(int i=0; i<UserArrayList.userListe.size();i++){
            
            if(max<UserArrayList.userListe.get(i).friends.size())
                max=UserArrayList.userListe.get(i).friends.size();           
            
        }
        
        return max;
        
    }
    
    public static double minFreunde(){
        
        double min=UserArrayList.userListe.get(0).friends.size();
        for(int i=1; i<UserArrayList.userListe.size();i++){
            
            if(min>UserArrayList.userListe.get(i).friends.size())
                min=UserArrayList.userListe.get(i).friends.size();           
            
        }
        
        return min;
        
    }
    
    public static double maxPosts(){
        
        double max=0;
        for(int i=0; i<UserArrayList.userListe.size();i++){
            
            if(max<UserArrayList.userListe.get(i).eintragListe.size())
                max=UserArrayList.userListe.get(i).eintragListe.size();           
            
        }
        
        return max;
        
        
        
    }
    
    public static double minPosts(){
        
        double min=UserArrayList.userListe.get(0).eintragListe.size();
        for(int i=0; i<UserArrayList.userListe.size();i++){
            
            if(min>UserArrayList.userListe.get(i).eintragListe.size())
                min=UserArrayList.userListe.get(i).eintragListe.size();           
            
        }
        
        return min;
        
        
    }
    
}
