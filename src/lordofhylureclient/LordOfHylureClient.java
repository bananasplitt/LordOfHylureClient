/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lordofhylureclient;

/**
 *
 * @author moritzewert
 */
public class LordOfHylureClient {
    
    static Connector connector;
    static GUI gui;
    
    public LordOfHylureClient() {
        connector = new Connector(this);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        gui = new GUI(connector);
        Login login = new Login(gui, true, connector);
        login.setVisible(true);
    }
}
