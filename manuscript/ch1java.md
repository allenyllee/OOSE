# Java Class

本文介紹 java 的在類別設計的基本概念。

## I. 類別 Classes

### 觀念 Concept

> 物件導向程式設計的主體是物件，他們合作完成一個系統的運作。

就像人類世界的主體是人，他們合作以完成一件工作。所以在設計物件導向程式時，你可以有點擬人化的思考，這樣有幫助你思考整個程式的架構。

以物件為抽象的中心，而非動作。例如在一個象棋系統中，以物件的角度你會先想到 Chess, ChessBoard, ChessGame 等物件，棋子的移動是附屬在 Chess 中。

	chess.move(12)
	
如果你是用功能導向，一開始想到的是 move

	move(chess, 12)

又例如傳統的行動電話設計，``撥電話``和``傳簡訊``是功能，被分別設計在手機重要選單上。後來新的手機都有``聯絡人``，把這兩個功能放到聯絡人裡面，可以說是一種物件設計的思維。

> 類別 vs. 物件 => 設計 vs. 實體

類別是抽象的、被設計出來的，物件則是具體被生成出來的，它在執行時具體的佔據了記憶體，可以執行程式。類別則不能執行，它是你設計出來一字字的程式碼。

這就像是『``人``是抽象的，``張三李四``才是具體的人』。人是類別，張三李四則是物件。人不會跑、張三李四會跑。但上帝（？）設計人的時候，讓他具備了眼睛、嘴巴等特性，具備了走路跑步等動作，張三李四就依造『人』這樣的形被創造出來了。

	// 透過 new 生成物件
	Person john = new Person("John Smith", 24);

> 一個類別可以有很多的屬性 (attribute)，和方法 (method)

例如一個車子類別，他可以有顏色、汽缸大小等屬性; 也可以有移動、停止、左轉、右轉等方法。

一個類別所產生的物件，都具有相同的特性，包含屬性與方法。注意是相同屬性不是相同屬性內容。也就是人都該有眼睛嘴巴，但大小形狀可能不同。

物件雖然有相同的方法（或演算法），但表現出來的行為不一定會一樣，因為它在執行的過程中會參考到物件本身的資料（狀態），所以表現出來的行為還是不同的。

> 類別通常代表一個真實事件的物體、概念、事務，通常是一個名詞。

例如車子、房子等物體; 老師、學生等概念。它通常是一個名詞，有一些特性，有一些能力或功能。 許多寫傳統 C 習慣的人換到 OOP 常會把一個方法當成一個類別，可以先用詞態來檢驗：類別通常是名詞。

> 類別也是型態  (type)

我想各位應該都知道 int 是一個型態，當我們宣告一個 age 是int 的形態，就表示他有 4 type 來儲存這個變數的值。class 也是型態喔，所以你也可以宣告一個 age 是一個 Age 的類別型態（前提是你要先設計、宣告一個 Age 類別)

相對於類別型態, int, double, long 等就稱為基本型態 (primitive type)。

```
   public class Bicycle {
    	// Bicycle 有三個 **屬性**
	    int cadence;
    	int gear;
	    int speed;
    	// Bicycle 有四個 **方法**
	    public void setCadence(int newValue) {
    	    cadence = newValue;
	    }
    	public void setGear(int newValue) {
        	gear = newValue;
	    }
    	public void applyBrake(int decrement) {
	        speed -= decrement;
    	}
	    public void speedUp(int increment) {
    	    speed += increment;
	    }
 	}
```

Code: 一個類別可以有很多的屬性與方法


``` java
    public class MountainBike extends Bicycle {
	    // 繼承以後又多了一些屬性
    	public int seatHeight;
	    // 繼承以後又多了一些方法
    	public void setHeight(int newValue) {
        	seatHeight = newValue;
	    }  
	 }
```
Code: 繼承後也可以新增屬性與方法


### 類別命名 Class naming

> 全名比較好

全名比較清楚，例如學生就取為 Student, 不要叫 STD。不清楚的名字在以後很難維護，別人看不懂，你自己也看不懂。

> 第一個字母大寫

Student,  不要 student。

ChessBoard, 不要 chessboard, 不要 Chessboard, Chess_Board...


思考一下
- 定義一個 **Chess** 類別。他該具備什麼屬性與方法？
- 同上，定義一個 **Teacher** 類別 
- 一個**棋局遊戲**中，可能會有哪些類別？每一個類別分別做什麼事？


