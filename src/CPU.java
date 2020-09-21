public class CPU {
    private CACHE cache = null;
    private IO io = null;
    private int PC = 0;

    public CPU(CACHE c, IO es) {
        cache = c;
        io = es;
    }

    public void Run(int pc_address) throws InvalidAddress {
        // endereco
        PC = pc_address;

        // forcando o endereco a settar um valor diferente pra alterar o modif pra true
        if(pc_address == 8733541){cache.Set(8733541, 10);}

        // imprimindo no dispositivo de entrada e saida
        io.Write("PC -> " + PC+ ", retorno -> " + cache.Get(PC));
    }
}

