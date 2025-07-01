import java.util.Scanner;
public class CodigoReal {
    public static void main(String [] args){
        Scanner sc1 = new Scanner(System.in);
        int somaTotal = 0;
		
	    while (true){
			
			String rom = sc1.nextLine();
            int tam = rom.length();
			int soma = 0;
			
			if (rom.isEmpty()) break;
			
			for (int i = 0; i < tam; i++) {
				
				if (i + 1 < tam) {
					String par = rom.substring(i, i + 2);

					switch (par) {
						case "!@" -> {
	                                            soma += 4;
	                                            i++;
	                                            continue;
	                                }
						case "!#" -> {
	                                            soma += 9;
	                                            i++;
	                                            continue;
	                                }
						case "#$" -> {
	                                            soma += 40;
	                                            i++;
	                                            continue;
	                                }
						case "#%" -> {
	                                            soma += 90;
	                                            i++;
	                                            continue;
	                                }
						case "%&" -> {
	                                            soma += 400;
	                                            i++;
	                                            continue;
	                                }
						case "%*" -> {
	                                            soma += 900;
	                                            i++;
	                                            continue;
	                                }
					}
				}

				char c = rom.charAt(i);
				switch (c) {
					case '!' -> soma += 1;
					case '@' -> soma += 5;
					case '#' -> soma += 10;
					case '$' -> soma += 50;
					case '%' -> soma += 100;
					case '&' -> soma += 500;
					case '*' -> soma += 1000;
				}
			}
			
			somaTotal += soma;
			System.out.println(somaTotal+" "+soma);
		}
    }
}