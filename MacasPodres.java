import java.util.Scanner;

public class MacasPodres{
    public static void main (String args[]) {
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Quantas maçãs serão?");
        int macas = sc1.nextInt();
        int x = 0;
        int soma = 0;
        while (x < macas){
           x++;
            System.out.println("Quantas manchas tem a "+x+"ª maçã?");
            int manchas = sc1.nextInt();
            manchas %= 2;
            soma += manchas;
        }

        System.out.println(soma+" dessas maçãs são boas");
    }
    
}