public class atividade3 {

    public void main(String[] args) {
        int K = 64;
        // tamanho da RAM
        int TCACHE = 8*1024;
        // tamanho da CACHE
        int TRAM = 16*1024*1024; // 2^24

        // pegando o numero de bits
        int nbits_x = nbits(TRAM);
        int nbits_w = nbits(K);

    }

    public int w(int x, int nbits_w){
        // pegando os seis ultimos bits
        // x = .... 1010101001 0101110
        //          0000000000 1111111 (& logico)
        //          ------------------
        //          0000000000 0101110  -> fazendo & logico se obtem o resultado
//        return x & (Math.pow(2,nbits_w)-1);
        return x & ((1<<nbits_w)-1); // fazendo a mesma coisa que o return acima
    }

    public int nbits(int v){
        int cont = 0;
        while (v>0){
            v = v >> 1; // v >>= 1
            ++cont;
        }
        return cont-1;
        // << faz o 1 se deslocar para a esquerda
//        int y = 1;  // 01
//        int z = y << 1; //10
    }
}
