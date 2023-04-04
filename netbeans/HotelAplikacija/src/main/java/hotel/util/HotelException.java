/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.util;

/**
 *
 * @author Korisnik
 */
public class HotelException extends Exception{
    
    private String poruka;

    public HotelException(String poruka) {
        super();
        this.poruka = poruka;
    }

    public String getPoruka() {
        return poruka;
    }
    
    
}
