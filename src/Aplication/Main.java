package Aplication;

import java.io.FileNotFoundException;

/**
 *
 * @aqwqwquthor Pedro Cesar
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        ReliableUnicastProtocol RUP = new ReliableUnicastProtocol();
        RUP.run();
                        
    }
}