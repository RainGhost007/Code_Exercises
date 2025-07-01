import java.util.Scanner;

public class ReuniaoMagos {
	public static void main(String[] args) {
		Scanner sc1 = new Scanner(System.in);
		
		int quant = 0;
		int i = 0;
		String[][] magos = new String[20][];
		
		while (true) {
		
			String dias = sc1.nextLine();
			
			if (i >= 20) break;
			if (dias.isEmpty()) break;
			
			String[] mago = dias.split(" ");
			magos[i] = mago;
			i++;
		}
		for (int a = 0; a < 20; a++) {
			for (int b = 0; b < 20; b+=2) {
				int num1 = Integer.parseInt(magos[a][b+1]);
				for (int c = 0; c < 20; c++) {
					if (c == 19){if(quant == 19){System.out.println("O dia da reunião é: "+num1);return;} else{quant = 0;}}
					if(c == a) continue;
					for (int d = 0; d < 20; d+=2) {
						int num2 = Integer.parseInt(magos[c][d]),num3 = Integer.parseInt(magos[c][d+1]), num4;
						if(d < 18){num4 = Integer.parseInt(magos[c][d+2]);}
							else{num4 = 365;}
						if(d < 18){if(magos[c][d+1].equals(magos[c][d+2])){continue;}}
						if(num1 >= num3 && num1 < num4){++quant;break;}
							else if(num1 > num2 && num1 < num3){break;}
							else if(num1 < num2){++quant; break;}
					}
				}
			}
		}
	}
}