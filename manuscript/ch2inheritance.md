
# Java inheritance


## Inheritance
Reference: http://docs.oracle.com/javase/tutorial/java/IandI/subclasses.html


What is inheritance
- classes can be derived from other classes, thereby inheriting fields and methods from those classes.
- Subclass: A class that is derived from another class is called a subclass (also a derived class, extended class, or child class)
- Superclass: The class from which the subclass is derived is called a superclass (also a base class or a parent class).
- A subclass inherits all the members (fields, methods, and nested classes) from its superclass. 
- Constructors are not members, so they are not inherited by subclasses, but the constructor of the superclass can be invoked from the subclass.

All Classes in the Java Platform are Descendants of Object

Code1.1 Inheritance

	public class Bicycle {
	    ...     
	}


MountainBike inherits Bicycle

```MountainBike
	public class MountainBike extends Bicycle {
       
    	// the MountainBike subclass adds one field
	    int seatHeight;
	    // the MountainBike subclass has one constructor
    	public MountainBike(int startHeight, int startCadence,
    	  int startSpeed, int startGear) {
	        super(startCadence, startSpeed, startGear);
    		seatHeight = startHeight;
	    }  
       
    	// the MountainBike subclass adds one method
	    public void setHeight(int newValue) {
    	    seatHeight = newValue;
	    }  
	}
```


What You Can Do in a Subclass
* A subclass inherits all of the public and protected members of its parent, no matter what package the subclass is in.

Fields
- The inherited fields can be used directly, just like any other fields.
- You can declare a field in the subclass with the same name as the one in the superclass, thus hiding it (not recommended).
         * You can add new fields in the subclass

Method
         * The inherited methods can be used directly as they are.
         * You can write a new method in the subclass that has the same signature as the one in the superclass, thus overriding it.
         * You can write a new static method in the subclass that has the same signature as the one in the superclass, thus hiding it.
         * You can declare new methods in the subclass that are not in the superclass.
         * You can write a subclass constructor that invokes the constructor of the superclass, either implicitly or by using the keyword super.
   * A subclass does NOT inherit the private members of its parent class.  
      * However, if the superclass has public or protected methods for accessing its private fields, these can also be used by the subclass.

###Type casting

   * public MountainBike myBike = new MountainBike();
      * myBike is of type MountainBike.
      * MountainBike is descended from Bicycle and Object. ==>
      * MountainBike is a Bicycle and is also an Object ==>
      * it can be used wherever Bicycle or Object objects are called for (代父從軍)

      * The reverse is not necessarily true: 
      * 
         * a Bicycle MAY be a MountainBike, but it isn't necessarily. 
         * Similarly, an Object may be a Bicycle or a MountainBike, but it isn't necessarily.
   * Object obj = new MountainBike(); 
   * 
      * obj is both an Object and a MountainBike (implicit casting)
   * 
      * MountainBike myBike = obj; //==> compiler error
      * MountainBike myBike = (MountainBike)obj; //explicit casting, down-casting
      * If obj is not a MountainBike at runtime, an exception will be thrown.
      * Test before the casting
   * 

      * if (obj instanceof MountainBike) {    MountainBike myBike = (MountainBike)obj; }
   * 
      * Read more casting: http://forum.codecall.net/topic/50451-upcasting-downcasting/#ixzz27xolqHSY



Down-casting:


   * 把一個物件參考（reference）強制轉換（casting）到他子孫類別的形態. 
   * 
      * (Subclass) superReference 


Cat mao = new Cat();
Animal mimi = mao; //upcasting (把一個比較低階的物件給比較高階的類別）
//給 mao 多取一個名字 mimi, 並告訴大家 mimi 是一個動物

Cat jaja = mimi; //==> 錯誤
Cat jaja = (Cat) mimi; //downcasting
//mimi 又多了一個名字 jaja, 並且告訴大家 jaja 是一支貓


Overriding


   * An instance method in a subclass with the same signature (name, plus the number and the type of its parameters) and return type as an instance method in the superclass overrides the superclass's method.
   * @Override
   * 
      * instructs the compiler that you intend to override a method in the superclass. If it can find the method to override, it will warm you.
   * Example
   * 
      * in Code 1.3, the result is "The instance method in Cat", because myAnimal is a type of Cat

Code 1.3 Overriding
public class Animal {
    public void testInstanceMethod() {
        System.out.println("The instance " + " method in Animal.");
    }
}


public class Cat extends Animal {
    public void testInstanceMethod() {
        System.out.println("The instance method" + " in Cat.");
    }


    public static void main(String[] args) {
        Cat myCat = new Cat();
        Animal myAnimal = myCat;
        myAnimal.testInstanceMethod();

    }
}



EnhancedStringTokenizer



## Polymorphism


   * Reference: http://docs.oracle.com/javase/tutorial/java/IandI/polymorphism.html
   * Polymorphism is the ability to associate many meanings to one method name 

   * Important concept
   * 
      * The dictionary definition of polymorphism refers to a principle in biology in which an organism or species can have many different forms or stages

