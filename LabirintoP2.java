import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;


public class LabirintoP2 {
	private final int x;
	private final int y;
	private final int passos;
	public static void main(String[] args) {
		
		String[] vetor = new String[201];
		int w = 0;
		String filePath = "input-LabirintoP2.txt";
		try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){ // leitor do input
			System.out.println("Este arquivo existe!");
			String line;
			while((line = reader.readLine()) != null){
			if(line.isEmpty()){break;}
			vetor[w] = line;
			w++;
			}
		}
		catch(FileNotFoundException e){
			System.out.println("Este arquivo não existe!");
		}
		catch(IOException e){
			System.out.println("Houve um problema!");
		}

		String[] vetorAux = new String[vetor.length]; // criei outro input para trabalhar no BFS, para encontrar o numero de passos que o DFS precisa estar limitado
            System.arraycopy(vetor, 0, vetorAux, 0, vetor.length);		

		LinkedList<LabirintoP2> fila = new LinkedList();
		fila.add(new LabirintoP2(0, 0, 0));
		while(vetorAux[fila.getFirst().getX()].charAt(fila.getFirst().getY()) != 'F'){ // enquanto não chegar no final -- loop
			int um = fila.getFirst().getX(), dois = fila.getFirst().getY(), tres = fila.getFirst().getPassos(); 
			if(um < vetorAux.length -1){if(vetorAux[um+1].charAt(dois) == '.' || vetorAux[um+1].charAt(dois) == 'F'){fila.add(new LabirintoP2(um+1, dois, tres+1));}}		// passar por todos os caminhos possíveis
			if(dois < vetorAux[um].length() -1){if(vetorAux[um].charAt(dois+1) == '.' || vetorAux[um].charAt(dois+1) == 'F'){fila.add(new LabirintoP2(um, dois+1, tres+1));}}
			if(um > 0){if(vetorAux[um-1].charAt(dois) == '.' || vetorAux[um-1].charAt(dois) == 'F'){fila.add(new LabirintoP2(um-1, dois, tres+1));}}
			if(dois > 0){if(vetorAux[um].charAt(dois-1) == '.' || vetorAux[um].charAt(dois-1) == 'F'){fila.add(new LabirintoP2(um, dois-1, tres+1));}}
			
			StringBuilder sb = new StringBuilder(vetorAux[um]); // utilizei o SB para mudar de . para X para que não repita o caminho ao inves de criar um objeto com algum atributo para dizer que ja foi passado por ali
			sb.setCharAt(dois, 'X');
        	vetorAux[um] = sb.toString();
			fila.removeFirst();
		}
		int pa = fila.getFirst().getPassos(); // pega o número de passos
		
		System.out.println(caminho(vetor, 0, 0, pa)); // chama o metod de DFS
	}
	public LabirintoP2(int x, int y, int passos) { // metodo construtor, utilizado no linkedList, para utilizar os atributos de coluna, linha e passos
		this.x = x;
		this.y = y;
		this.passos = passos;
	}
	public int getX() {return x;}
	public int getY() {return y;}
	public int getPassos() {return passos;}
	
	public static boolean caminho(String[] vetor, int a, int b, int passos){ // método DFS
		int tam = vetor.length, tamS = vetor[0].length();
		
		if(passos < 0){return false;} // limita o número de passos que possa dar
		if(b < 0 || b >= tam || a < 0 || a >= tamS ){return false;} // não ultrapassar o tamanho do labirinto
		if(vetor[b].charAt(a) == 'F'){return true;} // final
		if(vetor[b].charAt(a) == '#' || vetor[b].charAt(a) == 'X'){return false;} // não repetir caminho ou passar por paredes

		StringBuilder sb = new StringBuilder(vetor[b]);
		sb.setCharAt(a, 'X'); // mostrar que ja foi passado por ali
        vetor[b] = sb.toString();

		for (String linha : vetor) {
        		System.out.println(linha); // para demonstrar no terminalo o caminho
    		}

		if(caminho(vetor, a, b+1,passos-1)){return true;}
		if(caminho(vetor, a+1, b,passos-1)){return true;} // base do DFS, caminho que o metodo passa
		if(caminho(vetor, a, b-1,passos-1)){return true;}
		if(caminho(vetor, a-1, b,passos-1)){return true;}

		sb.setCharAt(a, '.');	// retira o X e coloca . em caminhos que foram passados mas não chega em lugar nenhum
    	vetor[b] = sb.toString(); 

		return false;
	}
}

