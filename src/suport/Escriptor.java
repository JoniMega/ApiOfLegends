package suport;

import java.io.*;


public class Escriptor {
	private String fitxer;
	private boolean nou;
	
	public Escriptor(String fitxer, boolean nou){
		this.fitxer=fitxer;
		this.nou=nou;
	}
	
	public Escriptor(String fitxer){
		this.fitxer=fitxer;
		this.nou=true;
	}
	
	public void write(String text) throws Exception{
		FileWriter fw = new FileWriter(fitxer+".txt", true);
	    BufferedWriter bw = new BufferedWriter(fw);
	    PrintWriter writer = new PrintWriter(bw);
		writer.println(text);
		writer.close();
	}
	
	
	
}
