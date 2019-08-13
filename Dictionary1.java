import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.print.*;
import javax.swing.border.*;
public class Dictionary1 extends JFrame implements ListSelectionListener,CaretListener{
	DefindM D=new DefindM();
	Declaration Var=new Declaration();
	//String Filename="File\\Dictionary.bin";
	String Filename="File\\DictionaryComputing.bin";
	//Constructor
	Dictionary1(){
		setLayout(null);

		////Read File into Vector////////////////
		
		D.ReadFromFile(Filename,Var.vWord,Var.vDefini);
		if(Var.vWord.elementAt(0).toString()==""){
			Var.vWord.remove(0);
			Var.vDefini.remove(0);
		}
		Var.listword.setListData(Var.vWord);
		JScrollPane jsp=new JScrollPane(Var.listword);
		JScrollPane jspArea;
		Var.pic.setBounds(155,-15,65,65);

		Var.txtword.setFont(new Font("Courier New",Font.BOLD,12));
		this.add(Var.pic);
		if(Var.countChecking>=Var.max_word){Permition();}
		if(Var.countChecking<=Var.max_word){Var.cmdLogon.setEnabled(false);Var.cmdAddtoView.setEnabled(true);}
		Var.cmdAddtoView.setBounds(70,30,149,23);
		Var.cmdAddtoView.setForeground(Color.BLUE);
		Var.cmdAddtoView.setMnemonic('i');
		this.add(Var.cmdAddtoView);
		//set Toolbar////
		JToolBar toolbar=new JToolBar();
		toolbar.add(Var.cmdNewWord);
		Var.cmdNewWord.setToolTipText("Add New Word");
		toolbar.add(Var.cmdCheckedW);
		Var.cmdCheckedW.setToolTipText("History");
		toolbar.add(Var.cmdabout);
		Var.cmdabout.setToolTipText("About Us");
		Var.cmdLogon.setToolTipText("Unlock");
		toolbar.add(Var.cmdLogon);
		toolbar.add(Var.cmdExit);
		Var.cmdExit.setToolTipText("Exit");
		toolbar.setBounds(0,0,600,30);
		getContentPane().add(toolbar);

		///////set MenuBar///////////
		Var.mFile.setMnemonic('F');
		Var.m_Exit.setMnemonic('x');

		Var.mFile.add(Var.m_Exit);
		JMenuBar bar=new JMenuBar();
		bar.add(Var.mFile);
		Var.mEdit.setMnemonic('E');

		Var.m_NewWord.setMnemonic('N');
		Var.mEdit.add(Var.m_NewWord);
		bar.add(Var.mEdit);
		Var.mView.setMnemonic('e');
		Var.m_Checked_Word.setMnemonic('W');
		Var.mView.add(Var.m_Checked_Word);
		bar.add(Var.mView);
		Var.mHelp.setMnemonic('H');
		Var.m_aboutus.setMnemonic('a');
		Var.m_HelpFile.setMnemonic('F');
		Var.mHelp.add(Var.m_aboutus);
		Var.mHelp.addSeparator();
		Var.mHelp.add(Var.m_HelpFile);
		bar.add(Var.mHelp);
		setJMenuBar(bar);
		////////////////////End adding MenuBar///////////////////////
		//Add JTextField///

		Var.txtword.setBounds(10,55,210,23);
		Var.txtword.setBorder(BorderFactory.createEtchedBorder());
		this.add(Var.txtword);
		Var.listdefini.setBorder(BorderFactory.createEtchedBorder());

		/////add JList and JTextArea///////////
		Var.listword.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		jsp.setBounds(10,80,210,350);
		this.add(jsp);

		Var.lblword.setBounds(225,55,355,23);
		Var.lblword.setBackground(Color.LIGHT_GRAY);
		Var.lblword.setBorder(BorderFactory.createEtchedBorder());
		this.add(Var.lblword);

		jspArea=new JScrollPane(Var.listdefini);
		jspArea.setBounds(225,80,355,350);

		Var.listdefini.setEditable(false);
		Var.listdefini.setForeground(Color.BLUE);
		Var.lblword.setForeground(Color.BLUE);
		this.add(jspArea);
		/////////add JButton///////////
		Var.cmdPrevious.setBounds(10,30,30,23);
		Var.cmdPrevious.setToolTipText("View Prvious");
		this.add(Var.cmdPrevious);
		Var.cmdNext.setBounds(40,30,30,23);
		Var.cmdNext.setToolTipText("View Next");
		this.add(Var.cmdNext);
		/////////////set JLabel Copy///////////////
		Var.lblcopy.setBounds(363,425,300,20);
		Var.lblcopy.setFont(new Font("Courier New",Font.TRUETYPE_FONT,10));
		this.add(Var.lblcopy);
		Var.lblcopy1.setBounds(350,435,300,20);
		Var.lblcopy1.setFont(new Font("Courier New",Font.TRUETYPE_FONT,10));
		this.add(Var.lblcopy1);
		Var.lblcopy2.setBounds(363,445,300,20);
		Var.lblcopy2.setFont(new Font("Courier New",Font.TRUETYPE_FONT,10));
		this.add(Var.lblcopy2);
		Var.lblcopy3.setBounds(345,455,300,20);
		Var.lblcopy3.setFont(new Font("Courier New",Font.TRUETYPE_FONT,10));
		this.add(Var.lblcopy3);

		////////////////////////////////////////////

		//////////////Add ActionListener////////////////

		Var.listword.addListSelectionListener(this);
		Var.txtword.addCaretListener(this);
			/////////////Starting Button Handle Event//////////////

		Var.cmdNewWord.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					cmdNewWord_Click(e);
				}
			});
		Var.m_NewWord.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
					cmdNewWord_Click(e);
				}
			});
		Var.cmdExit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				cmdExit_Click(e);
				}
			});
		Var.m_Exit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
					cmdExit_Click(e);
				}
			});
		Var.cmdPrevious.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
					cmdPrevious_Click(e);
				}
			});
		Var.cmdNext.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
					cmdNext_Click(e);
				}
			});
		Var.cmdCheckedW.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
					cmdCheckedW_Click(e);
				}
			});
		Var.m_Checked_Word.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
					cmdCheckedW_Click(e);
				}
			});
		Var.cmdabout.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
					cmdabout_Click(e);
				}
			});
		Var.m_aboutus.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
					cmdabout_Click(e);
				}
			});
		Var.cmdLogon.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
					cmdLogon_Click(e);
				}
			});
		Var.cmdAddtoView.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
					cmdAddtoView_Click(e);
				}
			});
		Var.m_HelpFile.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				new HelpFile();
			}
		});	


		/////////////End Starting Button Handle Event//////////



					/////////////////end set List////////////

		/*
		 *Set Frame
		 */
		setSize(600,530);
		setLocation(210,120);
		setTitle("Dictionary");
		setVisible(true);
		this.setResizable(false);
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
					if(Var.isModified){
					D.WriteToFile(Filename,Var.vWord,Var.vDefini);
					System.exit(0);
				}
				else System.exit(0);
				}
			});
	}
	///////////////////////Start Event Handler/////////////////////////////

	public void valueChanged(ListSelectionEvent e){

		Var.listdefini.setText(Var.vDefini.elementAt(Var.listword.getSelectedIndex()));
		Var.listdefini.setFont(new Font("Courier New",Font.TRUETYPE_FONT,13));

		Var.listdefini.setLineWrap(true);

		Var.lblword.setText(Var.vWord.elementAt(Var.listword.getSelectedIndex()));
		Var.lblword.setFont(new Font("Courier New",Font.BOLD,14));
		Var.countChecking++;
		//get Checking word
	}
	public void caretUpdate(CaretEvent e){
		try{
		int i=D.getInd(Var.txtword.getText(),Var.listword );
		Var.listword.ensureIndexIsVisible(i);
		Var.listword.setSelectedIndex(i);
		Var.listdefini.setLineWrap(true);
		}catch(Exception exe){JOptionPane.showMessageDialog(this,exe.toString());}
	}

	public void cmdNewWord_Click(ActionEvent e){
			String aWord,aDefini;
			Var.listdefini.setEditable(true);
			Var.isModified=true;
			aWord=Var.txtword.getText();
			aDefini=Var.listdefini.getText();
			int k=D.getInd(aWord,Var.listword);
			try{
			if(!D.isDuplicate(aWord,Var.listword) && !aWord.isEmpty()){
				Var.vWord.add(k,aWord);
				Var.vDefini.add(k,aDefini);
			}
			Var.listdefini.setText("");
			Var.txtword.setText("");
			Var.listword.setListData(Var.vWord);
		}catch(Exception exe){}

	}

	public void cmdExit_Click(ActionEvent e){

			if(Var.isModified){
				int a=JOptionPane.showConfirmDialog(this,"Do you want to save change ?","Comfirm",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
				if (a==0)
					D.WriteToFile(Filename,Var.vWord,Var.vDefini);
				if (a==1)
				System.exit(0);
				}
			else{
			int a1=JOptionPane.showConfirmDialog(this,"Do you want to Exit ?","Comfirm Exit",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				if (a1==0) System.exit(0);
			}

}
	public void cmdPrevious_Click(ActionEvent e){
		try{
		Var.listword.setSelectedIndex(Var.listword.getSelectedIndex()-1);
		Var.listword.ensureIndexIsVisible(Var.listword.getSelectedIndex());
		Var.listdefini.setText(Var.vDefini.elementAt(Var.listword.getSelectedIndex()));
		Var.listdefini.setFont(new Font("Courier New",Font.TRUETYPE_FONT,13));

		Var.listdefini.setLineWrap(true);
		Var.listdefini.setEditable(false);
		Var.lblword.setText(Var.vWord.elementAt(Var.listword.getSelectedIndex()));
		Var.lblword.setFont(new Font("Courier New",Font.BOLD,14));
		}catch(Exception exe){}
	}
	public void cmdNext_Click(ActionEvent e){
		try{
		Var.listword.setSelectedIndex(Var.listword.getSelectedIndex()+1);
		Var.listword.ensureIndexIsVisible(Var.listword.getSelectedIndex());
		Var.listdefini.setText(Var.vDefini.elementAt(Var.listword.getSelectedIndex()));
		Var.listdefini.setFont(new Font("Courier New",Font.TRUETYPE_FONT,13));

		Var.listdefini.setLineWrap(true);
		Var.listdefini.setEditable(false);

		Var.lblword.setText(Var.vWord.elementAt(Var.listword.getSelectedIndex()));
		Var.lblword.setFont(new Font("Courier New",Font.BOLD,14));
		}catch(Exception exe){}
	}
	public void cmdCheckedW_Click(ActionEvent e){
		new ViewChecking();
	}
	public void cmdabout_Click(ActionEvent e){
		new AboutUs();
	}
	public void cmdLogon_Click(ActionEvent e){
		Permition();
	}
	public void cmdAddtoView_Click(ActionEvent e){
		String s=(Var.txtword.getText()).toString();
		try{
		if(s.toString().equalsIgnoreCase("")) JOptionPane.showMessageDialog(this,"Please, Type one word");
		if(Var.listword.getSelectedValue().toString().equalsIgnoreCase(s))
			{
				Var.vViewWord.add(s);
				Var.vViewDefe.add(Var.listdefini.getText());
				}
			
		}catch(Exception exe){}
	}

	public void Permition(){
		String a;
		a=JOptionPane.showInputDialog(null,"              Enter The Serial Number\n      (16 Digits:0000-0000-0000-0000)");
		if(!Var.str.equalsIgnoreCase(a)){
			JOptionPane.showMessageDialog(this," You can access this Dictionary Read-Only ");
				Var.cmdLogon.setEnabled(true);
				Var.txtword.disable();
				Var.cmdAddtoView.setEnabled(false);
			}
		else{
				JOptionPane.showMessageDialog(this,"Successfully!! You can access this Dictionary Full Permission");
				Var.txtword.enable(true);
				Var.cmdLogon.setEnabled(false);
				Var.cmdAddtoView.setEnabled(true);

			}
	}
	public static void main(String args[]){
		new Dictionary1();
	}
	class ViewChecking extends JDialog{
		ViewChecking()
		{
			String w = "";
			String d = "";
			
			for(int i=0;i<Var.vViewWord.size();i++)
			{
				w += (i+1) + "."   +Var.vViewWord.elementAt(i)+"\n\n";
				d += (i+1) + "  ." +Var.vViewDefe.elementAt(i)+"\n\n" ;
			}
		JPanel p = new JPanel(new BorderLayout());
		p.add("West",new JScrollPane(Var.txtgetViewWord));
		p.add("Center",new JScrollPane(Var.txtgetViewDefe));
		Var.txtgetViewDefe.setWrapStyleWord(true);
		Var.txtgetViewWord.setText(w);
		Var.txtgetViewDefe.setText(d);
		Var.txtgetViewWord.setBackground(Color.CYAN);
		Var.txtgetViewDefe.setFont(new Font("Courier New",Font.BOLD,14));
		Var.txtgetViewWord.setFont(new Font("Courier New",Font.BOLD,14));
		getContentPane().add(p);
		setTitle("History");
		setSize(600,500);
		setLocation(210,120);
		setVisible(true);
		}
	}
	class HelpFile extends JDialog{
		HelpFile()
		{
			JPanel p = new JPanel(new GridLayout(6,0));
			p.add(new JLabel("Welcome to Help File"));
			p.add(new JLabel("Add New Word: Click AddNewWord to start adding new Word and Definition"));
			p.add(new JLabel("After fill all of word and definition click on AddNewWord again"));
			p.add(new JLabel("Add to View: this list can store the word that you checked."));
			p.add(new JLabel("Click on it or Press (Alt+i) to start storing the word"));
			p.add(new JLabel("To see the words that you has been checked Click on History."));
			getContentPane().add(p);
			setSize(500,400);
			setLocation(210,120);
			setResizable(false);
			setVisible(true);
			
		}
	}
}