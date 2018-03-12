/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyzmedical;

import xyzmedical.view.LoginView;

/**
 *
 * @author cjwn
 */
public class XYZMedical {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException {
            
            // This is the entry point for the application.
            LoginView view = new LoginView();
            view.setVisible(true);
    }
}
