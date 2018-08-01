package main;

import sistema.Analitzador;
import sistema.Lector;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String api = "RGAPI-9ceca4d0-49f6-4fad-803b-28401ef4f881";
		Lector l = new Lector(api);
		Analitzador an = new Analitzador(api);
		try {
			System.out.println(an.getWinRate("JoniMega"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
