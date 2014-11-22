# Iterator 覆迴設計樣式

在程式設計中，我們常常會遇到必須要叫出一一叫出陣列內的內容，為了實作出這個需求，我們便常常必須知道這個陣列內的大小或屬性等結構問題。但是在系統設計中，我們都希望系統的架構是具有堅實(Robustness)這項非功能的需求。為了能夠設計出堅實穩定的系統，我們便必須在一些內容結構的部分減少被透露，因此採用Iterator樣式的目的，便是透過抽離出瀏覽方法的方式，讓使用者不必去了解目標內容物的結構，就可以依著規定的方式呼叫出內容物件。

### Intent 目的
提供一個能夠方式去瀏覽某個集合體的內部資料，而不必去了解其內部的結構。

### Motivation 動機

目標對象是一個如同容器般的物件集合，我們不希望瀏覽這個集合的過程是必須去參考到他的內部結構，並且希望能有多種的方式去直接的瀏覽到這個集合的內容資料。此外，也不希望為了新增物件而必須增加或修改方法。

### Structure 結構
 
圖15.1　Iterator設計樣式結構

### Participant 參與者
- Iterator：瀏覽方法
- ConcreteIterator：實際的瀏覽方法
- Aggregate：物件的集合容器
- ConcreteAggregate：實際的容器本身

### Applicability 應用時機

目標是想以簡單的方式達到瀏覽一列表，如線上會員列表等。

### Benefits 效益
可以有效的建立一個瀏覽物件的集合內容，不必因為新的內容增加而必須去新增方法去引用他，不必公開其內部結構。


### Example 
在Java1.2之後已經將Iterator的方法納入其中了，具有代表性的就是Vector和HashTable的瀏覽方法，因此在這裡我們首先實作一個以Java的Vector和HashTable兩種容器來呈現出簡易瀏覽容器內容的方法。程式如下：

```java
/* 程式一 */
import java.util.*;
  public class TestEnumeration {
    public static void main(String args[]) {
	// 使用Vector並且增加內容
    Vector v = new Vector();
    v.addElement(new String("哈囉"));
    v.addElement(new Integer(999));
    v.addElement(new String("大家好"));
	// 叫出Vector內的內容
    Enumeration ev = v.elements();
       System.out.println("\nVector內的內容為:");
       traverse(ev);
       //建立HashTable並且放入各種資料.
    Hashtable h = new Hashtable();
    h.put("英文"， new Double(79.0));
    h.put("數學"， new Double(83.5));
    h.put("國文"， new Double(92.0));
	//將Hashtable內的keys部分取出
    Enumeration ekeys = h.keys();
       System.out.println("\nHash keys 的內容:");
       traverse(ekeys);
	//將Hashtable內的values部分取出
    Enumeration evalues = h.elements();
       System.out.println("\nHash values 的內容:");
       traverse(evalues);
            }
	private static void traverse(Enumeration e) {
	while (e.hasMoreElements()) {
	System.out.println(e.nextElement());
	}
   }
}

程式執行結果如下：
Vector內的內容為：
哈囉
999
大家好
Hash keys的內容：
數學
國文
英文
Hash values的內容：
83.5
92.0
79.0

從程式中可以發現在Java中使用traverse來表達了Iterator的能力。其中可以抽離出來它所使用的幾個方法，剛好可以對應到Iterator所使用的方法。
hasMoreElements() => IsDone()
nextElement() => Next() 直到CurrentItem()
另外First()則是被自動預設所提供的方法。
範例二
在象棋的系統中，我們想增加一個視窗，列舉所有已經被吃掉的棋子，就可以利用Iterator設計樣式。UML類別圖以及程式如圖15.2：
 
圖15.2　象棋程式套用Iterator設計樣式






	GamePlayPanel.java
01
02
03

04
05

06

07
08	import …
…
abstract public class GamePlayPanel extends JPanel implements MouseListener {
…
   protected Vector eatenBlack = new Vector();    // 第一個物
   件集合容器
   protected Vector eatenRed = new Vector();      // 第二個物件
   集合容器
   public static final int BLACK = 0;
   public static final int RED = 1;
   protected Enumeration eatenEnum;           // Iterator介面
   Frame2 frame2 = new Frame2();
   …
   …
   protected void eat(Chess b) {
       assert (selectedChess != null) : "the eater is null";
       if ( rule.canEat(selectedChess， b) ) {
          if(b.getSide()==BLACK) {
            eatenBlack.addElement(b.getName());  // 將物件新增
            到集合容器
            eatenEnum = eatenBlack.elements();   // 呼叫集合容器
            的建造具體Iterator方法
            frame2.traverseBlack(eatenEnum);    // 傳出具體Iterator
          }
          else {
            eatenRed.addElement(b.getName());
            eatenEnum = eatenRed.elements();
            frame2.traverseRed(eatenEnum);
          }
          …
       }
   }
}
	【程式1】：GamePlayPanel設計

	Frame2.java

import java.util.*;
import java.awt.*;
import javax.swing.*;

public class Frame2 extends JFrame {
   …
   // 將具體Iterator的內容取出
   public void traverseBlack(Enumeration e) {
     taBlack.setText("Black:");
     while(e.hasMoreElements()){
       taBlack.append(" "+(String)e.nextElement());
       c.add(taBlack，BorderLayout.NORTH);
       this.show();
     }
   }
   public void traverseRed(Enumeration e) {
   taRed.setText("Red:  ");
   while(e.hasMoreElements()){
     taRed.append(" "+(String)e.nextElement());
     c.add(taRed，BorderLayout.SOUTH);
     this.show();
   }
 }
}
	【程式2】：取出具體Iterator內容
類別Vector相當於本設計樣式的物件集合容器角色，當Vector的方法elements()被呼叫時，實際上會建造並回傳一個實作Enumeration介面的VectorEnumerator類別的物件，VectorEnumerator相當於此設計樣式的實際瀏覽方法角色，Enumeration介面則相當於瀏覽方法角色，最後frame2類別的方法透過VectorEnumerator的hasMoreElement()方法和nextElement()方法一一取出集合容器的內容，注意此處frame2類別的方法只能透過實際瀏覽方法角色去瀏覽物件集合容器內容而無法做新增、修改的動作。
  
圖15.3　象棋程式執行畫面


範例三

(預期目標→改成象棋中登錄的每一個View，配合Observer達成動態即時呈現的View List)

我們想像一個線上的聊天室環境，會員進入聊天室時必須要登入，登入後便會將使用者紀錄到列表(List)中，列表內所紀錄的就是反覆而簡單的會員暱稱和鏈結，這樣的需求很符合Iterator所設計來解決的問題，因此這時我們可以將列表的功能需求，使用Iterator樣式來達到，讓Iterator的反覆特性，走完每一個登入的資料，這樣就達到我們想要的List功能了。相關功能描述的UML如圖15.4：
 
圖15.4　線上聊天室UML圖型

綠色的部分所表達的就是我們在聊天室中使用Iterator的部分，透過Iterator的使用，可以讓系統瀏覽列表的的方法簡單的達成。
