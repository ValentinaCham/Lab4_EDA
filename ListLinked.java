import myExceptions.ExceptionNoFound;

public class ListLinked<E> implements TDAList<E>{
	private Node<E> head;
	private int count;
	
	public ListLinked() {
		this.head = null;
		this.count = 0;
	}
	
	public boolean isEmpty() {
		return this.head == null;
	}
	
	public int lenght() {
		return this.count;
	}
	
	public void insertFirst(E x) {
		this.head = new Node<E>(x, this.head);
		this.count ++;
	}
	
	public void insertLast(E x) {
		if (isEmpty())
			insertFirst(x);
		else {
			Node<E> aux = this.head;
			while ( aux.getNext() != null)
				aux = aux.getNext();
			aux.setNext(new Node<E>(x));
			this.count ++;
		}
	}
	
	public boolean search(E x) { 
		Node<E> aux = this.head;
		for(; aux != null && !aux.getData().equals(x); aux = aux.getNext());
		return aux != null;
	}
	
	public void remove(E x) {
		if (!isEmpty()) {
			if (this.head.getData().equals(x)) {
				this.head = this.head.getNext();
				this.count --;
			}
			else {
				Node<E> aux = this.head;
				while(aux.getNext() !=  null && !aux.getNext().getData().equals(x))
					aux = aux.getNext();
				if (aux.getNext() != null) {
					aux.setNext(aux.getNext().getNext());
					this.count --;
				}
			}
		}
	}
	
	public String toString() {
		String str = "";
		for(Node<E> aux = this.head; aux != null; aux = aux.getNext())
			str += aux.toString() + ", ";
		return str;
	}
	
	
}
