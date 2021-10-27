import java.util.*;

class Hangman
{
	static Scanner sc=new Scanner(System.in);
	private int count=8;	//Variabl To Keep Track Of Number of Guesses Left
	private String hidden=""; //It is the word which is displayed in game
	private String original;	//It is the original word
	private char lst;		//It is the last character entered by player
	private String incorrect_char="";
	private HangmanLexicon hl;	
	private Random rand = new Random(); 
	public Hangman()
	{
		this.set(); 
		this.play();
	}
	public void set()
	{
		randomWordGenerate(); //It generates the word
		getDashes();	//It generate the word that is displayed to player
		for(int i=0;i<original.length();i++)
			{
				// Showing only vowels in word that is diplayed to player
				if(original.charAt(i)=='A' ||original.charAt(i)=='E' || original.charAt(i)=='I' || original.charAt(i)=='O' ||original.charAt(i)=='U' )
				{
					char temp[]=hidden.toCharArray();
					temp[i]=original.charAt(i);
					hidden=String.valueOf(temp);
				}
			}
		System.out.println("Welcome to HANGMAN!");
    	System.out.println("Your word now looks like this: "+hidden);
    	System.out.println("You have "+count+" guesses left.");

	}
	public void randomWordGenerate()
	{
		hl=new HangmanLexicon();
		original=hl.getWord( rand.nextInt(hl.getWordCount())+1);
	}
	public void play()
	{
		while(count>0)
		{
			String guess;
			guess=sc.next();
			while(true)
				{
					if(guess.length()>1)
						{
									System.out.println("You can guess only one letter at a time! Try again: ");
									guess=sc.next();
						}	
					if(guess.length()==1)
							break;
				}
			lst=guess.charAt(0);
			lst=Character.toUpperCase(lst);
			check();
			if(hidden.equals(original))
			{
				System.out.println("You guessed the word: "+original);
        		System.out.println("YOU WIN!");
        		break;
			}
			System.out.println("The word now looks like this: "+hidden);
        	System.out.println("You have "+count+" guesses left.");
		}
			if(count==0){
    		System.out.println("You're completely hung.");
    		System.out.println("The word was: "+original);
    		System.out.println("YOU LOSE!");
       	}
	}
	public void check()
	{
		if(original.indexOf(lst)==-1)
		{
			System.out.println("There are no "+lst+"'s in the word.");
    		if(count!=8)
    			incorrect_char+=",";
    		incorrect_char+=lst;
    		System.out.println("Incorrect Letters: "+incorrect_char);
    		HangmanImage.hangmanImage(count);
    		count--;
    		//incorrect+=lst;
		}
		if(original.indexOf(lst)!=-1)
		{
			HangmanImage.hangmanImage(count+1);
			    System.out.println("That guess is correct.");
			    System.out.println("Incorrect Letters: "+incorrect_char);
				for(int i=0;i<original.length();i++)
				{
					if(lst==original.charAt(i))
					{
						if(i==0)
							hidden=lst+hidden.substring(1);
						else
							hidden=hidden.substring(0,i)+lst+hidden.substring(i+1);
					}

				}
		}
	}

	public void getDashes()
	{
		String tmp="_";
		for(int i=0;i<original.length();i++)
				hidden=hidden+""+tmp;
	}
}

class Build{
	public static void main(String args[])
		{
			Hangman obj=new Hangman();
			
		}
}