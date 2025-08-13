import java.util.ArrayList;

public class GankNoRest32 {
    private int idade;
    private int vezes;
    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<>();
        ArrayList<GankNoRest32> aux = new ArrayList<>();
        input.add(2);
        input.add(4);
        input.add(1);
        input.add(5);
        input.add(2);
        input.add(3);
        for (int i = 0; i < 20; i++) {
            int tam = input.size();
            if(tam%2 == 1){input.removeLast();}
            for(int j = 1; j < tam; j+=2){
                int idade = input.get(j);
                int vezes = input.get(j-1);
                aux.add(new GankNoRest32(idade, vezes));
            }
            input.clear();
            for (int k = 0; k < aux.size(); k++) {
                for (int l = 0; l < aux.get(k).getVezes(); l++) {
                    input.add(aux.get(k).getIdade());
                }
            }
            aux.clear();
        }
        System.out.println(input.size());
    }
    public GankNoRest32(int idade, int vezes){
        this.idade=idade;
        this.vezes=vezes;
    }
    public int getIdade(){return idade;}
    public int getVezes(){return vezes;}
}
