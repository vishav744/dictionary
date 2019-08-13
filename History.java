
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
public class History extends JFrame{
	public JList lst=new JList();
	public JScrollPane jsp=new JScrollPane(lst);
	String s=new String();
	public History(){
		this.add(jsp);
		setSize(300,400);
		setTitle("History");
		setVisible(true);	
		setLocation(300,100);
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
					dispose();
				}
			});
	}
	public void VectorToTextArea(JList l,Vector v){
					l.setListData(v);
			
	}

}