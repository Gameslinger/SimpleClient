/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CLI;

import CLI.commands.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Gabriel.Maxfield
 */
public class CLI {
    public static List<String> list = new ArrayList();
    public static Map<String,ICommand> comMap = new HashMap();
    public static List<ICommand> commands = new ArrayList();
    static String userName = "Root";
    Scanner scanner = new Scanner(System.in);
    
    public static char cmdChar = '!';
    static{
         commands.add(new Echo());
         commands.add(new Reverse());
         commands.add(new Quit());
         commands.add(new Color());
         commands.add(new Help());
         commands.add(new Name());
         commands.add(new Escapes());
         commands.add(new FractionCmd());
         commands.add(new MorseCode());
         commands.add(new BinaryCode());
         commands.add(new ShiftEncrypt());
         commands.add(new XOREncrypt());
         commands.add(new HexCode());
         commands.add(new AntiMorseCode());
         commands.add(new AntiBinaryCode());
         commands.add(new AntiHexCode());
         commands.add(new RandomString());
         commands.add(new AtBash());
         
         for(ICommand com : commands){
             for(int i = 0; i < com.getKeys().length; i++){
                 comMap.put(com.getKeys()[i], com);
             }
         }
         
    }
    public String processString(String line){
        try{
            return scanString2(line);
        }catch(Exception e){
           //e.printStackTrace();
            return("Improper Input");
        }
    }
    public String nextString(){
        System.out.print(userName+">");
        return scanner.nextLine();
    }
    
    
    ICommand cmd;
     String test;
    public String scanString(String str){
        String[] keys;
        if(str.charAt(0)==cmdChar){
            String tokens[] = str.substring(1).split(" ");
            
            test = tokens[0].substring(1).toLowerCase();
                if(comMap.containsKey(test)){
                    String args = "";
                    cmd = comMap.get(test);
                            

                    return scanString2(args+cmd.response(str.split(" ")).replaceAll(" "+cmdChar, "("+cmdChar+")"));
                    
                }
            
//            for(ICommand command : commands){
//                    keys = command.getKeys();
//                    for(int e = 0; e < keys.length; e++){
//                        if(keys[e].equals(tokens[0].toLowerCase())){
//                            return command.response(tokens);
//                        }
//                    }
//                }
            }
        
        return str;
    } 
    public String scanString2(String str){
        boolean skip=false, found = false;
        String tokens[] = str.split(" ");
        for(int i = tokens.length-1; i >= 0; i--){
        if(tokens[i].isEmpty())return str;
            if(tokens[i].charAt(0)==cmdChar){
                if(tokens[i].charAt(1)==cmdChar){
                    skip=true;
                    break;
                }
                found = true;
               test = tokens[i].substring(1).toLowerCase();
                if(comMap.containsKey(test)){
                    String args = "";
                    cmd = comMap.get(test);
                            for(int e = 0; e < i; e++){
                                args+=tokens[e]+" ";
                            }

                    return scanString2(args+cmd.response(Arrays.copyOfRange(tokens, i, tokens.length)).replaceAll(" "+cmdChar, "("+cmdChar+")"));
                    
                }
                
//                for(ICommand cmd : CLI.commands){
//                    for(String key : cmd.getKeys()){
//                        if(key.equals(tokens[i].substring(1).toLowerCase())){
//                            String args = "";
//                            for(int e = 0; e < i; e++){
//                                args+=tokens[e]+" ";
//                            }
//                            
//                            return scanString2(args+cmd.response(Arrays.copyOfRange(tokens, i, tokens.length)).replaceAll(" "+cmdChar, "("+cmdChar+")"));
//                        }
//                    }
//                }
            }
        }
        if(skip){
            return scanString(str).replace(" "+cmdChar+cmdChar, " ");
        }
      
        //Local Message
        if(found)return "Command Not found";
        //Send message:
        return str;
    } 
    
    

    public static void setUserName(String newName) {
        userName = newName;
    }
    
}
