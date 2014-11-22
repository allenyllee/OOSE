package adaptor;

public class AdaptorDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Client c = new Client ();
		Target t1 = new Target();
		Target t2 = new Adaptor(new Adaptee());
		c.op(t1);
		c.op(t2);

	}

}

class Client {
	public void op(Target t) {
		t.m1();
	}
}

class Target {
	public void m1() {
		System.out.println("do Target m1");
	}
}

class Adaptee {
	public void m2() {
		System.out.println("do Adaptee m2");
		
	}
}

class Adaptor extends Target {
	Adaptee a;
	
	public  Adaptor(Adaptee ada) {
		a = ada;
	}
	
	public void m1() {
		a.m2();
	}
	
}