public class ListNode<T extends Comparable<? super T>> {
	
	public T Content;
	public ListNode<T> NextNode = null;
	public ListNode<T> PreviousNode = null;
	
	public ListNode(T content)
	{
		Content = content;
	}
	
	public ListNode(T content, ListNode<T> previousNode, ListNode<T> nextNode)
	{
		Content = content;
		previousNode = PreviousNode;
		nextNode = NextNode;
	}
}