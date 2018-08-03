package sistema;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.*;

public class Lector {
	private String api;

	public Lector(String api) {
		this.api = api;
	}

	public String llegirPartida(String idPartida) throws Exception {
		String aux = "https://euw1.api.riotgames.com/lol/match/v3/matches/" + idPartida + "?api_key=" + this.api;
		String str = null;
		try {
			URL url = new URL(aux);
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
			str = in.readLine();
			in.close();
		} catch (MalformedURLException e) {
			throw e;
		} catch (IOException e) {
			throw e;
		}
		if (str == null) {
			throw new IllegalArgumentException("Lectura Nul·la");
		}
		return str;
	}
	public String llegirPartides(String nom) throws Exception {
		String aux = "https://euw1.api.riotgames.com/lol/match/v3/matchlists/by-account/" + nom + "?api_key=" + this.api;
		String str = null;
		try {
			URL url = new URL(aux);
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
			str = in.readLine();
			in.close();
		} catch (MalformedURLException e) {
			throw e;
		} catch (IOException e) {
			throw e;
		}
		if (str == null) {
			throw new IllegalArgumentException("Lectura Nul·la");
		}
		return str;
	}
	public String llegirUsuari(String nom) throws Exception {
		String aux = "https://euw1.api.riotgames.com//lol/summoner/v3/summoners/by-name/" + nom + "?api_key=" + this.api;
		String str = null;
		try {
			URL url = new URL(aux);
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
			str = in.readLine();
			in.close();
		} catch (MalformedURLException e) {
			throw e;
		} catch (IOException e) {
			throw e;
		}
		if (str == null) {
			throw new IllegalArgumentException("Lectura Nul·la");
		}
		return str;
	}
}
