package mvc;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MVC_Demo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Counter c = new Counter();
		
		CounterView view1 = new CounterView();
		view1.setVisible(true);
		CounterView view2 = new CounterView();
		view2.setVisible(true);
		
		c.addObserver(view1);
		c.addObserver(view2);
		
		CounterController controller1 = new CounterController(c);
		controller1.setVisible(true);
		CounterController controller2 = new CounterController(c);
		controller2.setVisible(true);	
	}

}

/*
 * Model
 */
class Counter extends Observable {
	int counter=0;
	
	public void incCounter() {
		counter++;
		setChanged();
		notifyObservers(new Integer(counter));
	}
		
	public int getCounter() {
		return counter;
	}	
}

/*
 * View
 */
class CounterView extends JFrame implements Observer {

	private static final long serialVersionUID = 1L;
	private TextField tf = new TextField(10);	
	public CounterView() {
		super("MVC demo");
		tf.setText("0");
		add(tf);
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		int c = ((Integer)arg1).intValue();
		tf.setText(String.valueOf(c));
	}	
}

/*
 * Control
 */
class CounterController extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	private JButton inc = new JButton("inc");	
	
	Counter c;
	
	public CounterController(Counter _c) {
		this.c = _c;
		inc.addActionListener(this);
		add(inc);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		c.incCounter();
	}	
}