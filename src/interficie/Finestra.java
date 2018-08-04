package interficie;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

	public class Finestra extends JFrame {

		int x,y;
		int ax,by;
		
		public Finestra(){ 
			super("ApiOfLegends");
			setSize(900,700);
			setResizable(false);
			setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
	
			addWindowListener(new java.awt.event.WindowAdapter() {
	            public void windowClosing(java.awt.event.WindowEvent evt) {
	            	//JOptionPane.showMessageDialog(null, "Fins la propera :P");
		            System.exit(0);
	            }
	        });
			
			
			x = 30;
			y = 300;
			
			setVisible(true);
		}
		
		public void paint(Graphics g){
			g.setColor(Color.BLACK);
			g.drawString("Grafica", 700, 400);
			g.drawString("Winrate", 700, 420);
			g.drawLine(30, 30, 30, 600);
			g.drawLine(30,600,600,600);
			if(x>599||y<40){
				//g.drawString((String) cb.getSelectedItem(), 200, 200);
				x=30;
				y=300;
				
			}
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
			Finestra app = new Finestra();
			app.setVisible(true);
		}
	
	}
	

