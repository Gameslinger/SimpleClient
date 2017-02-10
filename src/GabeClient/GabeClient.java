/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GabeClient;

import CLI.CLI;
import java.util.Scanner;

/**
 *
 * @author Gabriel.Maxfield
 */
public class GabeClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CLI cli = new CLI();
        
        String result;
        while(true){
            
        result = cli.processString(cli.nextString());
        System.out.println(result);
        //Send it:
        if(result.trim().length()!=0)
                ;
        }
    }
    
}
