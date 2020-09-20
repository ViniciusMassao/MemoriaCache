import java.util.ArrayList;

public class CACHE{
    // CACHE é composta por uma arraylist de CACHELINE
    private CACHELINE[]mem;
    private RAM ram = null;
    private int r_index = 0;
    private int K = 64; // tamanho bloco

    public CACHE(){};

    // inicializando a mem da CACHE com um tamanho limitado
    public CACHE(int size, RAM ram){
        this.mem = new CACHELINE[size];
        this.ram = ram;
    }

    // preenchendo dados de uma CACHELINE
    public void insertCacheLine(int size_bloco, int address_bloco){
        int t_tag = t(address_bloco);
        int r_address = r(address_bloco);
        int s_address = s(address_bloco);
        // criando no indice(index) uma nova instancia de CACHELINE com endereco inicial e tamanho do bloco de memoria
        mem[r_address] = new CACHELINE(size_bloco, t_tag); // recebendo o tamanho do bloco e a tag(t)
        // inserindo na cache line de index x um bloco de memoria copiado da RAM tendo
        // um endereco inicial(s_address) e final(s_address+size_bloco)
        mem[r_address].setBloco(ram.copyBlock(s_address, (s_address+size_bloco)));
    }

    public int getR_index(){return this.r_index;}

    // funcao para settar valores na cache
    public void Set(int address, int word){
        //
    }

    public int Get(int address) throws InvalidAddress{
        // r de address
        int r_address = r(address);
        // w de address
        int w_address = w(address);
        // caso nao tenha o bloco do endereco pedido em cache, entao devera buscar na RAM o bloco e inserir
        // na CACHE o bloco e retornar o valor pedido pela CPU
        if(mem[r_address] == null){
            insertCacheLine(K, address);
            return mem[r_address].getWord(w_address);
        }
        // caso a tag da cacheline e a tag do endereco estejam iguais, e modif eh falso
        // retornar dado pra CPU
        else if(mem[r_address].getTag() == t(address) && !mem[r_address].getModif()){ // cache hit
            return mem[r_address].getWord(w_address);
        }
        
        return 0;
    }
    public CACHELINE[] getMem() {return mem;}

    public void setMem(CACHELINE[] mem) {this.mem = mem;}

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
