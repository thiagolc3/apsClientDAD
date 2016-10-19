/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apsdad;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author lsfo
 */
public class ApsClientDAD {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     * @throws java.lang.ClassNotFoundException
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        
        int serverPort = 8000;
        String serverIP = "localhost";
        Socket s = new Socket(serverIP, serverPort);

        ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
        out.writeObject("Requisição de cliente recebida");
        
        DataInputStream in = new DataInputStream(s.getInputStream());
        String data = in.readUTF();
        System.out.println(data);
        
        ObjectInputStream inObj = new ObjectInputStream(s.getInputStream());
        ArrayList lista = (ArrayList)inObj.readObject();
        displayResult(lista);
    }

    private static void displayResult(ArrayList<Mensagens> lista) {
        
        for(int i=0; i<lista.size(); i++){
            
            System.out.println(
                            lista.get(i).getId()+"  "+
                            lista.get(i).getRemetente()+"   "+
                            lista.get(i).getDestinatario()+"    "+
                            lista.get(i).getAssunto()+"     "+
                            lista.get(i).getMensgem());
        }
    }
    
}
