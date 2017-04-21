/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

/**
 * Die Klasse fuer Daten von Pinnwand
 * @author Metaxa
 * 
 */
public class PinnwandDaten {
    
    private String name;
    private String vorname;
    private String eintrag;
    /**
     * Konstruktor fuer PinnwandDaten
     * @param name
     * @param vorname
     * @param eintrag 
     */
    public PinnwandDaten(String name, String vorname, String eintrag){
        this.name=name;
        this.vorname=vorname;
        this.eintrag=eintrag;               
    }

    public String getName() {
        
        return name;
    }

    public String getVorname() {
        return vorname;
    }

    public String getEintrag() {
        return eintrag;
    }

    //+email, damit auf die notwendige Seite verweisen
    
    
    
}
