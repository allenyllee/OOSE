package singleton;

/**
 Demo Singleton with subclassing
*/

public class SingletonDemo2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Radio r = AppleRadio.instance();

		System.out.println(r);

		r = null;

		r = Radio.instance();
		System.out.println(r);
	}

}

class Radio {
	protected static Radio uniqueInstance;

	private Radio() {
		station = "default station";
	}
}

class SonyRadio extends Radio {
	public static SonyRadio instance() {
		if (uniqueInstance == null) {
			uniqueInstance = new SonyRadio();
		}
		return uniqueInstance;
	}
}

class AppleRadio extends Radio {
	public static AppleRadio instance() {
		if (uniqueInstance == null) {
			uniqueInstance = new AppleRadio();
		}
		return uniqueInstance;
	}
}
