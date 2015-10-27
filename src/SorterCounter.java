public class SorterCounter<T extends Comparable<? super T>> {
	//todo geht nicht generisch, warum?
	public ListHead<ElementWrapper<String>> list = new ListHead<ElementWrapper<String>>();
	
	public void SortedAdd(T content)
	{
		list.PosFirst();
		//zu Punkt 4 A2: die zweite Bedingung der while-Schleife kontrolliert die Sortierung der Liste
		//< vs. > unterscheidet zwischen auf und absteigender Sortierung
		//der direkte Vergleich ist nat�rlich nur m�glich, wenn eine entsprechendes compareTo mit dem Inhalt des ElementWrapper machbar ist
		while(list.CurrentNode != null && content.compareTo(list.CurrentNode.Content.word) < 0)
		{
			//vorw�rts bis zum ersten Element, dass gr��eren Inhalt hat
			list.LesenSeq();
		}
		if(list.CurrentNode != null)
		{
			//es gibt kein gr��eres Element -> neues Element am Ende anh�ngen
			//hier erfolgt Punkt 1 aus Aufgabe 2: die while-Schleife bricht sofort ab, da CurrentNode mit null initialisiert ist und 
			//an dieser Stelle erfolgt ein anh�ngen des ersten Satzes (ListHead.Append pr�ft und passt FirstNode/LastNode entsprechend an)
			//auch Punkt 3 aus A2 ist hier abgedeckt: die while-Schleife l�uft bis zum Listenende (CurentNode ist dann null)
			//dann erfolgt ein anh�ngen an letzter Stelle
			list.Append(new ElementWrapper<String>(content));
		}
		else
		{
			if(content.compareTo(list.CurrentNode.Word.word) = 0)
			{
				//das Element steht bereits in der Liste -> hochz�hlen
				list.CurrentNode.Content.counter++;
			}
			else
			{
				//hier erfolgt Punkt 2 aus A2, wenn die Liste nicht leer ist: die while-Schleife bricht wegen der 2. Bedingung sofort ab
				//und steht damit auf dem ersten Element der Liste (ist nicht null)
				//es handelt sich um ein neues Wort also compareTo != 0
				//die AddBeforeCurrent-Methode der Liste hat kein Problem damit, dass CurrentNode.PreviousNode null ist und �bernimmt dies f�r
				//das neue Element
				list.AddBeforeCurrent(new ElementWrapper<String>(content));
			}
		}
	}
}
