package Aplication;

import java.io.FileNotFoundException;

/**
 *
 * @author Pedro Cesar
 */
public class TestAplication implements Interfaces.ReliableUnicastServiceUserInterface{

    @Override
    public void RUDataInd(short source, String message) {
        System.out.println( "" + source +
                            "" + message    );
    }

    @Override
    public void RUDataInd() {
        System.out.println( "Mensagem enviada");
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        ReliableUnicastProtocol RUP = new ReliableUnicastProtocol();
        RUP.run();
                        
    }
}