import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Sudoku {
	public static void main(String[] args) {
		
		String[] vetor = new String[9];
		int w = 0;
		String filePath = "input-Sudoku.txt";
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
		
		
		caminho(vetor, 0, 0);
		for(String linha : vetor){System.out.println(linha);}
		
	}
	public static boolean verifica(String[] vetor, int a, int b, int num){
		int auxA = (a / 3) * 3;
		int auxB = (b / 3) * 3;
		
		if(a < 0 || a >= vetor.length || b < 0 || b >= vetor[0].length() ){return false;} 

		for(int i = auxA; i < auxA + 3; i++){
			for(int j = auxB; j < auxB + 3; j++){
				if(vetor[i].charAt(j) - '0' == num){
				return false;
				}
			}
		}
		
		for(int i = 0; i < 9; i++){
			if(vetor[i].charAt(b) - '0' == num){
				return false;
			}
		}
		
		for(int i = 0; i < 9; i++){
			if(vetor[a].charAt(i) - '0' == num){
				return false;
			}
		}
		
		return true;
	}

	public static boolean isComplete(String[] vetor){
		for(String linha: vetor){
			if(linha.contains(".")){return false;}
		}
		return true;
	}
	
	public static boolean caminho(String[] vetor, int a, int b){
		if(a < 0 || a >= vetor.length || b < 0 || b >= vetor[0].length() ){return false;}
		
		if(isComplete(vetor)){return true;}


		if(vetor[a].charAt(b) != '.'){
			if(b == 8){return caminho(vetor, a+1, 0);}
				else{return caminho(vetor, a, b+1);}
		}
		
		for (int i = 1; i < 10; i++) {
			if(verifica(vetor, a, b, i)){
				StringBuilder sb = new StringBuilder(vetor[a]);
				sb.setCharAt(b, (char) (i +'0'));
				vetor[a] = sb.toString();
				
				if(b == 8){if(caminho(vetor, a+1, 0)){return true;}}
				else{if(caminho(vetor, a, b+1)){return true;}}

				sb.setCharAt(b, '.');
				vetor[a] = sb.toString();
			}
		}
		
		return false;
	}
}
