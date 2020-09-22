public class CACHE{
    // CACHE é composta por uma arraylist de CACHELINE
    private CACHELINE[]mem;
    private RAM ram = null;
    private int K = 64; // tamanho bloco

    public CACHE(){};

    // inicializando a mem da CACHE com um tamanho limitado
    public CACHE(int size, RAM ram){
        this.mem = new CACHELINE[size];
        this.ram = ram;
    }

    // preenchendo dados de uma CACHELINE
    public void insertCacheLine(int size_bloco, int address_bloco){
        // t de address
        int t_tag = t(address_bloco);
        // r de address
        int r_address = r(address_bloco);
        // s de address
        int s_address = init_address_bloco(address_bloco);

        // criando no indice(index) uma nova instancia de CACHELINE com endereco inicial e tamanho do bloco de memoria
        mem[r_address] = new CACHELINE(size_bloco, t_tag); // recebendo o tamanho do bloco e a tag(t)

        // inserindo na cache line de index x um bloco de memoria copiado da RAM tendo
        // um endereco inicial(s_address) e final(s_address+size_bloco)
        mem[r_address].setBlocoCacheLine(ram.copyBlock(s_address, (s_address+size_bloco)));
    }

    // funcao para settar valores na cache
    public void Set(int address, int word)throws InvalidAddress{
        // r de address
        int r_address = r(address);
        // w de address
        int w_address = w(address);
        // settando a word no indice da word
        mem[r_address].SetValor(w_address, word);
    }

    public int Get(int address) throws InvalidAddress{
        // r de address
        int r_address = r(address);
        // w de address
        int w_address = w(address);

        // caso nao tenha o bloco do endereco pedido em cache, entao devera buscar na RAM o bloco e inserir
        // na CACHE e retornar o valor pedido pela CPU
        if(mem[r_address] == null){
            insertCacheLine(K, address);
        }

        // caso t do endereco pedido pela CPU for diferente do t que esta na CACHE, a CACHE precisa inserir na RAM
        // o bloco(atualizar) e retornar o dado para CPU
        else if(mem[r_address].getTag() != t(address) && mem[r_address].getModif()){
            int init_address = init_address_bloco(address);
            // copiando da CACHE para a RAM o bloco
            for(int i = 0; i < K; i++)
                ram.Set(init_address+i, mem[r_address].getWord(i));
        }
        // caso ele passe por tudo sem entrar em nenhum if ele dah cache hit
        return mem[r_address].getWord(w_address);
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

    // funcao que devolve o inicio do bloco dado um endereco pedido pela CPU
    public int init_address_bloco(int address_bloco){
        // adicionando s+000000 para pegar o endereco inicial do bloco
        String s_address_binary = Integer.toBinaryString(s(address_bloco));
        int s_address_int = Integer.parseInt(s_address_binary,2);
        String init_address_bloco = Integer.toBinaryString(s_address_int << 6);
        int s_address = Integer.parseInt(init_address_bloco,2);
        return s_address;
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
