import java.util.Scanner;

public class ElixirSagrado{

    public static void main(String [] args){
        Scanner sc1 = new Scanner(System.in);
        String mexida = sc1.nextLine();
        int densidade = 1;
        int ciclos = 1;
        int start = 0;
        int tam = mexida.length();
		int soma = 0;
        while (start < tam){
            while (start < tam && mexida.charAt(start) == ' ') {
                ++start;
            }

            if (start + 4 <= tam) {
                String word = mexida.substring(start, start + 4);
                
                switch (word) {
                    case "addx" -> {
                        start += 4;
                        while (start < tam && mexida.charAt(start) == ' ') {
                            start++;
                        }   boolean negativo = false;
                        if (start < tam && mexida.charAt(start) == '-') {
                            negativo = true;
                            start++;
                        }   int valor = 0;
                        while (start < tam && Character.isDigit(mexida.charAt(start))) {
                            valor = valor * 10 + (mexida.charAt(start) - '0');
                            start++;
                        }   if (negativo) {
                            valor = -valor;
                        }   
                        ciclos += 2;
                        densidade += valor;
                    }
                    case "noop" -> {
                        start += 4;
                        ++ciclos;
                    }
                    default -> start++;
                }
                
                int[] vet = {20,60,100,140,180,220};
                int length = vet.length;
                for (int j = 0; j < length; j++){
                    if(ciclos == vet[j]){
                        System.out.println(ciclos+" e "+densidade+" = "+densidade*ciclos);
						soma += densidade * ciclos;
                    }
                    else {if (ciclos == vet[j] - 1 && ciclos >= 20){
                        System.out.println((ciclos+1)+" e "+densidade+" = "+ densidade *(ciclos+1));
						soma += densidade * (ciclos+1);
                    }
                    } 
                }
				System.out.println(ciclos+" e "+densidade+" = "+densidade*ciclos);
            }    
        }
		System.out.println(soma);
    }
}
