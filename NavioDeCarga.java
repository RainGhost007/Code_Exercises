import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;

public class NavioDeCarga {
	public static void main(String[] args){
		LinkedList<LinkedList<Character>> lista = new LinkedList<>();
		String[][] matriz = new String[502][];
		int i = 0, tam = matriz.length;

		String filePath = "input-NavioDeCarga.txt";
		try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){ // leitor do arquivo
			System.out.println("Este arquivo existe!");
			String line;
			while((line = reader.readLine()) != null){
			if(line.isEmpty()){break;}
			matriz[i] = line.split(" ");
			i++;
			}
		}
		catch(FileNotFoundException e){
			System.out.println("Este arquivo não existe!");
		}
		catch(IOException e){
			System.out.println("Houve um problema!");
		}
		
		lista.add(new LinkedList<>(Arrays.asList('J','H','G','M','Z','N','T','F'))); 
		lista.add(new LinkedList<>(Arrays.asList('V','W','J')));
		lista.add(new LinkedList<>(Arrays.asList('G','V','L','J','B','T','H')));
		lista.add(new LinkedList<>(Arrays.asList('B','P','J','N','C','D','V','L')));
		lista.add(new LinkedList<>(Arrays.asList('F','W','S','M','P','R','G')));
		lista.add(new LinkedList<>(Arrays.asList('G','H','C','F','B','N','V','M')));
		lista.add(new LinkedList<>(Arrays.asList('D','H','G','M','R')));
		lista.add(new LinkedList<>(Arrays.asList('H','N','M','V','Z','D')));
		lista.add(new LinkedList<>(Arrays.asList('G','N','F','H')));
		
		
		for (int j = 0; j < tam; j++) {
			int num = Integer.parseInt(matriz[j][1]);
			for (int k = 0; k < num; k++) {
				char last = lista.get(Integer.parseInt(matriz[j][3])-1).getLast();
				lista.get(Integer.parseInt(matriz[j][3]) - 1).removeLast();
				lista.get(Integer.parseInt(matriz[j][5]) - 1).addLast(last);
			}
		}
		System.out.println(lista.get(0));
		System.out.println(lista.get(1));
		System.out.println(lista.get(2));
		System.out.println(lista.get(3));
		System.out.println(lista.get(4));
		System.out.println(lista.get(5));
		System.out.println(lista.get(6));
		System.out.println(lista.get(7));
		System.out.println(lista.get(8));
	}	
}
