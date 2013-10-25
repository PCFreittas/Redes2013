package Aplication;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;


/**
 *
 * @author Pedro César
 */
public class ReliableUnicastProtocol implements Interfaces.ReliableUnicastServiceInterface {
    private boolean             activeThread;
    private String              fileName = "config.txt";
    private ArrayList<Integer>  config_ID = new ArrayList<>();
    private ArrayList<String>   config_IP = new ArrayList<>();
    private ArrayList<Integer>  config_PT = new ArrayList<>();
    
    public void run(){
        activeThread = true;
        while(activeThread){

        }   
    }
    
    @Override
    public boolean RUDataReq(Short entDest, String mensagem) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
 
    public boolean LoadConfigFile() throws FileNotFoundException{
        //

        // 
        try{
            BufferedReader file = new BufferedReader(new FileReader(fileName));
            
            while(file.ready()){
                String[] leu = (file.readLine()).split(" ");
                config_ID.add(Integer.parseInt(leu[0]));
                config_IP.add(leu[1]);
                config_PT.add(Integer.parseInt(leu[2]));                
            }
            
            file.close();
            
            for(int i=0; i<config_ID.size(); i++){
                System.out.println(config_ID.get(i) + " " + config_IP.get(i) + " " + config_PT.get(i));
            }
            
            return true;
        }catch(IOException e){System.out.println("Erro ao ler o arquivo: config.txt");}
        
        return false;
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
}