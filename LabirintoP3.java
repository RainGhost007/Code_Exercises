import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.PriorityQueue;


public class LabirintoP3 {
	private final int x;
	private final int y;
	private final int andado;
	private final int falta;
	private final LabirintoP3 anterior;
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

		String[] vetorAux = new String[vetor.length]; // criei outro input para trabalhar no Algoritmo A*, para o vetor principal ser mudado só com o caminho com o menor uso de passos possivel
        System.arraycopy(vetor, 0, vetorAux, 0, vetor.length);		

		PriorityQueue<LabirintoP3> fila = new PriorityQueue<>(Comparator.comparingInt(LabirintoP3 -> LabirintoP3.falta));
		fila.add(new LabirintoP3(0, 0, 0,400,null));
		
		while(vetorAux[fila.peek().getX()].charAt(fila.peek().getY()) != 'F'){ // enquanto não chegar no final -- loop
			LabirintoP3 atual = fila.poll();
			int um = atual.getX(), dois = atual.getY(), tres = atual.getAndado(); 
			if(um < vetorAux.length -1){if(vetorAux[um+1].charAt(dois) == '.' || vetorAux[um+1].charAt(dois) == 'F'){fila.add(new LabirintoP3(um+1, dois, tres+1,Math.abs((um+dois+1)-400),atual));}}		// passar por todos os caminhos possíveis
			if(dois < vetorAux[um].length() -1){if(vetorAux[um].charAt(dois+1) == '.' || vetorAux[um].charAt(dois+1) == 'F'){fila.add(new LabirintoP3(um, dois+1,tres+1,Math.abs((um+dois+1)-400),atual));}}
			if(um > 0){if(vetorAux[um-1].charAt(dois) == '.' || vetorAux[um-1].charAt(dois) == 'F'){fila.add(new LabirintoP3(um-1, dois,tres+1,Math.abs((um+dois-1)-400),atual));}}
			if(dois > 0){if(vetorAux[um].charAt(dois-1) == '.' || vetorAux[um].charAt(dois-1) == 'F'){fila.add(new LabirintoP3(um, dois-1,tres+1,Math.abs((um+dois-1)-400),atual));}}
			
			StringBuilder sb = new StringBuilder(vetorAux[um]); // utilizei o SB para mudar de . para X para que não repita o caminho 
			sb.setCharAt(dois, 'X');
        	vetorAux[um] = sb.toString();
			
			//for(String linha : vetorAux){System.out.println(linha);}
			
		}
		caminho(vetor,fila.poll());
	
	}
	public static int[] returnF(String[] input){
		int tam = input.length, tamo = input[0].length();
		int[] result = new int[2];
		for (int i = 0; i < tam; i++) {
			for (int j = 0; j < tamo; j++) {
				if(input[i].charAt(j) == 'F'){
					result[0] = i;
					result[1] = j;
					return result;
				}
			}
		}
		return null;
	}
	public LabirintoP3(int x, int y,int andado, int falta, LabirintoP3 anterior) { // metodo construtor, utilizado no PriorityQueue, para utilizar os atributos de coluna, linha e passos
		this.x = x;
		this.y = y;
		this.andado = andado;
		this.falta = falta; 
		this.anterior = anterior;
	}
	public int getX() {return x;}
	public int getY() {return y;}
	public int getAndado() {return andado;}
	public int getFalta() {return falta;}
	public LabirintoP3 getAnterior(){return anterior;}

	public static boolean caminho(String[] vetor, LabirintoP3 objeto){
		
		StringBuilder sb = new StringBuilder(vetor[objeto.getX()]); 
		sb.setCharAt(objeto.getY(), 'X');
        vetor[objeto.getX()] = sb.toString();

		for(String linha : vetor){System.out.println(linha);}

		if(objeto.getAnterior() == null){return true;}

		return caminho(vetor,objeto.getAnterior());
	}
}
