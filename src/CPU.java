public class CPU {
    private CACHE cache = null;
    private IO io = null;
    private int PC = 0;
    private int K = 64; // tamanho bloco

    public CPU(CACHE c, IO es) {
        cache = c;
        io = es;
    }

    public void Run(int pc_address) throws InvalidAddress {

//        PC = pc_address;
//        int iaddr = cache.Get(PC++);
//        int faddr = cache.Get(PC);
//
//        for (int i=iaddr; i<=faddr; ++i) {
//            cache.Set(i, i - iaddr + 1);
//            io.Write(i + " -> " + cache.Get(i));
//        }
    }
}

