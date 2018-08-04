package main;

import sistema.Analitzador;

import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingUtilities;

import interficie.GraphPanel;
import sistema.Lector;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String api = System.getenv().get("API_LOL-KEY");
		Lector l = new Lector(api);
		Analitzador an = new Analitzador(api);
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				List<Double> llista = new ArrayList<>();
				GraphPanel.createAndShowGui(llista);
			}
		});
		try {
			System.out.println(an.getWinRate("JoniMega"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
