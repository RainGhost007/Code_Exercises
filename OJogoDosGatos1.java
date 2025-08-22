

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class OJogoDosGatos1 { // jogo dos gatos sem recursão e sem comparação para desempate
    public static void main(String[] args) {
        LinkedList<Integer>  deck1 = new LinkedList<>();
        LinkedList<Integer>  deck2 = new LinkedList<>();
		LinkedList<LinkedList<Integer>> input = new LinkedList<>();
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
		while(!deck1.isEmpty() && !deck2.isEmpty()){ // enquanto os dois decks não estiverem vazios vão continuar o jogo


			int a = deck1.removeFirst(), b = deck2.removeFirst(); // remove a primeira e adiciona os dois na ultima posição do ganhador
			if(a > b){ 
				deck1.addLast(a); 
				deck1.addLast(b);
			} 
				else {
					deck2.addLast(b);
					deck2.addLast(a);
				}

		}
		LinkedList<Integer> deck;

		if(deck1.isEmpty()) deck = deck2;	// verifica o ganhador
			else deck= deck1;
		
		int pontos = 0;
		
		for (int i = deck.size(); i > 0; i--) pontos += i*deck.removeFirst(); // calcula os pontos
		
		System.out.println("Pontuando: "+pontos+" pontos"); 
		
    }
	
}