修正程式

```java
// Filename: Temperature.java 

PUBLIC CLASS temperature {   PUBLIC void main(string args) {      double fahrenheit = 62.5;      */ Convert /*      double celsius = f2c(fahrenheit);
      System.out.println(fahrenheit + 'F' + 
      " = " + Celsius + 'C');	}	double f2c(float fahr) { 
		RETURN (fahr - 32) * 5 / 9;
	}   } 
}
```

## II. 成員變數 Members variables

> 成員變數就是剛剛說的屬性

有很多其他的名字：實體變數 instance variables、 欄位 fields、或是特性 properties。

> 成員變數表達一個類別特殊的屬性或特質。

程式設計師和藝術家都是人，但前者有一個屬性``會的語言``，後這沒有，這就是前者的特性、屬性。

又例如你要設計一個武俠遊戲，每一個人物可能都會有一個數性``武功``來儲存它會的武功; ``生命值``來表達它目前的生命力等。

> 成員變數的值表達``狀態``。

例如 棋局 class 有一個成員變數 gameStatus, 它的值可以是
* *gameOver*: 表達遊戲結束
* *start*：表達遊戲開始
* *black*：表達目前由黑方下
* *red*：表達目前有白方下

每一個值表達不同的狀態。

🔔 保護屬性的值，盡可能讓它維持私有。

不要讓人家**侵門踏戶**的修改你的值，這樣這個物件的行為全亂啦。

```java
	class Bicycle {
		// 把 speed 宣告為私有（private）
		private int speed;
	}	
```

車子的速度應該由車子自己來控制，如果其他的物件隨便來亂改的話，系統很容易出錯。

🐸🐸 想想看：宣告為私有後誰可以修改？外面的類別如果真的需要改的時候怎麼辦？例如人要控制車速，人要怎麼修改 speed?

---

除了成員變數，還有其他的變數。
* 區域變數 local variable (或 method variable)。在方法內的變數。
* 參數（parameter）：Variables in method declarations—these are called **parameters**.

注意！Java 中沒有 global variable!

```
class A {
   int name; //name 是成員變數
   // y 是 參數
   public void m1(int y) {
      int x; // x 是區域變數
   }
}     
```

### 存取修飾 Access modifier

除了私有 private 以外，還有其他的存取修飾（存取權）：

* public: 所有的類別都可以存取。
* private: 只有該類別可以存取。
* package: 同一個 package 內的類別可以存取。當我們沒有寫任何 access modifier 時就是 package。
* protected: 子類別可以存取。


|modifier | class | package | subclass | world 
|---------| ----| ---- | ---- | ----|
|public   | Y | Y | Y | Y |
|protected| Y | Y | Y | **N** |
|package  |Y  | Y | **N** | **N** |
|private  | Y | **N** | N | N |



### Getter, Setter

*getter* 一種特別的方法，專門讓其他類別來取得該屬性的值。例如

	class Person {
		private int age;
		getAge() { //getAge 是一種 getter
			return age;
		}
	}


*setter*也是一種特別的方法，專門讓其他類別來設定該屬性。例如

		//可以在 setter 裡面先做一些檢查
		setAge(int _age) { //setAge 是一種 setter
			this.age = _age;
		}
		
🐸🐸 想想看：有 getter, setter, 為什麼不直接宣告為 public 就好了？

### 成員變數命名 Variable naming

全名、第一個字小寫，例如：

- 好的寫法: name, speed, numberOfCar
- 不好的寫法: Name, _name, NumberOfCar, number_of_car


### 靜態變數 Static variable (class variable)

又稱為**類別變數**，表示是所有的物件**共用**的。我們如果沒有特別註明它是靜態變數，它就是非靜態變數 -- 每個物件會有自己的一個空間來存變數的值。

例如 Bicycle 有一個變數 size (輪圈)是一個非靜態變數，當我們產生 b1, b2, b3 等腳踏車時

	Class Bicycle {
	   private int size;
	   ...
	}

	Bicycle b1=new Bicycle(), b2=new Bicycle(), b3=new Bicycle();

b1, b2, b3 都有各自的的空間來存 size 喔。反之，若是宣告為 static, 則大家共用一份。

	Class Bicycle {
	   private static int count=0;
	   ...
	   
	   Bicycle () {
	   	count++;
	   }
	}

