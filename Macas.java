import java.util.Scanner;

public class Macas{
    public static void main(String[] args) {
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Você tem três maçãs. \nQuantos buracos tem na primeira maçãs:");
        int x = sc1.nextInt();
        System.out.println("Quantos buracos tem na segunda maçãs:");
        int y = sc1.nextInt();
        System.out.println("Quantos buracos tem na terceira maçãs:");
        int z = sc1.nextInt();
        x = (x%2);
        y = (y%2);
        z = (z%2);
        int a = z + y + z;
        System.out.printf("Você tem %d maçãs boas", a);
    }
}