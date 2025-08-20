

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class OJogoDosGatos1 {
    public static void main(String[] args) {
        ArrayList<Integer>  deck1 = new ArrayList<>();
        ArrayList<Integer>  deck2 = new ArrayList<>();
		ArrayList<ArrayList<Integer>> input = new ArrayList<>(2);
		input.add(deck1);
		input.add(deck2);
		int a = 0;

		try{ // leitor do arquivo
			File arquivo = new File("input-gatos1.txt");
			Scanner sc1 = new Scanner(arquivo);
			while(sc1.hasNextLine()){
				String word = sc1.nextLine();
				
				if(word.isEmpty()){
					a = 1;
					continue;
				}

				int num = Integer.parseInt(word);
			    input.get(a).add(num);
			}
		}
		catch(FileNotFoundException e){
			System.out.println("Este arquivo não existe!");
		}
		cartas(deck1,deck2);
		
		ArrayList<Integer> deck;
		
		if(deck1.isEmpty()) deck = deck2;
			else deck= deck1;
		
		int pontos = 0;
		
		for (int i = deck.size(), j = 0; i > 0; i--,j++) pontos += i*deck.get(j);
		
		System.out.println("Pontuando: "+pontos+" pontos");
		
    }
	public static boolean cartas(ArrayList<Integer> deck1, ArrayList<Integer> deck2){
		if(deck1.isEmpty()){
			System.out.println("Person 2 win"); 
			return true;
		}
		if(deck2.isEmpty()){
			System.out.println("Person 1 win"); 
			return true;
		}
		int a, b;
		if(deck1.getFirst() > deck2.getFirst()){
			a = deck1.getFirst();
			b = deck2.getFirst();
			deck1.add(a);
			deck1.add(b);
			deck1.removeFirst();
			deck2.removeFirst();
		} 
			else{
				a = deck2.getFirst();
				b = deck1.getFirst();
				deck2.add(a);
				deck2.add(b);
				deck1.removeFirst();
				deck2.removeFirst();
			}
		return cartas(deck1,deck2);
	}
}