上述的程式，每當我們生成一個bicycle, count 就會加一，所以 count 可以用來計算物件的數量。

🏊🏊 動手做一下：證明它們是共用的。

比較極端的一個例子是**常數**

	class Math {
	  static final double PI = 3.141592653589793;
	}  

不僅共用，也**不能修改**。

Math.PI 就可以取到這個值了。（**不需要生成物件**）

> 定義常數，也是一種物件封裝的風格

不需要去記pi 的值為多少，你會想到 Math 裡去找他，這就是好封裝的效果。

📝📝 寫寫看


```
* 一個 Chess 類別，裡面可能定義什麼常數？




* 一個 Date 的類別，裡面可能有什麼屬性？




```





## III. 方法 Methods

Reference: http://docs.oracle.com/javase/tutorial/java/javaOO/methods.html

### 觀念 concept

方法表示一個物件的能力(capability)或責任(responsibility)。

> **能力**和**責任**是一體兩面。在現實生活好像也是吧！是先有能力還是先有責任呢？

當我們在設計一個系統，我們定義出一些類別，指定這些類別應該具備的功能或能力。沙盤推演一下，這樣功能是否能夠滿足全部的需求？如果可以，分配下去。A 類別就必須完成這樣的功能，對它來說，是它應該具備的責任。

在程式的世界中，怎麼把這**能力**實作出來靠的我們所設計的演算法，也就是執行它的**方法**。但擬人化的說法是：能力與責任。

> 物件透過送訊息（message）來呼叫方法

```java
//ChessBoard 送了一個訊息 move 給 chess1
class ChessBoard
	play() {
		chess1.move(2,3);
	}	
```	

送訊息也是一種擬人化的說法，其實就是呼叫物件 chess1去執行 move 的方法。

> **方法**是一個外部物件 B 可以和我物件 A 溝通的**介面**

這裡的介面是一般名詞，不是 java 中的 interface。物件 A 雖然有很多能力和方法，但未必全都會開放給外部的物件呼叫使用。A 提供了一些可呼叫的方法，其實也就是開放了一些介面，讓他物件可以存取我、可以使喚我的介面。

想像一個物件全部的方法都是 private 的（沒有溝通介面），別人都不能呼叫，這樣的物件就沒什麼用了。就像人不能孤獨的過生活不和人溝通交流吧！

> **方法**可能改變物件狀態。

假設一個 Date 類別，裡面有 month, date, year 三個屬性，提供 *setMonth(int)* 的介面修改月份。一旦修改 Date 的值就改變了，也就是狀態改變了。

為什麼說改變狀態(state)，而不說改變物件的屬性值？**這是因為狀態是程式設計重要的觀念**。物件的行為是倚賴於狀態的，假設我們的程式邏輯是依據春夏秋冬的狀態來做事，那們 Date 的狀態就是春、夏、秋、東：

	if 春
		耕作;
	else if 夏
		耘
	else if 秋
		收
	else if 冬
		藏

對農作的系統來說，從 1/1 變成 1/2 並不具意義，重點是春夏秋冬的變化。對於另一個應用程式，例如星座相關的系統，則狀態又變成 12 個星座了。所以我們在談論系統設計時，多半談**狀態**。
		
方法，提供了一個介面讓其他的物件來改變本身的值，也就有可能改變狀態，就會改變系統可能的反應了，不得不注意。


🐸🐸 想想看：
* [  ]一個沒有屬性的類別所產生的物件是無狀態物件。
* [  ] 一個全都是 static variable 的類別所產生的物件是無狀態物件。

📝 寫寫看
* 默寫存取表（access level）
* 一個棋局可能有那些狀態？它會和哪些棋局的屬性相關？
* Student 可能有哪些狀態？
* 一個手錶，可能有哪些狀態？



### 結構 Structure

一個 method 可以由以下六個元素組成
* modifier: public, protected, private 等
* return type
* method name
* parameter list
* exception list: 這個方法執行時可能拋出的例外
* method body

🔥🔥 **考一下**：exception 有一個 catch or declare rule (CDR)  是什麼意思？

🏊🏊 動動手：設計一個方法 div(x, y), 傳回 x/y 的值，注意要考慮例外的處理。

