/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lordofhylureclient;

import java.io.*;
import java.net.Socket;

/**
 *
 * @author moritzewert
 */
public class Connector {
    
    private String HOST = "localhost";
    private int PORT = 2691;
    public LordOfHylureClient client;
    private Socket socket;
    public OutputStream out;
    public InputStream in;
    
    public Connector(LordOfHylureClient client) {
        this.client = client;
        try {
            socket = new Socket(HOST, PORT);
            out = socket.getOutputStream();
            out.write("Test".getBytes());
            in = socket.getInputStream();
        } catch(IOException e) {
            e.printStackTrace();
            System.err.println(e);
        }
    }
    
    public boolean getAuthentification(String benutzer, String passwort) {
        String nachricht;
        byte[] buffer = new byte[1024];
        try {
            out.write(("#!auth!#u:"+ benutzer +"#p:"+ passwort).getBytes());
            in.read(buffer);
        } catch(IOException e) {
            e.printStackTrace();
            System.err.println(e);
        }
        nachricht = new String(buffer);
        if(nachricht.equals("starfish")) {
            return true;
        }
        return false;
    }
}
