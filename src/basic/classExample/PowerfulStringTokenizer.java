/**
 Please design a PowerfulStringTokenizer, which extends StringTokenizer with the
 following function or constraints
    - nextToken() will return the tokens which are not duplicated
    - getReverse() will return the reverse string, where duplicated tokens are removed

 For example, "apple Wang eats an apple yesterday"
	- nextToken() �N�|�̧ǶǦ^ apple, Wang, eats, an yesterday. �`�N�ĤG�� apple ���|�Q�Ǧ^
	- getReverse() will return "yesterday an eats Wang apple"
	
 by nlh, FCU
 */

package basic.classExample;

import java.util.StringTokenizer;

public class PowerfulStringTokenizer extends StringTokenizer {
	private String[] a;
	private int count;

	public PowerfulStringTokenizer(String s) {
		super(s);
		a = new String[countTokens()];
		count = 0;
	}

	public String nextToken() {
		String token = super.nextToken();

		boolean duplicate = false;

		for (int i = 0; i < count; i++) {
			if (a[i].equals(token)) {
				duplicate = true;
			}
		}
		if (!duplicate) {
			a[count] = token;
			count++;
			duplicate = false;
			return token;
		} else if (hasMoreElements())
			return nextToken();
		else
			return null;

	}

	public String getReverse() {
		String s = "";
		for (int i = count - 1; i >= 0; i--) {
			s += a[i];
		}
		return s;
	}

	public static void main(String[] s) {

		PowerfulStringTokenizer pst = new PowerfulStringTokenizer("a a b");
		while (pst.hasMoreElements()) {
			pst.nextToken();
		}		

		System.out.println(pst.getReverse());
		System.out.println(pst.getReverse());
	}

}
