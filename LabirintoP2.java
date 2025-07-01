import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class LabirintoP2 {
	public static void main(String[] args) {
		
		String[] vetor = new String[201];
		int w = 0;
		String filePath = "input-LabirintoP2.txt";
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
		int cont = 0;
		if(caminho(vetor, 0, 0,cont)){
			for (String linha : vetor) {
        		System.out.println(linha);
    		}
			System.out.println(cont);
		}
	}
	public static boolean caminho(String[] vetor, int y, int x, int cont){
		int tam = vetor.length, tamS = vetor[0].length();
		
		if(y < 0 || y >= tam || x < 0 || x >= tamS ){return false;}
		if(vetor[y].charAt(x) == 'F'){return true;}
		if(vetor[y].charAt(x) == '#' || vetor[y].charAt(x) == 'X'){return false;}
			
		StringBuilder sb = new StringBuilder(vetor[y]);
		sb.setCharAt(x, 'X');
        vetor[y] = sb.toString();
		
		if(caminho(vetor, y, x+1,cont+1) == true){return true;}
		if(caminho(vetor, y+1, x,cont+1) == true){return true;}
		if(caminho(vetor, y, x-1,cont+1) == true){return true;}
		if(caminho(vetor, y-1, x,cont+1) == true){return true;}
		
		sb.setCharAt(x, '.');
    	vetor[y] = sb.toString();
		
		return false;
	}
}

