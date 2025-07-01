	// Nesse código, demonios irão atacar um castelo, o rei sabendo que os demonios quando nascem precisam de 8 horas pra se duplicarem, depois dessas oito horas, nasce um novo demonio e o antigo começa a duplicar de 6 em 6 horas.
	// quantos demonios haverá em 256 horas, com o input colocado??

public class ACalmaria {
	public static void main(String[] args){
		int[] input = {1,1,1,1,1,5,1,1,1,5,1,1,3,1,5,1,4,1,5,1,2,5,1,1,1,1,3,1,4,5,1,1,2,1,1,1,2,4,3,2,1,1,2,1,5,4,4,1,4,1,1,1,4,1,3,1,1,1,2,1,1,1,1,1,1,1,5,4,4,2,4,5,2,1,5,3,1,3,3,1,1,5,4,1,1,3,5,1,1,1,4,4,2,4,1,1,4,1,1,2,1,1,1,2,1,5,2,5,1,1,1,4,1,2,1,1,1,2,2,1,3,1,4,4,1,1,3,1,4,1,1,1,2,5,5,1,4,1,4,4,1,4,1,2,4,1,1,4,1,3,4,4,1,1,5,3,1,1,5,1,3,4,2,1,3,1,3,1,1,1,1,1,1,1,1,1,4,5,1,1,1,1,3,1,1,5,1,1,4,1,1,3,1,1,5,2,1,4,4,1,4,1,2,1,1,1,1,2,1,4,1,1,2,5,1,4,4,1,1,1,4,1,1,1,5,3,1,4,1,4,1,1,3,5,3,5,5,5,1,5,1,1,1,1,1,1,1,1,2,3,3,3,3,4,2,1,1,4,5,3,1,1,5,5,1,1,2,1,4,1,3,5,1,1,1,5,2,2,1,4,2,1,1,4,1,3,1,1,1,3,1,5,1,5,1,1,4,1,2,1};
		System.out.println("Em 256 horas, terá "+quantDemon(input)+" demonios");
	}
	public static long quantDemon(int[] input){ // tentei utilizar recursão (método que cria outro array com um tamanho maior e com os mesmos valores) e arraylist, mas toda vez dava stack overflow error
		long[] tempo = new long[9];
		int tam = input.length;
		for(int j = 0; j < tam; j++){
			tempo[input[j]]++;
		}
		for (int k = 0; k < 256; k++) {
			long x = tempo[0];
			for (int i = 1; i < 9; i++) {
				tempo[i-1] = tempo[i];
			}
			tempo[8] = x;
			tempo[6] += x;
		}
		long soma = 0;
		for (int l = 0; l < 9; l++) {
			soma += tempo[l];
		}
		return soma;
	}
}
