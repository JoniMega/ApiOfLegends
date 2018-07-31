package main;

import sistema.Analitzador;
import sistema.Lector;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String api = "RGAPI-11e6e7a1-81b8-41e6-a1ec-35f50acf4c75";
		Lector l = new Lector(api);
		Analitzador an = new Analitzador(api);
		try {
			System.out.println(an.getWinRate("Doctor%20Oswald"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