### Formal/actual 參數
- Formal parameter: 被呼叫端，如 public double myMethod(int p1, int p2, double p3)。律定了對呼叫端的要求。
- Actual parameter (also called argument): 呼叫端，例如 ``myMethod(12, 20, 23.0)``。

Type cast

當 parameter 的形態與 argument 的形態不何時，會進行 type casting（型態轉換）, 如下：左邊的可轉換成右邊的，但右邊的不能轉成左邊的。

	byte, short, int, long, float, double, char
  
🏊 動手寫寫看，型態轉換會不會成功。


### Accessor 和 Mutator
Accessor 和 mutator 是兩種比較特殊的方法，Accessor是獲取物件屬性值的方法，例如
getAge(), getHeight()等。Mutator是修改物件屬性的方法，例如setHeight(int), setAddress(String)等。mutator 會把物件內部的屬性的值設為所傳進來的參數，但通常會做一些檢查，以控制修改是否合適，例如 setHeight 若帶進來的參數值大於 250 公分顯然不太合理，就可以拋出例外、回傳 false 或終止程式的執行。

🔔 Mutator 方法也可以回傳 boolean

$$
## 前置條件、後置條件
方法模組設計以前，先好好的想一想：這個方法的前置條件是什麼？後置條件是什麼

* 前置條件 (precondition): 功能能正常運作的條件。例如一個除法 div(x/y), 前置條件是 y<>0。
* 後置條件 (postcondition): 功能完成後必須滿足的條件。例如遞增排序後， 必定會滿足 a[0] <= a[1] 的條件。

後置條件和 invariant (不變的規則)還是有一點不同。Invariant 是指在此應用領域中不會改變的規則，當他被違反了，有可能就是程式出錯了。例如計算年齡的程式, age >0 , age < 200 是一個不變的規則，我們可以在程式進行過程中不斷的檢驗這樣的規則，以降低程式出錯的機率日後除錯的 effort。

	assert age>0 && age <200 
	
🐸🐸 想想看：直接把屬性設為公開，和透過 accessor, modifier 來公開有什麼不同？

有了前置後置條件的觀念後，上面的問題就迎刃而解了。我們可以在 modifier 中加入前置與後置條件的檢查，這是直接修改公開屬性無法做的功能。

	boolean setHeight(int h) {
		if (h>250)
			return false;
		else {
			this.height = h;
			return true;
		}
	}		

-----

### 靜態方法 static method

又稱為類別方法（非靜態方法又稱為物件方法 instance method）。靜態方法不會存取到物件的狀態（物件的屬性值），也就是說，它的運作和物件的非靜態屬性完全沒有關係

假設一個 Person class, 內部有一個 birthday 的屬性，及一個 getAge() 的方法：

	int getAge() {
		return (now - birthday);
	}
	
因為這個方法會使用到物件的屬性（非靜態屬性），所以它是 instance method。反之，假設 getAge() 是這樣設計的：

	static int getAge(Date birth) {
		return (now - birth);
	}
	
可以看得到它完全不會用到物件的屬性，所以可以宣告為 static method。它的呼叫方法：

	Person.getAge(new Date(12,1,1990));
	
注意到他並不需要產生一個物件才去呼叫，直接用類別就可以呼叫。（為什麼？）	

以下幾點注意：
- 靜態方法不可存取物件變數 (instance variable)
- 靜態方法不可呼叫物件方法 (instance method)
- 靜態方法可以呼叫靜態方法 

很多有用的公用程式（utility function）都被設計成靜態方法，因為它主要的功能是提供一些便捷的運算：input -> compute -> output。例如 Math 這個類別裡面提供了大量的數學運算的方法，都是靜態的：sin(), cos()等。記得他們都是有帶參數的。

🏊🏊 找找看，Java API 中還有哪些  utility function? Integer這個 class, 裡面有哪些靜態方法？

### 包裝類別 Wrapper class

把每一種基本型態包裝成一個類別型態，例如 int => Integer, double => Double 等。

	Integer i = new Integer(20);
	//透過 intValue 來做開箱(unboxing)
	int j = i.intValue(); 
	Integer s = 30; //自動包裝
	int k = i; //自動開箱
	
包裝類別內有很多的常數：例如 Integer.MAX_VALUE, Integer.MIN_VALUE, Double.MAX_VALUE, Double.MIN_VALUE 等。也包含很多的靜態方法可以把字串變成基本型態

	// parseInt 是靜態方法, 把字串轉成整數
	int i = Integer.parseInt("23"); 
	double d = Double.parseDouble("23.4");
	// 把整數轉成字串
	String s = Integer.toString(100); 



