package observer;

import java.util.*;

/*
 * Demo how to use a observer design pattern without using java.util.Observable API
 */
public class ObserverDemo3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out
				.println("Demo how to use a observer design pattern without using java.util.Observable API");
		Stock2 s = new Stock2(100);
		s.increase();

		s.addObserver(new StockBoard2());
		s.increase();

		s.addObserver(new StockPicView2());
		s.increase();
	}

}

/*
 * We implement the Observable in my Subject class
 */
class Stock2 extends Something {
	int price;
	ArrayList<Observer> obs; //the array to save the observer
	boolean changed = false;

	public Stock2(int price) {
		this.price = price;
		obs = new ArrayList<Observer>();
	}

	public void increase() {
		price++;
		setChanged();
		notifyObserver(price);
	}

	private void notifyObserver(int price) {
		for (int i = 0; i < obs.size(); i++) {
			obs.get(i).update(price);
		}
		clearChanged();
	}

	public void addObserver(Observer _obs) {
		this.obs.add(_obs);
	}

	private void setChanged() {
		changed = true;
	}

	private void clearChanged() {
		changed = false;
	}
}

/*
 * We can define our observer freely
 */
interface Observer {
	public void update(int price);
}

class StockBoard2 implements Observer {
	public void update(int value) {
		System.out.println("The value is changed to " + value);
	}
}

class StockPicView2 implements Observer {
	public void update(int value) {
		System.out.println("Hi, I am StrockPicView, the value is changed to "
				+ value);
	}

}
