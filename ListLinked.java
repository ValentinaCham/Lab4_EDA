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
	
	public Node<T> get(int indice) {
	    Node<T> aux=this.head;
	    for(int i=0;i<indice;i++)
		aux=aux.getNext();
	    return aux;
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
	
	public Node<T> remove(int indice) {
	    if(indice<count) {
		if(indice==0)
		    raiz=raiz.getNextNode();
		else {
		    Node<T> anterior=this.get(indice-1);
		    anterior.setNextNode(this.get(indice+1));
		}
		count--;
	    }
	}
	
	public String toString() {
		String str = "";
		for(Node<E> aux = this.head; aux != null; aux = aux.getNext())
			str += aux.toString() + ", ";
		return str;
	}
	
	
}
