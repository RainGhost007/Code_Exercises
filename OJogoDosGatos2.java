import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class OJogoDosGatos2 {
    public static void main(String[] args) {
        ArrayList<Integer>  deck1 = new ArrayList<>();
        ArrayList<Integer>  deck2 = new ArrayList<>();
		ArrayList<ArrayList<Integer>> input = new ArrayList<>(2);
		input.add(deck1);
		input.add(deck2);
		int a = 0;

		try{ // leitor do arquivo
			File arquivo = new File("input-gatos2.txt");
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
        return cartas(deck1, deck2,true);
    }
	public static boolean cartas(ArrayList<Integer> deck1, ArrayList<Integer> deck2, boolean maior){
		
        if(deck1.isEmpty() || deck2.isEmpty()){
            return true;
        }


        maior = deck1.getFirst() > deck2.getFirst();
        if(deck1.getFirst() < deck1.size() && deck2.getFirst() < deck2.size()){
            ArrayList<Integer> deck3 = subJogo(deck1,new ArrayList<>(deck1.getFirst()));
            ArrayList<Integer> deck4 = subJogo(deck2,new ArrayList<>(deck2.getFirst()));
            if(cartas(deck3, deck4,maior)){
                if(deck3.isEmpty()){maior = true;}
                if(deck2.isEmpty()){maior = false;}
            }
        }

		int a, b;
		if(maior){
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
		return cartas(deck1,deck2,maior);
	}
    
    public static ArrayList<Integer> subJogo(ArrayList<Integer> deck1, ArrayList<Integer> deckC){
        int tam = deckC.size();
        for (int i = 1; i < tam; i++) {
            deckC.add(deck1.get(i));
        }
        return deckC;
    }
}

