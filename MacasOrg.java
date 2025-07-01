import java.util.Scanner;

public class MacasOrg{
    public static void main (String args[]) {
        Scanner sc1 = new Scanner(System.in);
        String macas = sc1.nextLine();
        int soma = 0;
        System.out.println("Digite em uma linha o numero de manchas de cada maçãs:");

        for (int i = 0 ; i < macas.length(); i++){
            int num = macas.charAt(i) - '0';
            soma = num %2;
        }
        System.out.println(soma+" dessas maçãs estão boas!");
    }
}