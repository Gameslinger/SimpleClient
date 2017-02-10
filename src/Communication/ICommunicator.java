/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Communication;

/**
 *
 * @author Gabriel.Maxfield
 */

public interface ICommunicator {
    public void connect();
    public void send(String msg);
    public String recieve();
}
