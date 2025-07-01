
	//	Todo cogumelo faz parte de uma linha reta, separados por um metro, e seu tamanho varia de 0 a 9 metros, sendo que 0 indica que não há um cogumelo no local.
	//	Você começa sempre no primeiro cogumelo.
	//	O tamanho do cogumelo em que você está indica quantos metros você consegue pular para frente no MÁXIMO.
	//	Ao chegar no último cogumelo, você GANHA.

import java.util.Scanner;
	
public class Cogumelos {
	public static void main(String[] args) {
	Scanner sc1 = new Scanner(System.in);
		
		int i = 0;
		int[][] cogus = new int[800][];
		
		while (true) {
		
			String cogumelos = sc1.nextLine();
			
			if (i >= cogus.length) break;
			if (cogumelos.isEmpty()) break;
			
			String[] vetor = cogumelos.split(",");

			int[] cogu = new int[vetor.length];
    		for (int j = 0; j < vetor.length; j++) {
        		cogu[j] = Integer.parseInt(vetor[j]);
    		}
			cogus[i] = cogu;
			i++;
			
		}
		int mod = 1000000007;
		long resposta = 1;
        for (int h = 0; h < cogus.length; h++) {
            if(pulo(cogus[h], 0) == false){ 
				resposta =( resposta * (h+1)) % mod;
				System.out.println(resposta);
			}
        }
	}
	public static boolean pulo(int[] cogu, int indice){
		int tam = cogu.length - 1;

		if(cogu[tam] == 0 || cogu[0] == 0){return false;}	
		if(indice > tam){indice = tam;}
		int x = 0;
		
		if(indice >= tam && cogu[tam] > 0){return true;}
		for(int i = cogu[indice];i > 0; i--){
			if(indice + i <= tam && cogu[indice+i] > 0){x = i; break;}
		}
		if(x == 0){return false;}
		return pulo(cogu,indice+x);
	}
}