### 傳參數

基本上 java 都是傳值（call by value），所以當我們傳一個基本型態的值時

	int a = 100;
	m1(a);
	
是把 a 的值傳過去給方法 m1。m1 修改了參數 arg 的值也不會對 a 有所影響。

	m1(int arg) {
		arg = 200; 
	}	

也就是說執行到 m1 時，會提出一個空間來存 100，讓 arg 指到這個空間。a 與 arg 有各自的空間，兩不相擾。

> 如果傳的事物件型態，就要注意值可能會被方法修改

	Person p = new Person("JJ");
	m2 (p); 
	
這時候一樣是傳值，可是 p 的值可不是 JJ 阿（物件型態的值可沒那麼單純），而是存放 p 物件的位址，假設是 10A20 好了。

	m2(Date arg2) {
		arg2.setName("JY");
	}	

這時候 arg2 會被建立出來，裡面放的p 的值（也就是，拷貝一份 p 給 arg2），所以 arg2 的值也是 10A20 了。執行 arg2.setName("JY") 時，就是要原來叫 JJ 的改名為 JY 了，因為 p 和 arg2 都是指到同一個物件阿。

> 變數只是一個物件參考、一個別名，它們可能指到同一個實體。

所以如果你不想你的物件值受到可能的修改，記得先複製一份，再傳進去。

	Person p2 = new Person(p);
	m2(p2);

### Overloading 方法

同一個類別可以有多個相同名稱的方法，只要參數不同即可。如下：

	public class DataArtist {
    	...
	    public void draw(String s) {
    	    ...
	    }
    	public void draw(int i) {
        	...
	    }
    	public void draw(double f) {
        	...
	    }
    	public void draw(int i, double f) {
        	...
	    }
	}
	
但注意不能方法參數一樣，只是傳回參數型態不同：

    	public void draw(double f) {
        	...
	    }
	    
    	public double draw(double f) {
        	...
	    }
	    

### 任意數量的參數

有時候我們不知道呼叫端會傳多少參數，可利用 ... 來允許傳任何數量的參數。

	public Polygon polygonFrom(Point... corners) {

	    int numberOfSides = corners.length;
    	double squareOfSide1, lengthOfSide1;
	    squareOfSide1 = (corners[1].x - corners[0].x)
                     * (corners[1].x - corners[0].x)
                     + (corners[1].y - corners[0].y)
                     * (corners[1].y - corners[0].y);
    	lengthOfSide1 = Math.sqrt(squareOfSide1);
    	...

	}
	
記得要先用 .length 來取得數量。


### 應用程式介面 API

和屬性的存取權控制一樣，method 也可以有 public, protected, package, private 等控制權。


當一個方法

### 封裝 Encapsulation






## IV. 建構子 Constructors

Reference: http://docs.oracle.com/javase/tutorial/java/javaOO/constructors.html

### 觀念 concept
- 也是一種方法 method
- 沒有回傳值，也不用 void
- 可以有很多不同參數的建構子
- 建構子可以用來初始化，不同參數的建構子可以做不同的初始化


```java
class ClassName {
   public ClassName( parameter) {
	   ...
	}
}
```

> 預設建構子是沒有參數的建構子。但一旦宣告了有參數的建構子，沒有參數的建構子就消失了。

	class P {
	}
	
上面的 P 並沒有宣告建構子，但你可以這樣呼叫

	P p1 = new P();
	
因為預設有一個沒有參數的建構子。但如果你宣告了一個有參數的建構子

	class P {
		public void P(int x) {
			...
		}
	}
	
則 p1 = new P() 就會造成 compile 錯誤。因為我們認為設計者想要強制物件的生成一定要做某個與 x 相關的初始化，所以預設的就會被取消。當然如果你想要也可以加回來：

	class P {
		public void P(int x) {
			...
		}
		public void P() { //加上預設建構子
			...
		}	
	}

$
> 🔔 建構子可以呼叫其他的方法

因為建構子內常常做初始化，這個動作可以交給 mutator 來做。這樣前置條件的設計可以寫在一個地方就好了。




### 複製建構子 Copy constructor

