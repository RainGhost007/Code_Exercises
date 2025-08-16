
public class GankNoRest32 {
    private long idade;
    private long vezes;
    public static void main(String[] args) {
        
        int[] input = {2,4,1,5,2,3};
        
        GankNoRest32[] aux = new GankNoRest32[input.length/2];

        for (int i = 0, k = 1; i < aux.length; i++, k+=2) {
            aux[i] = new GankNoRest32(input[k],input[k-1]);
        }
        long tam = aux.length, result = 0;
        for (int j = 0; j < 59; j++) {
            long antes = 0;
            for (int l = 0; l < tam; l++) {
                long vez = aux[l].getVezes();
                long idad = aux[l].getIdade();
                if(l == tam - 1) aux[l].setVezes(vez-1);
                if(antes%2 == 1){
                    antes = vez;
                    aux[l].setVezes((((vez-1)/2)*idad)+aux[l-1].getIdade());
                }
                    else{
                        antes = vez;
                        aux[l].setVezes((vez/2)*idad);
                    }
            }
        }
        for (GankNoRest32 aux1 : aux) {
            result += aux1.getVezes();
        }
        System.out.println(result);
    }
    public GankNoRest32(long idade, long vezes){
        this.idade=idade;
        this.vezes=vezes;
    }
    public long getIdade(){return idade;}
    public long getVezes(){return vezes;}
    public void setVezes(long vezes){this.vezes=vezes;}
}
