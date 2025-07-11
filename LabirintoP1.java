import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class LabirintoP1 {
	public static void main(String[] args) {
		
		String[] vetor = new String[21];
		int w = 0;
		String filePath = "input-LabirintoP1.txt";
		try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){ // leitor do arquivo
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
		if(caminho(vetor, 0, 0)){
			for (String linha : vetor) {
        		System.out.println(linha);
    		}
		}
	}
	public static boolean caminho(String[] vetor, int a, int b){ // método DFS
		int tam = vetor.length, tamS = vetor[0].length();
		
		if(b < 0 || b >= tam || a < 0 || a >= tamS ){return false;} // não ultrapassar o tamanho do labirinto
		if(vetor[b].charAt(a) == 'F'){return true;} // final
		if(vetor[b].charAt(a) == '#' || vetor[b].charAt(a) == 'X'){return false;} // não repetir caminho ou passar por paredes

		StringBuilder sb = new StringBuilder(vetor[b]);
		sb.setCharAt(a, 'X'); // mostrar que ja foi passado por ali
        vetor[b] = sb.toString();

		for (String linha : vetor) {
        		System.out.println(linha); // para demonstrar no terminalo o caminho
    		}

		if(caminho(vetor, a, b+1) == true){return true;}
		if(caminho(vetor, a+1, b) == true){return true;} // base do DFS, caminho que o metodo passa
		if(caminho(vetor, a, b-1) == true){return true;}
		if(caminho(vetor, a-1, b) == true){return true;}

		sb.setCharAt(a, '.');	// retira o X e coloca . em caminhos que foram passados mas não chega em lugar nenhum
    	vetor[b] = sb.toString(); 

		return false;
	}
}

