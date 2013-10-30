package Aplication;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Pedro Cesar
 */
public class TestAplication implements Interface.ReliableUnicastServiceUserInterface{
    
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
        RUP.LoadConfigFile();

        Scanner scanTerminal = new Scanner(System.in);
        boolean looping = true;
        
        System.out.println("Digite seu comando e tecle [enter].");
        do{
            System.out.print(">> ");
        
            String lerTerminal = scanTerminal.nextLine();
            switch (lerTerminal) {
                case "--help":
                    System.out.println("\nComandos reconhecidos");
                    System.out.println("===========================================");
                    System.out.println("'--help'  Mostra este documento;           ");
                    System.out.println("'config'  Lista destinatários cadastrados; ");
                    System.out.println("'quit'    Encerra este aplicativo.         ");
                    System.out.println("===========================================");
                    System.out.println("");
                    break;
                case "config":
                    RUP.ListTableDest();
                    break;
                case "quit":
                    looping = false;
                    break;
                default:
                    System.out.println("Comando não reconhecido");
                    System.out.println("Digite '--help' se precisar de ajuda.");
            }
        }while(looping);
        System.exit(0);
    }
}