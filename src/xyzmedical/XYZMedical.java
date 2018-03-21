package xyzmedical;

import xyzmedical.view.LoginView;

import xyzmedical.model.*;
import java.sql.Timestamp;
import java.sql.Date;
import xyzmedical.db.Database;
import xyzmedical.model.Patient;
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
