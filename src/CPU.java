public class CPU {
    private CACHE cache = null;
    private IO io = null;
    private int PC = 0;

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
        PC = pc_address;
        io.Write("PC -> " + PC+ ", retorno -> " + cache.Get(PC));
    }
}

