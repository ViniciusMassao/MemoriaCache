import java.util.Arrays;

public class Memoria {
    private int size = 0;
    private int [] mem;

    public Memoria(int size) {
        this.size = size;
        this.mem = new int[size];
    }

    public int Size() { return size; }

    public int Get(int address) throws InvalidAddress {
        CheckAddress(address);
        return mem[address];
    }

    public void Set(int address, int word) throws InvalidAddress {
        CheckAddress(address);
        mem[address] = word;
    }

    private void CheckAddress(int address) throws InvalidAddress {
        if (address < 0 || address >= size)
            throw new InvalidAddress(address);
    }

    // funcao para copiar uma parte de uma array, partindo de um indice inicial e dando o indice final para parar
    public int [] copyBlock(int init_address, int end_address){
//        for(int i = init_address; i < end_address; i++) System.out.println("indices do bloco->"+i);
        return Arrays.copyOfRange(mem, init_address, end_address);
    }

    public void setBloco(int[]bloco){mem = bloco;}

    public void serBlocoFromTo(int[]bloco, int init_address, int end_address){

    }
}

class InvalidAddress extends Exception {
    private final int address;

    InvalidAddress() {
        super();
        this.address = -1;
    }

    InvalidAddress(int address) {
        super("invalid address");
        this.address = address;
    }

    public int getAddress() {
        return address;
    }
}