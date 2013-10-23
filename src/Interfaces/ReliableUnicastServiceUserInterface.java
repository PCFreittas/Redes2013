/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

/**
 *
 * @author Pedro Cesar
 */
public interface ReliableUnicastServiceUserInterface {
    
    // Notificação
    public void RUDataInd(String Origem, String Mensagem);
    
    // Confirmação
    public void RUDataInd();
    
}
