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
	public static boolean caminho(String[] vetor, int y, int x){
		int tam = vetor.length, tamS = vetor[0].length();
		
		
		if(y < 0 || y >= tam || x < 0 || x >= tamS ){return false;}
		if(vetor[y].charAt(x) == 'F'){return true;}
		if(vetor[y].charAt(x) == '#' || vetor[y].charAt(x) == 'X'){return false;}
			
		StringBuilder sb = new StringBuilder(vetor[y]);
		sb.setCharAt(x, 'X');
        vetor[y] = sb.toString();
		
		for (String linha : vetor) {
        		System.out.println(linha);
    		}
		
		if(caminho(vetor, y, x+1) == true){return true;}
		if(caminho(vetor, y+1, x) == true){return true;}
		if(caminho(vetor, y, x-1) == true){return true;}
		if(caminho(vetor, y-1, x) == true){return true;}
		
		sb.setCharAt(x, '.');
    	vetor[y] = sb.toString();
		
		return false;
	}
}

