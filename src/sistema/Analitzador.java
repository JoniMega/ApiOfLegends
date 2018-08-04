package sistema;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

import org.json.JSONArray;
import org.json.JSONObject;

import interficie.GraphPanel;
import suport.Escriptor;

public class Analitzador {
	private String api;
	private Lector in;

	public Analitzador(String api) {
		this.api = api;
		this.in = new Lector(api);
	}

	public boolean getVictoria(String Nom, String idPartida) throws Exception {
		String info = this.in.llegirPartida(idPartida);
		JSONObject obj = new JSONObject(info);
		boolean blauVictoria;
		if (((JSONObject) obj.getJSONArray("teams").get(0)).getString("win").equals("Win")) {
			blauVictoria = true;
		} else if (((JSONObject) obj.getJSONArray("teams").get(1)).getString("win").equals("Win")) {
			blauVictoria = false;
		} else {
			throw new Exception("Cap dels equips ha guanyat");
		}
		JSONObject jugador;
		for (int i = 0; i < obj.getJSONArray("participantIdentities").length(); i++) {
			jugador = (JSONObject) obj.getJSONArray("participantIdentities").get(i);
			if (jugador.getJSONObject("player").getString("summonerName").equals(Nom.replace(" ", "%20"))) {
				if (i < 5) {
					return blauVictoria;
				} else {
					return !blauVictoria;
				}
			}
		}
		return false;
	}

	public Vector<String> getPartides(String Nom) throws Exception {
		Vector<String> Partides = new Vector<String>();
		String info = this.in.llegirPartides(getIdJugador(Nom));
		JSONArray partides = new JSONObject(info).getJSONArray("matches");
		for (int i = 0; i < partides.length(); i++) {
			Partides.addElement("" + ((JSONObject) partides.get(i)).getLong("gameId"));
		}
		return Partides;
	}

	public String getIdJugador(String Nom) throws Exception {
		String info = this.in.llegirUsuari(Nom);
		JSONObject jugador = new JSONObject(info);
		return "" + jugador.getLong("accountId");
	}

	public double getWinRate(String Nom) throws Exception {
		Vector<String> Partides = getPartides(Nom);
		Escriptor escr = new Escriptor("dades");
		Escriptor escr2 = new Escriptor("temps");
		List<Double> llista = new ArrayList<>();
		int guanyades = 0, jugades = 0;
		double aux1, aux2, aux3;
		long inici = System.nanoTime(), fi = 0;
		boolean trobat = false;

		for (String i : Partides) {
			TimeUnit.SECONDS.sleep(1);
			// System.out.println(toDate(getDate(i)));
			System.out.println((jugades + 1) + "/" + Partides.size());
			trobat = false;
			while (!trobat) {
				try {
					if (getVictoria(Nom, i)) {
						guanyades++;
					}
					trobat=true;
				} catch (Exception e) {
					TimeUnit.SECONDS.sleep(1);
				}
			}
			
			jugades++;

			aux1 = guanyades;
			aux2 = jugades;
			aux3 = aux1 / aux2;
			// escr.write(""+String.format("%.4f", aux3));
			// escr2.write(""+getDate(i));
			fi = System.nanoTime();
			llista.add(aux3*100);
			GraphPanel.updateGui(llista);
			System.out.print((((fi - inici) * Partides.size() / jugades) - (fi - inici)) / 1000000000);
			System.out.println(" segons restants");
		}

		aux1 = guanyades;
		aux2 = jugades;
		System.out.print("Temps total: ");
		System.out.println((fi - inici)/ 1000000000);
		System.out.println(guanyades + " " + jugades);
		return aux1 / aux2;
	}

	public long getDate(String idPartida) throws Exception {
		String info = this.in.llegirPartida(idPartida);
		JSONObject obj = new JSONObject(info);

		return obj.getLong("gameCreation");
	}

	private String toDate(long date) {
		Calendar mydate = Calendar.getInstance();
		mydate.setTimeInMillis(date);
		// System.out.print(mydate.get(Calendar.DAY_OF_MONTH)+"/"+mydate.get(Calendar.MONTH)+"/"+mydate.get(Calendar.YEAR)+"
		// - ");

		return mydate.get(Calendar.DAY_OF_MONTH) + "/" + (mydate.get(Calendar.MONTH) + 1) + "/"
				+ mydate.get(Calendar.YEAR) + " - ";
	}

}
