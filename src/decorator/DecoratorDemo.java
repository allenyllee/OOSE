package decorator;

public class DecoratorDemo {

	public static void main(String[] args) {
		Basic b= new Basic();
		
		X1 x1= new X1(b);
		Y1 y1 = new Y1(x1);
		y1.m1();
		
		Y2 y2= new Y2(x1);
		y2.m1();
	}

}

class Component {
	public void m1() {
	}
}

class Decorator extends Component {
	Component c;

	public Decorator(Component c) {
		this.c = c;
	}

	public void m1() {
		c.m1();
	}
}

//X is an aspect should be concerned
class X extends Decorator {
	public X(Component c) {
		super(c);
	}
	public void m1() {
		super.m1();
	}

}

//X1 is an additional function can be added on
class X1 extends X {
	public X1(Component c) {
		super(c);
	}
	public void m1() {
		super.m1();
		System.out.println("X1");
	}	
}

//X2 is an additional function can be added on
class X2 extends X {
	public X2(Component c) {
		super(c);
	}
	public void m1() {
		super.m1();
		System.out.println("X2");
	}
}


class Y extends Decorator {
	public Y(Component c) {
		super(c);
	}
	public void m1() {
		super.m1();
	}

}

class Y1 extends Y {
	public Y1(Component c) {
		super(c);
	}
	public void m1() {
		super.m1();
		System.out.println("Y1");
	}	
}

class Y2 extends Y {
	public Y2(Component c) {
		super(c);
	}
	public void m1() {
		super.m1();
		System.out.println("Y2");
	}
}

class Basic extends Component {
	public void m1() {
		System.out.println("basic");
	}
}