import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;

public class OJogoDosGatos2 {
    public static void main(String[] args) {
        LinkedList<Integer>  deck1 = new LinkedList<>(); // Os dois deck como input.
        LinkedList<Integer>  deck2 = new LinkedList<>();
		LinkedList<LinkedList<Integer>> input = new LinkedList<>();// Para auxiliar na hora de ler o arquivo
		input.add(deck1);
		input.add(deck2);
		int linha = 0;

		try{ // leitor do arquivo
			File arquivo = new File("input-gatos.txt");
			Scanner sc1 = new Scanner(arquivo);
			while(sc1.hasNextLine()){
				String word = sc1.nextLine();
				
				if(word.isEmpty()){
					linha = 1;
					continue;
				}

				int num = Integer.parseInt(word);
			    input.get(linha).add(num);
			}
		}
		catch(FileNotFoundException e){
			System.out.println("Este arquivo não existe!");
		}

		LinkedList<Integer> deck;

		String player = "";
		if(cartas(deck1,deck2)) {	// Chama o método
			player = "Jogador nº 1";
			deck = deck1;
		} else {
			player = "Jogador nº 2";
			deck = deck2;
		}

		int pontos = 0;

		for (int i = deck.size(); i > 0; i--) pontos += i*deck.removeFirst(); // Calcula os pontos

		System.out.println(" "+player+" Ganhou! \n Pontuando: "+pontos+" pontos!");

    }
	
	public static boolean cartas(LinkedList<Integer> deck1, LinkedList<Integer> deck2){
		Set<String> uniqueNames = new HashSet<>(); // Utilizado metodo set para saber se a combinação de cartas já foi jogada

        while(!deck1.isEmpty() && !deck2.isEmpty()){ // enquanto os dois decks não estiverem vazios vão continuar o jogo
			if(uniqueNames.contains(deck1.toString())){ // validação de igualdade a jogadas anteriores	
				return true;
			}
			uniqueNames.add(deck1.toString()); // se não foi jogada antes adiciona ao set

			boolean maior = deck1.getFirst() > deck2.getFirst(); // se for verdadeiro a primeira carta do deck1 é maior, e falsa vice-versa
        	if(deck1.getFirst() < deck1.size() && deck2.getFirst() < deck2.size()){
            	LinkedList<Integer> subDeck1 = subJogo(deck1, deck1.getFirst());
            	LinkedList<Integer> subDeck2 = subJogo(deck2, deck2.getFirst()); // se a primeira carta dos dois baralhos forem menores 
																				 //que o total de cartas em suas mãos havera um subjogo
            	maior = cartas(subDeck1, subDeck2); // criação de subJogos para não haver empates e recursões infinitas

			}

			int a = deck1.removeFirst(), b = deck2.removeFirst();	// remove a primeira e adiciona os dois na ultima posição do ganhador
			if(maior){
				deck1.addLast(a);
				deck1.addLast(b);
			} 
				else {
					deck2.addLast(b);
					deck2.addLast(a);
				}
		}
		return !deck1.isEmpty(); // se for verdadeiro deck1 ganha e falso deck2 ganha
	}
	public static LinkedList<Integer> subJogo(LinkedList<Integer> deck, int fim){ // método para criar subDecks
		LinkedList<Integer> subDeck = new LinkedList<>();
		for(int i = 0; i < fim; i++){
			subDeck.add(deck.get(i+1));
		}
		return subDeck;
	}
}

