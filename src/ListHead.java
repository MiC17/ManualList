public class ListHead<T extends Comparable<? super T>> {
	public ListNode<T> FirstNode = null;
	public ListNode<T> LastNode = null;
	public ListNode<T> CurrentNode = null;
	public int CurrentIndex = 0;
	public int NumberOfElements = 0;

	public void PosFirst()
	{
		CurrentNode = FirstNode;
		CurrentIndex = 0;
	}
	
	public void PosLast()
	{
		CurrentNode = LastNode;
		CurrentIndex = NumberOfElements - 1;
	}
	
	public void LesenSeq()
	{
		CurrentNode = CurrentNode.NextNode;
		CurrentIndex++;
	}
	
	public void LesenSeqBack()
	{
		CurrentNode = CurrentNode.PreviousNode;
		CurrentIndex--;
	}
	
	public void Append(T content)
	{
		if(FirstNode == null)
		{
			//Liste ist leer. Übergebenes als erstes und letztes Element übernehmen
			FirstNode = new ListNode<T>(content);
			LastNode = FirstNode;
		}
		else
		{
			//Liste hat Elemente. Übergebenes als neues letztes Element anhängen
			LastNode.NextNode = new ListNode<T>(content, LastNode, null);
			LastNode = LastNode.NextNode;
		}
		NumberOfElements++;
	}
	
	public void AddBeforeCurrent(T content)
	{
		if(CurrentNode != null)
		{
			//das neu hinzugefügte Element wird angehängt an den Vorgänger des momentanen Elements(falls vorhanden)
			//es wird zudem neues vorheriges Element des momentanen Elementes
			ListNode<T> toBeAdded = new ListNode<T>(content, CurrentNode.PreviousNode, CurrentNode);
			if(CurrentNode.PreviousNode == null)
			{
				FirstNode = toBeAdded;
			}
			CurrentNode.PreviousNode.NextNode = toBeAdded;
			CurrentNode.PreviousNode = toBeAdded;
			CurrentNode = toBeAdded;
			NumberOfElements++;
		}
		else
		{
			//momentanes Element ist null (Ende der Liste) -> neues Element am Ende anhängen
			Append(content);
		}
	}	
}	
