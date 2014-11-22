package strategy;


public class StrategyDemo {

	public static void main(String[] args) {
		Basic b = new Basic(new X1(), new Y2());
		b.m1();
	}

}

class Basic {
	X x;
	Y y;
	
	public Basic(X x, Y y) {
		this.x = x;
		this.y = y;
	}
	public void m1() {
		System.out.println("basic");
		x.m1();
		y.m1();
	}
}

//X is an aspect should be concerned
class X {
	public void m1() {}
}

//X1 is a strategy to implement X
class X1 extends X {
	public void m1() {
		System.out.println("X1");
	}	
}

//X2 is a strategy to implement X
class X2 extends X {
	public void m1() {
		System.out.println("X2");
	}
}

class Y {
	public void m1() {}
}

class Y1 extends Y {
	public void m1() {
		System.out.println("Y1");
	}	
}

class Y2 extends Y {
	public void m1() {
		System.out.println("Y2");
	}
}

