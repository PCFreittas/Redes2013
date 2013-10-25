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
     * Envia mensagem para um usuário do serviço de transferência confiável
     * 
     * @param entDest  --> Entidade de Destino
     * @param mensagem --> Mensagem
     * @return
     */
    public boolean RUDataReq(Short entDest,String mensagem);
    
}
