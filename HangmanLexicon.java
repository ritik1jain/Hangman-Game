import java.io.*;
import java.util.*;
public class HangmanLexicon{
	private ArrayList<String> wordList=new ArrayList<String>(); // For storing words 
	public HangmanLexicon()
	{
		try{
			File file=new File("HangmanLexicon.txt");
			BufferedReader br = new BufferedReader(new FileReader(file)); 
			while(true)
			{
				String str=br.readLine();
				if(str==null) break;
				wordList.add(str);
			}
		}
		catch (FileNotFoundException ex){
        	 System.out.println(ex);
    	}
    	catch (IOException ex){
        	  System.out.println(ex);	
        }
}
	public int getWordCount()
	{
		return wordList.size();
	}
	public String getWord(int index)
	{
		return wordList.get(index);
	}
}
class Run{
	public static void main(String args[])
		{
			HangmanLexicon obj=new HangmanLexicon();
			System.out.println(obj.getWordCount()+" "+obj.getWord(1));
		}
}
