package basic.interfaceExample;

class Student implements Comparable {

	String name;
	int height;
	int weight;
	int grade;

	public Student(String name, int h, int w, int g) {
	   this.name = name;
	   this.height = h;
	   this.weight = w;
	   this.grade = h;
	}

	public boolean betterThan(Comparable x) {
		Student s = (Student) x;
		int x1 = this.height + this.weight + this.grade;
		int x2 = s.height + s.weight + s.grade;
		if (x1 > x2) {
			return true;
		} else
			return false;
	}

	public String toString() {
		return name;
	}
	
	public static void main(String[] arg) {
		
		Student s1 = new Student("John", 170, 65, 40);
                Student s2 = new Student("Mary", 150, 65, 100);
                Student s3 = new Student("Nick", 170, 75, 90);
                
		Student bestStudent = (Student)GeneralComparator.best(s1, s2, s3);

		System.out.println(bestStudent.toString());
	}
}
