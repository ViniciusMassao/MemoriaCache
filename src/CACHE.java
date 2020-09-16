public class CACHE extends Memoria{
    private int []cache = null;
    private RAM ram = null;
    private int init_addr = -1; // endereco inicial da RAM mapeado (-1 = nada mapeado)

    public CACHE(int size, RAM ram){
        super(size);
        cache = new int[size];
        this.ram=ram;
    }

    public int Get(int address) throws InvalidAddress{
        if(!IsMapped(address)) this.Map(address);
        return cache[address-init_addr];
    }

    public void Set(int address, int word) throws InvalidAddress{
        ram.Set(address,word);
    }

    private boolean IsMapped(int address){
        // apenas retornando qualquer coisa pra nao ficar danddo erro
        return true;
    }

    private void Map(int address) throws InvalidAddress{
        // implementar
    }
}
