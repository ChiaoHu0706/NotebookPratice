package FormPratice1;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;


public class MainController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * Launch the application.
		 */
		
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						Extand_Frame frame = new Extand_Frame();
						Image icon = Toolkit.getDefaultToolkit().getImage(".\\Image\\Note.png");    
						frame.setIconImage(icon);    
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			
		
	}

}
