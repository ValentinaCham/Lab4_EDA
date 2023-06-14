public class Node <E > {
  private E data;
	private Node<E> nextNode;
  private Node<E> previusNode;

  Node () {
        this.data = null ;
        this.nextNode = null ;
        this.previousNode = null ;
    }

    Node ( E data ) {
        this.data = data ;
        this.nextNode = null ;
        this.previousNode = null ;
    }

    Node ( E data , Node <E > nextNode ) {
        this.data = data ;
        this.nextNode = nextNode ;
        this.previousNode = null ;
    }

    Node ( E data , Node <E > nextNode , Node <E > previousNode ) {
        this.data = data ;
        this.nextNode = nextNode ;
        this.previousNode = previousNode ;
    }

    public E getData() {
		  return this.data;
	  }

	  public void setData(E data) {
		  this.data = data;
	  }
	
    public Node<E> getNext() {
		  return this.next;
	  }
	
    public Node<E> getPrev() {
		  return this.previousNode;
	  }
	
    public void setNext(Node<E> next) {
		  this.nextNode = next;
    }

    public void setPrev(Node<E> prev){
      this.previousNode = prev;
    }

	  public String toString() {
		  return this.data.toString();
	  }
    
}
