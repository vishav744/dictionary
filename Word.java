import java.io.*;
public class Word implements Serializable{
   String word="fkldjfkdf";
   String definition="fkewjkfljdf";

  public void writeToFile(FileOutputStream outStream) throws IOException{
    ObjectOutputStream ooStream = new ObjectOutputStream(outStream);
    ooStream.writeObject(this);
    ooStream.flush();
  } // writeToFile()

  public void readFromFile(FileInputStream inStream)
           throws IOException, ClassNotFoundException {
    ObjectInputStream oiStream = new ObjectInputStream(inStream);
    Word s = (Word)oiStream.readObject();
    this.word = s.word;
    this.definition = s.definition;
  } // readFromFile()

} // Word class

