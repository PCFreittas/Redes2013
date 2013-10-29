package Interfaces;

/**
 *
 * @author Pedro Cesar
 */
public interface ReliableUnicastServiceUserInterface {
    
    // Notificação
    /**
     *
     * @param source   Entidade de Origem
     * @param message  Mensagem
     */
    public void RUDataInd(short source, String message);
    
    // Confirmação
    public void RUDataInd();
}