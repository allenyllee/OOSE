package singleton;

public class SingletonDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Radio r = Radio.instance();

		System.out.println(r);

		r = null;

		r = Radio.instance();
		System.out.println(r);

	}

}

class Radio {
	private static Radio uniqueInstance;

	String station;

	public static Radio instance() {
		if (uniqueInstance == null) {
			uniqueInstance = new Radio();
		}
		return uniqueInstance;
	}

	private Radio() {
		station = "default station";
	}

}
