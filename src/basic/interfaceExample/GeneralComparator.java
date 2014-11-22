/**
 * ���󪫫~�u�n�ŦX Comparable ���������O�i�H������C �w�� Comparable �ڭ̳]�p�@�� best(x, y, z)
 * ����k�Ӥ���T�Ӫ��~�A�Ӥ�k�N�^�ǳ̡y�n�z������C
 * 
 * interface Comparable { public boolean betterThan(Comparable x); }
 * 
 * class GeneralComparator { public static Object best(x, y, z) { //�K } }
 * 
 * �p�G�ڷQ������G�A�ڸӦp��ק�H�U�� Fruit ���O�H Hint: �A���n�w�q����O�y�n���G�z class Fruit { String name;
 * int price; int sweetDegree; int waterDegree; }
 * 
 * by nlh, FCU
 */

package basic.interfaceExample;

public class GeneralComparator {
	public static void main(String[] args) {

		Fruit banana = new Fruit("Banana", 12, 34, 110);
		Fruit apple = new Fruit("apple", 12, 20, 150);
		Fruit orange = new Fruit("orange", 12, 30, 140);

		Fruit bestFruit = (Fruit) best(banana, apple, orange);

		System.out.println(bestFruit.toString());
	}

	public static Object best(Comparable x, Comparable y, Comparable z) {
		if (x.betterThan(y)) {
			if (y.betterThan(z)) {
				return x;
			} else if (x.betterThan(z)) {
				return x;
			}
		} else if (y.betterThan(z)) {
			return y;
		}
		return z;
	}
}

interface Comparable {
	public boolean betterThan(Comparable x);
}

class Fruit implements Comparable {
	String name;
	int price;
	int sweetDegree;
	int waterDegree;

	public Fruit(String name, int price, int sd, int wd) {
		this.name = name;
		this.price = price;
		this.sweetDegree = sd;
		this.waterDegree = wd;
	}

	public boolean betterThan(Comparable x) {
		Fruit f = (Fruit) x;
		if (this.sweetDegree > f.sweetDegree) {
			return true;
		} else
			return false;
	}

	public String toString() {
		return name;
	}
}
