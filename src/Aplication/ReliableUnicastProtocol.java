package Aplication;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;

/**
 *
 * @author Pedro César
 */
public class ReliableUnicastProtocol extends Thread implements Interface.ReliableUnicastServiceInterface {
    
    private String                  fileName = "config.txt";                    // Arquivo config.txt
    
    private ArrayList<Integer>      tableDest_NroID = new ArrayList<>();        // ID       type Integer
    private ArrayList<String>       tableDest_StrIP = new ArrayList<>();        // IP       type String
    private ArrayList<Integer>      tableDest_NroPT = new ArrayList<>();        // Porta    type Integer
    private ArrayList<InetAddress>  tableDest_IAdIP = new ArrayList<>();        // IP       type InetAdress
    
    private boolean                 activeThread    = false;
    private Integer                 activeTableDest = null;

    /**
     * Envia uma mensagem para um destinatário específico, via UDP.
     * 
     * @param destination   Número de ID, conforme está no arquivo config.txt.
     * @param message       Mensagem a ser enviada
     * @return              Verdadeiro, caso a mensagem conseguiu ser enviada
     */    
    @Override
    public boolean RUDataReq(short destination, String message) {
        // Verifica se destination contém um valor válido
        if (FindID(destination) == true){
            try{
                byte[] buf = message.getBytes();
                DatagramSocket datagram = new DatagramSocket();
                DatagramPacket reqPacket = new DatagramPacket(
                        buf,
                        buf.length,
                        tableDest_IAdIP.get(activeTableDest),
                        tableDest_NroPT.get(activeTableDest)
                        );
                // Envia o datagrama
                datagram.send(reqPacket);
                // Fecha o datagrama
                datagram.close();
                return true;
            
            } catch(IOException e){
            System.err.println("Erro: " + e);
        }
        }else{
            System.err.println("Erro: Nro de Destino não encontrado");
        }
        return false;
    }
    /**
     * Lê um arquivo de configuração chamado config.txt e aloca seus dados as
     * variáveis: config_NroID (tipo Integer, com nro do destinatário), config_StrIP
     * (tipo String, com o IP do destinatário), config_PT (tipo Integer, com o
     * nro da porta do destinatário).
     * 
     * @return  true se o arquivo foi lido com sucesso
     * @throws FileNotFoundException 
     */
    
    
    
    public void ListTableDest(){
        
        
        System.out.println("\nTabela de configuração");
        System.out.println("===========================================");
        
        for(int i=0;i<tableDest_NroID.size();i++){
            
            System.out.print("ID: "    + tableDest_NroID.get(i) + "\t");
            System.out.print("IP: "    + tableDest_StrIP.get(i) + "\t");
            if(tableDest_StrIP.get(i).length()<12){System.out.print("\t");}
            System.out.print("Porta: " + tableDest_NroPT.get(i));
            System.out.println("");
        }
        System.out.println("===========================================");
    }
    
    public void LoadConfigFile() throws FileNotFoundException{
         
        try{
            BufferedReader file = new BufferedReader(new FileReader(fileName));
            
            while(file.ready()){
                String[] leu = (file.readLine()).split(" ");
                tableDest_NroID.add(Integer.parseInt(leu[0]));
                tableDest_StrIP.add(leu[1]);
                tableDest_IAdIP.add(StringToInet(leu[1]));
                tableDest_NroPT.add(Integer.parseInt(leu[2]));                
            }    
            file.close();            
        }catch(IOException e){System.out.println("Erro:" + e);}
    }
    
    /**
     * Recebe um endereço IP no formato String e retorma um endereço IP no formato InetAddress
     *
     * @param  inString Endereco no formato String
     * @return outInet  Retorna o endereço no formato InetAdress
     */
    private InetAddress StringToInet(String inString) throws UnknownHostException{
        
        InetAddress outInet = null;
        
        if(inString.equals("localhost")){
            outInet = InetAddress.getByName("localhost");
        }else{
            try{
                    outInet = InetAddress.getByName(inString);
                }
            catch(UnknownHostException uHex){}
        }
        return outInet;
    }
    
    /**
     * Busca na tabela de endereços um ID
     * @param destination
     * @return boolean 
     */
    private boolean FindID(short destination){
        int i;
        for(i=0; i<tableDest_NroID.size(); i++){
            if(tableDest_NroID.get(i) == destination){
                activeTableDest = i;
                return true;
            }
        }
        return false;
    }
}