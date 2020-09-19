import java.util.ArrayList;

public class CACHE{
    // CACHE é composta por uma arraylist de CACHELINE
    private ArrayList<CACHELINE>mem;
    private RAM ram = null;

    public CACHE(){};

    // inicializando a mem da CACHE com um tamanho limitado
    public CACHE(int size, RAM ram){
        this.mem = new ArrayList<CACHELINE>(size);
        this.ram = ram;
    }

    // inserindo uma CACHELINE na CACHE
    public void insertCacheLine(int size_bloco, int end_bloco){
        this.mem.add(new CACHELINE(size_bloco, end_bloco));
    }

    //
    public void Set(int address, int word){
        //
    }

    public ArrayList<CACHELINE> getMem() {return mem;}

    public void setMem(ArrayList<CACHELINE> mem) {this.mem = mem;}

    // fazendo uma condicao & logica com os ultimos 6 bits e retornando como int
    public int w(int x){
        return x & ((1<<6)-1);
    }

    // ignorando os 13 bits a direita e pagando o resto e retornando como int
    public int t(int x){
        return x >> 13;
    }

    // fazendo uma condicao & logica com o x menos os ultimos 6 bits e
    // comparando esse x >> 6 com os ultimos 7 bits. Retornando int
    public int r(int x){
        return x >> 6 & ((1<<7)-1);
    }

    // ignorando os ultimos 6 bits e retornando int
    public int s(int x){
        return x >> 6;
    }

    // funcao para contar os bits de um int
    public int nbits(int v){
        int cont = 0;
        while (v>0){
            v = v >> 1;
            ++cont;
        }
        return cont-1;
    }
}
