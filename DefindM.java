import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
import java.io.*;
	public class DefindM{
	public int getInd(String s,JList listword){
		int d=0;
		while(s.compareToIgnoreCase(listword.getModel().getElementAt(d).toString())>0){
			d++;
			if(d==listword.getModel().getSize())break;
		}
		return d;
	}
	public boolean isDuplicate(String s,JList listword){
		boolean isD=false;
			for(int j=0;j<listword.getModel().getSize();j++)
				if(listword.getModel().getElementAt(j).toString().equalsIgnoreCase(s)){
					isD=true;
					break;
				}
		return isD;		
	}
	public void ReadFromFile(String filename,Vector vWord,Vector vDefinition){
		try{
			FileInputStream file=new FileInputStream(filename);
			Word w=new Word();
			try{
				while(true){
					w.readFromFile(file);
					vWord.add(w.word);
					vDefinition.add(w.definition);
				}
			}catch(Exception ext){}
		}catch(Exception exe){}
	}
	public void WriteToFile(String filename,Vector vWord,Vector vDefinition){
		int p=0;
		try{
			FileOutputStream file=new FileOutputStream(filename);
			for(int i=0;i<vWord.size();i++){
			Word w=new Word();
			w.word=(String)vWord.elementAt(i);
			w.definition=(String)vDefinition.elementAt(i);		
			w.writeToFile(file);
		}
			file.close();
			JOptionPane.showMessageDialog(null,"File has been saved successfully","Successfully",JOptionPane.INFORMATION_MESSAGE);
		
		}catch(Exception exe){}
			System.exit(0);
	}

}	