package practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class crossWordSolver {

	HashMap<Integer, ArrayList<String>> hm;

	crossWordSolver() {

		hm = new HashMap<>();
	}

	public void addWords(String word) {

		if (!hm.containsKey(word.length())) {

			ArrayList<String> al = new ArrayList<>();
			al.add(word);
			hm.put(word.length(), al);
		}

		else {

			ArrayList<String> al = hm.get(word.length());
			al.add(word);
			hm.put(word.length(), al);
		}

	}

	public void display() {

		System.out.println(hm);
	}
	
	public void showMatchingWords (String patern) {
		
		int len = patern.length();
		
		ArrayList <String> al = hm.get(len);
		
		Pattern pattern = Pattern.compile(patern);
		Iterator <String> itr = al.iterator();
		
		while (itr.hasNext()) {
			
			String str = itr.next();
			Matcher matcher = pattern.matcher(str);
			
			if (matcher.find()) {
			    System.out.println(str); //prints /{item}/
			} 
		}

	}

	public static void main(String[] args) {

		crossWordSolver cws = new crossWordSolver();

		// 5 letter words
		cws.addWords("jumpy");
		cws.addWords("tazza");
		cws.addWords("zizit");
		cws.addWords("jacky");

		// 4 letter words
		cws.addWords("whiz");
		cws.addWords("fozy");
		cws.addWords("joke");
		cws.addWords("jake");

		// 3 letter words
		cws.addWords("jus");
		cws.addWords("adz");
		cws.addWords("mix");
		cws.addWords("pox");

		// 6 letter words
		cws.addWords("mizzly");
		cws.addWords("scuzzy");
		cws.addWords("fuzzed");
		cws.addWords("puzzle");

		// 7 letter words
		cws.addWords("jazzman");
		cws.addWords("jazzing");
		cws.addWords("jazzily");
		cws.addWords("jazzbos");
		
		//cws.display();
		
		String inputPattern = "???z??n";
		inputPattern = inputPattern.replace('?', '.');
		
		cws.showMatchingWords (inputPattern);

	}

}
