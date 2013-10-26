/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

/**
 * Faz a comunicação entre as entidades
 * @author Pedro Cesar
 */
public interface ReliableUnicastServiceInterface {
    
    /**
     * Envia uma mensagem para um destinatário específico, via UDP.
     * 
     * @param destination   número de ID, conforme está no arquivo config.txt.
     * @param message       mensagem a ser enviada
     * @return              true caso a mensagem conseguir ser enviada ou false
     * se não conseguir
     */ 
    public boolean RUDataReq(short destination, String message);
    
}
