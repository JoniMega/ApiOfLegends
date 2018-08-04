package interficie;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

	public class Finestra extends JFrame {

		JPanel p= new JPanel();
		Butons taulell []=new Butons[49];
		
		public Finestra(){
			super("ApiOfLegends");
			setSize(400,400);
			setResizable(false);
			setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
	
			addWindowListener(new java.awt.event.WindowAdapter() {
	            public void windowClosing(java.awt.event.WindowEvent evt) {
	            	JOptionPane.showMessageDialog(null, "Fins la propera :P");
		            System.exit(0);
	            }
	        });
			
			
			setVisible(true);
		}
		
		//Clase Butons
		public class Butons extends JButton {
			public Butons(){
				JButton btn = new JButton();
				btn.addActionListener(new Escoltador());
			}
		}
		
		//MAIN
		public static void main(String args[]){
			Finestra senku = new Finestra();
			senku.setVisible(true);
		}
	
	}
	

