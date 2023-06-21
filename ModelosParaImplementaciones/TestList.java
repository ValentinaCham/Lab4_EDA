
public class TestList {

	public static void main(String[] args) {
		TDAList<Integer> l = new ListLinked<Integer>();
		
		System.out.println("50 ? "+ l.search(50));
		l.insertLast(30);
		System.out.println(l);
		l.insertLast(40);
		System.out.println(l);
		l.insertFirst(50);
		System.out.println(l);
		l.insertFirst(16);
		System.out.println(l);
		l.insertLast(38);
		System.out.println(l);
		l.insertFirst(12);
		System.out.println(l);
		
		System.out.println("50 ? "+ l.search(50));
		System.out.println("50 ? "+ l.search(5000));
		
		l.remove(12);
		System.out.println(l);
		l.remove(38);
		System.out.println(l);
		l.remove(50);
		System.out.println(l);
		l.remove(1332);
		System.out.println(l);
		System.out.println("long ? "+ l.lenght());
		
		
		/*
		TDAList<Person> l1 = new ListLinked<Person>();
		
		
		l1.insertFirst(new Person("juan", "j"));
		System.out.println(l1);
		l1.insertLast(new Person("luis", "j"));
		System.out.println(l1);
		l1.insertFirst(new Person("sofia", "j"));
		System.out.println(l1);
		l1.insertFirst(new Person("mari", "j"));
		System.out.println(l1);
		System.out.println("Sofia ? "+ l1.search(new Person("sofia","j")));
*/	}

}
