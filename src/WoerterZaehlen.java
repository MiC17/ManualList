// Hinweis: Ich hatte einige Probleme mit den Unterschieden zwischen dem JRE 1.5(Schule) und 1.8 (zu Hause)
//Entsprechend ist der vorliegende Code nicht getestet
//Antworten zu den Fragen aus 2. finden sich im SorterCounter

import java.io.BufferedReader;
import java.io.FileReader;


public class WoerterZaehlen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WoerterZaehlen app = new WoerterZaehlen();
		app.readFromFile("WikiDeutschland.txt");

	}
	
	public void run(String[] args ){
		if(args.length == 1){
			readFromFile(args[0]);
		}
		else{
			System.out.println("WoerterZaehlen <dateiname>");
			System.out.println("\tZaehlt die Woerter in einem Text, der als Datei uebergeben werden muss.");
			System.out.println("\tLiefert eine Liste von Woertern mit ihren haeufigkeiten im Text.");
		}
	}
	
	public void readFromFile(String fname ){
		SorterCounter<String> sortCount = new SorterCounter<String>();
		try{
			BufferedReader bfr = new BufferedReader(new FileReader(fname));
			String line;
			line = bfr.readLine();
			while( line != null ){
				String fld[] = line.split("[,; .!?1234567890+	()-/]");
				
				for(String w : fld){
					if(w.length() > 1){
						sortCount.SortedAdd(w);
						//System.out.println("Wort gefunden: " + w);
					}
				}
				
				line = bfr.readLine();
			}
			bfr.close();
			
			System.out.println("w1");
			
			liste.PosFirst();
			int z = 0;
			while(liste.CurrentNode.NextNode != null)
			{
				System.out.println("Wort " + z + " " + liste.CurrentNode.Content.toString() + " Treffer: ");
				liste.LesenSeq();
				z++;
			}
		}
		catch( Exception e ){
			System.err.println((e.getMessage()));
		}
	}

}