Bicycle example: the method “printDescription” has three different forms. 

public class TestBikes {
  public static void main(String[] args){
    Bicycle bike01, bike02, bike03;


    bike01 = new Bicycle(20, 10, 1);
    bike02 = new MountainBike(20, 10, 5, "Dual");
    bike03 = new RoadBike(40, 20, 8, 23);


    bike01.printDescription();
    bike02.printDescription();
    bike03.printDescription();
  }
}


Sale example 






## Abstract method and abstract class


Reference: http://docs.oracle.com/javase/tutorial/java/IandI/abstract.html
Important concept


   * abstract class ==> cannot be instantiated, but can be subclassed
   * 
      * abstract class Bicycle { … 
   * abstract method ==> declared without an implementation
   * 
      * abstract void moveTo(double deltaX, double deltaY);

GraphicObject example


   * In an object-oriented drawing application, you can draw circles, rectangles, lines, Bezier curves, and many other graphic objects. 
   * These objects all have certain states (for example: position, orientation, line color, fill color) and behaviors (for example: moveTo, rotate, resize, draw) in common. 
   * Some of these states and behaviors are the same for all graphic objects—for example: position, fill color, and moveTo. 
   * Others require different implementations—for example, resize or draw. 
   * 
      * All GraphicObjects must know how to draw or resize themselves; they just differ in how they do it. 
   * This is a perfect situation for an abstract superclass. 



public abstract class GraphicObject {
   // declare fields
   // declare non-abstract methods
   abstract void draw();
}
class Circle extends GraphicObject {
    void draw() {
        ...
    }
    void resize() {
        ...
    }
}
 Abstract class 是一個半成品，等待子類別去完成。

## Abstract class

Note


  1. abstract class may or may not have zero, one or many (0..*) abstract method
  2. abstract class may or may not have zero, one or many (0..*)  concrete method
  3. concrete class can NOT have any abstract method
  4. interface can be seen as a special abstract class
  5. interface can NOT have any concrete method
  6. like abstract class, interface may have zero, one or many (0..*) abstract methods
  7. interface usually define some constant (final static variable)
  8. interface can NOT have any instance variable
  9. abstract class and interface can NOT create (instantiate) objects


## Interface

####Important concept
- Interface can be seen as a special class (or abstract class) which can’t have concrete methods and can’t create objects
- It can serve as a specification, or communication interface.
- other object communicate with an interface, not an object
- It is a type ==> you can declare IntefaceA objectX;
- Multiple interfaces can be implemented by classes anywhere in the class hierarchy


	public interface GroupedInterface extends 
		Interface1, Interface2, Interface3 {
		// constant declarations   
		// base of natural logarithms
		double E = 2.718282;
		// method signatures
		void doSomething (int i, double x);
		int doSomethingElse(String s);
	}


### Comparable 介面
任何物品只要符合 Comparable 的介面都是可以比較的。針對 Comparable 我們設計一個 best(x, y, z) 的方法來比較三個物品，該方法將回傳最『好』的物件。

	interface Comparable {
    	 public boolean betterThan(Comparable x);
	}

	class Lab {
	   public static Object best(x, y, z) {
    	  …
	   }
	}


如果我想比較水果，我該如何修改以下的 Fruit 類別？

Hint: 你先要定義什麼是『好水果』

	class Fruit {
    	 String name;
	     int price;
    	 int sweetDegree;
	     int waterDegree;
	}
	
#### Comparable example

//todo


Reference
- [nlhsueh OOSE code repository:](https://bitbucket.org/nlhsueh/oose/src/8903a93e8a1b/src/edu/fcu/oose/basic/javainheritance)

----
##Lab

###1. Basic lab
1. Write a program to test type casting
2. Write a program to test abstract method
3. Write a program to test interface
Laboratory 4

###2. Comparable
Define a new class People to implement the interface Comparable (has been defined in java.lang). You can compare people by their tall

Show your can sort people by GeneralizedSelectionSort.sort()

###3. Polymorphism
- See and download PolymorhphismDemo.java
- Design another SpecialSale, whose bill() is defined as “price - specialAmount”
- Modify the main() function to compare the price

###4. SuperStringTokenizer

請寫一個 SuperStringTokenizer, 它除了可以解析字元以外,還會把 解析的字元轉成大寫回傳回來。

1. 透過繼承 SuperStringTokenzier 繼承 StringTokenizer來實作。(注意:SuperStringTokenizer 將 override 父類別的 nextToken())
2. 透過委託 SuperStringTokenizer 將”包含” StringTokenizer。你一樣要宣告一個 nextToken() 來傳回每一個大寫字元的 token。

**悄悄話：**透過繼承可以讓你少寫很多程式碼，只要補一點程式碼，就可以創造功能很強的物件。

