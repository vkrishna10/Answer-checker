import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
public class AnswerChecker{

	public static void main(String[] args){

		Scanner reader = new Scanner(System.in);
		String text = "";

		consumerInterface();

			try {
		            File file = new File("Answers.txt");
		            Scanner input = new Scanner(file);

	            while (input.hasNextLine()) {
	                text += input.nextLine();

				}
	            input.close();
		    }
		      catch (Exception ex) {
	            ex.printStackTrace();
       		}


       String correctAns = "";
       for(int i = 0; i < text.length(); i++){
	   			if(text.charAt(i) == 'A' || text.charAt(i) == 'B' || text.charAt(i) == 'C' || text.charAt(i) == 'D'){
	   				correctAns +=(text.charAt(i));
	   			}
		}

		System.out.println("Enter your answers:\n");
		String yourAns = getAnswers(correctAns.length());

		ArrayList<Integer> wrong = new ArrayList<Integer>();

		while(yourAns.length() != correctAns.length()){
			System.out.println("The number of answers you put in does not match with the number of answers in the key. Please enter your answers again.\n");
			yourAns = getAnswers(correctAns.length());
		}

		boolean getsHere = false;
		System.out.println(!getsHere);
		for (int i = 0; i < correctAns.length(); i++){
			if(yourAns.toLowerCase().charAt(i) != correctAns.toLowerCase().charAt(i)){
				wrong.add((i+1));
			}
		}

		int num = (correctAns.length()-wrong.size());
		double percent =  ( (double) num)/( (double) correctAns.length()) * 100.0;

		System.out.println("You got a " + (num) + "/" + correctAns.length() + " which is a " + percent + "%");
		System.out.println("The wrong numbers are: \n" + wrong);
	}

	public static void consumerInterface(){
		System.out.println("Welcome to the answer checker! For this program to work, the correct answers must be in the answers.txt file.\n");
	}

	public static String getAnswers(int x){
		Scanner input = new Scanner(System.in);
		System.out.println("Enter your answers for the Quiz section (Only MCs):\n");
		String ans = "";
		for(int i = 0; i < x; i++){
			System.out.print((i + 1) + ". ");
			ans += input.next().charAt(0);
			input.nextLine();
			System.out.println();

		}

		return ans;
	}


}