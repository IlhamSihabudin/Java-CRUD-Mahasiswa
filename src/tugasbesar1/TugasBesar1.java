/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugasbesar1;

import javax.swing.SwingUtilities;
import viewer.EntryData;

/**
 *
 * @author Ilham Sihabudin
 */
public class TugasBesar1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

	    public void run() {
		new EntryData().setVisible(true);
	    }
	});
    }
    
}
