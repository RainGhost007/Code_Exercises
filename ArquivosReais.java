
public class ArquivosReais { // precisa acabar
	public static void main(String[] args) {
		
	}
	public static boolean aprova(String codigos){
		return codigos.length() >= 9;
	}
	public static int[] transforma(String codigos){
		int tam = codigos.length();
		
		int[] num = new int[11];
		
		for (int i = 0; i < tam; i++) {
			int j = 0;
			if(i >= tam){
				if(codigos.charAt(i) == '1'){
					if(codigos.charAt(i+1) == '0'){num[j] = (codigos.charAt(i)+codigos.charAt(i+1)) - '0'; i++;}
				}
			}
			num[j] = codigos.charAt(i) - '0';
			j++;
		}
		if(tam == 9){num[9] = 11; num[10] = 11;}
		if(tam == 10){num[10] = 11;}
		return num;
	}
	public static void produto(int[] num, int tam){
		int[] aux = new int[11];
		
	}
}
