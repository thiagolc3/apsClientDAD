/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aps;

import java.io.IOException;


/**
 *
 * @author lsfo
 */
public class MainCliente {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     * @throws java.lang.ClassNotFoundException
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        
        String usuario = "thiago@puc-rio.br";
        ListaMsg lista = new ListaMsg();
        lista.exibirLista(usuario);
        
        
        Mensagem msg = new Mensagem();
        msg.setRemetente("teste@test.com");
        msg.setDestinatario("thiago@puc-rio.br");
        msg.setAssunto("assunto qq");
        msg.setMensagem("Blá.");
        
        EnviaMsg envia = new EnviaMsg();
        envia.enviar(msg);
    }
}
