
public class OrbeMagico{
	public static void main(String[] args){
		
		// Pegar um numero e tentar percorrer o vetor inteiro, se não encontrar vai para o proximo, se encontrar vai salvar os dois indices.
		// Caso o proximo número que quero compara de um match no mesmo indice que o anterior deu, tenta pular esse indice e não efetua o match.
		
		int[] orbe = {347, 163, 94, 209, 28, 137, 337, 62, 459, 487, 221, 251, 461, 152, 151, 18, 64, 242, 60, 19, 141, 355, 119, 125, 177, 244, 141, 192, 494, 466, 422, 85, 160, 77, 279, 286, 493, 375, 431, 219, 15, 347, 162, 417, 422, 48, 460, 55, 331, 147, 37, 267, 363, 251, 474, 35, 4, 187, 493, 391, 170, 286, 65, 352, 154, 222, 336, 393, 204, 433, 425, 60, 202, 426, 309, 61, 276, 52, 54, 1, 265, 241, 110, 476, 302, 439, 116, 274, 189, 160, 400, 14, 176, 31, 493, 267, 208, 115, 454, 445, 389, 206, 250, 398, 20, 454, 136, 332, 485, 53, 330, 482, 174, 105, 68, 69, 90, 317, 190, 113, 329, 215, 421, 95, 475, 229, 214, 453, 250, 344, 36, 120, 82, 84, 185, 402, 402, 4, 230, 21, 153, 164, 331, 357, 188, 228, 308, 491, 486, 429, 400, 7, 65, 47, 273, 22, 22, 132, 99, 388, 249, 91, 406, 396, 8, 485, 5, 151, 390, 436, 111, 251, 274, 86, 385, 205, 39, 393, 232, 424, 361, 228, 19, 227, 46, 309, 320, 123, 90, 190, 265, 212, 321, 99, 322, 442, 33, 74, 233, 234};
		int tam = orbe.length, aux = 0;
		for (int i = 0; i < tam; i++) {
			for (int j = 0; j < tam; j++) {
				int[] vetor = orbe;
				if(j == i){continue;}
				if (vetor[i] + vetor[j] == 19) {aux+= i+j;vetor[i] = 20; vetor[j] = 20;}
			}
		}
		System.out.println(aux);		
	}
} 