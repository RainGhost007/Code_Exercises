
// A intensidade de mana injetada pode ir de (A-Z)
// Você escolhe o tempo que a mana vai demorar para ser processada
// Cada ponto da Orbe pode receber intensidades diferentes
// Você deve escolher sempre o ponto mais próximo possível — no exemplo abaixo representado pelo ponto mais acima
// Sempre que a mana injetada não puder ser processada, a orbe joga ela para o final da lista de operações
// Sempre que uma operação tenta ser feita, passa-se 1 segundo

// recebe o input assim "x , 00" posso colocar para .slpit e colocar numa matriz[colunas um monte][2]
// sera que posso fazer um metodo que vai adicionando tamanho ao vetor?? tentar fazer um metodo recursivo que clona o vetor e adiciona o tamanho em 1, até não precisar mais ou adquirir o parametro correto;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Horda {
	public static void main(String[] args) {
		
		String[] input = new String[0]; // vetor que receberá o input

		String filePath = "input-Horda.txt";
		
		try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){ // leitor do arquivo
			System.out.println("Este arquivo existe!");
			String line;
			while((line = reader.readLine()) != null){
			if(line.isEmpty()){break;}
			input = adiciona(line,input);
			}
		}
		catch(FileNotFoundException e){
			System.out.println("Este arquivo não existe!");
		}
		catch(IOException e){
			System.out.println("Houve um problema!");
		}

		int[] tempo = new int[10]; //vetor para adição dos segundos dos input
		System.out.println(indentificador(input, tempo, 0,0)); // chamador do método
		
	}
	public static String[] adiciona(String valorAdd, String[] vetor){ // método de adicionar 
		int tam = vetor.length;
		String[] vetorAux = new String[tam + 1];
		vetorAux[tam] = valorAdd;
		for (int i = 0; i < tam ; i++) {
			vetorAux[i] = vetor[i];
		}
		return vetorAux;
	}
	
	public static int indentificador(String[] vetor, int[] tempo, int cont,int indice){
		
		int tam = vetor.length;
		char[][] matriz = { 
			{'D','M','A','Y','P'},
			{'C','A','B','S','E'},
			{'K','B','L','G','W'},
			{'D','Z','A','V','S'},
			{'N','R','X','Q','J'},
			{'R','V','U','T','Q'},
			{'A','O','G','F','J'},
			{'H','A','X','O','W'},
			{'K','C','V','I','G'},
			{'K','C','V','L','E'}
		};

		while (indice < tam) {
        char x = vetor[indice].charAt(0);
        String[] spl = vetor[indice].split(",");
        int valor = Integer.parseInt(spl[1]);

        boolean processado = false;

        for (int i = 0; i < 10 && !processado; i++) {
            for (int j = 0; j < 5; j++) {
                if (x == matriz[i][j]) {
                    if (tempo[i] == 0) {
                        tempo[i] = valor;
                        for (int k = 0; k < 10; k++) {
                            if (tempo[k] > 0) tempo[k]--;
                        }
                        cont++;
                        indice++;
                        processado = true;
                        break;
                    }
                }
            }
        }

        if (!processado) {
            String primeiro = vetor[indice];
            for (int i2 = indice + 1; i2 < tam; i2++) {
                vetor[i2 - 1] = vetor[i2];
            }
            vetor[tam - 1] = primeiro;

            for (int k = 0; k < 10; k++) {
                if (tempo[k] > 0) tempo[k]--;
            }
            cont++;
        }
    }

    for (int h = 0; h < 10; h++) {
        cont += tempo[h];
    }

    return cont;
	}
}