我們可以依照我們的需求生成一個我們想要的手機，只要把相關的參數帶進去就好了。

	class Phone {
		public void (int memory, int size) {
			this.memory = memory;
			this.size = size;
		}
	}	
	
有時候想要複製一樣的手機，	

	class Phone {
		public void (Phone p) {
			this.memory = p.memory;
			this.size = p.size;
		}
	}	
	
生成時只要呼叫 Phone p2 = new Phone(p1) 就可以生成一個和 p1 一模一樣的手機。上述的建構子就稱為複製建構子。它的形態是：

	class ClassName {
		public ClassName(ClassName para) {
		   ...
		}
	}

Copy constructor 很好用也很重要。設計類別時可多加利用。再來一個腳踏車的例子：

```java
	public Bicycle(int startCadence, int startSpeed, int startGear) {
	    gear = startGear;
    	cadence = startCadence; //cadence: 齒比﻿
	    speed = startSpeed;
	}

	Bicycle myBike = new Bicycle(30, 0, 8);

	public Bicycle() {
    	gear = 1;
	    cadence = 10;
    	speed = 0;
	}
```


### 練習一下
1. 寫出以下類別的建構子：Bicycle, People, Teacher
2. [] 建構子的名稱和類別名稱一樣
3. [] 一個類別建構子只能有一個
4. [] 建構子不會有回傳值 (只能用 void)






## V. 私有外洩 Privacy leak

### 觀念 concept


> 🔔 確保私有是真的私有。- It is very important to insure that private instance variables remain truly private


不要以為宣告為私有就很安全了。

> 如果是基本型態，宣告為私有就可確保不會有私有外洩。

但如果是類別型態，就要小心了！！ 

### 如何避免私有外洩（privacy leak）？

- 為你的類別設計拷貝建構子（copy constructor）
- 不要直接回傳物件參考，要拷貝，在回傳拷貝的參考。

> **回傳拷貝的參考！！**

### 鋼鐵類別 Immutable class

> 鋼鐵類別- 一旦它的值被設定了，就不能修修改了。

很驚訝吧，String 是一個鋼鐵類別

	String a = "this is a book"
	a = a.append(", not a pen");

各位看上面的 a 字串不是變化了嗎？其實真實的運作是先產生一個新的字串，它的內容是 "this is a book, not a pen", 然後再把 a 只到這個字串，原來的字串內容併沒有修改喔。

> 鋼鐵類別 是一個沒有提供可以改變內部值的方法的類別

鋼鐵類別有什麼好處？因為它的值不會被修改，所以也就不用擔心私有漏出時被亂改了。


> 🔔 不要寫一個會回傳非鋼鐵物件的方法。

如果你想要回傳的是一個非鋼鐵物件，你應該使用拷貝建構子先生成一個物件，再這個物件回傳。


打個比喻好了，你的筆記本借給同學，難保不會被同學修改的亂七八糟，怎們辦
* 拿去影印一份，在給同學。不管同學怎麼修改，你的原稿都是好的。這就是 copy and return
* 你的原稿是用鋼板刻的 - 這樣你的同學就沒有辦法在上面塗鴉啦。這就是 immutable class



即便 Person 宣告生日 birthday 為私有，還是有可能被修改到

```java
class Person {
	public Date getBirthDate() {
	   	return birthday; //** 危險
	}
}
```

改成下面的：

```java
	public Date getBirthDate() {
		// 回傳拷貝參考
	   	return new Date(birthday);
	}
```

但前提是有 Date(Date) 的拷貝建構子，如下：

```java
class Date {
   public Date(Date d) {
   	  this.year = d.getYear();
      this.month = d.getMonth();
   	  this.date = d.getDate();
   }
}
```

深拷貝 Deep copy
- 拷貝後的物件和原有的物件不會有任何共同的參考，但有一個例外：
- 共同的參考是一個鋼鐵物件。
- 不是深拷貝就是 ``淺拷貝``（shallow copy）


現在知道為什麼拷貝建構子的重要吧！


## VI. 練習 🏊🏊🏊🏊🏊

### StringTokenizer
這個類別（字串解析器）用來找出一個字串中的字，例如，"this is a book"，可以截成 this, is, a, book。

1. 在還沒有看 java 的 API 以前，你先規劃一下：這個類別該有什麼方法？你會怎麼應用這個類別？
2. 在看為這個類別的 API 後，猜猜看，這個類別內會有什麼屬性？可能的實作是什麼？


