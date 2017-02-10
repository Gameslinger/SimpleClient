/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CLI.commands;

import CLI.CLI;

/**
 *
 * @author Gabriel.Maxfield
 */
public class Help implements ICommand {

    @Override
    public String getName() {
        return "Help";
    }

    @Override
    public String response(String[] args) {
        String result="";
        for(ICommand command : CLI.commands){
            String keys="";
            for(int i = 0; i < command.getKeys().length; i++){
                keys+=command.getKeys()[i]+", ";
            }
            result += ("Name: "+command.getName()+", Keys: "+keys+"\n");
        }
        return result;
    }

    @Override
    public String[] getKeys() {
        return new String[] {"h","help"};
    }
    
}
