public class Main {

    public static void main(String[] args) throws InvalidAddress {
        int TRAM = 16*1024*1024; // tamanho da RAM
        int TCACHE = 8*1024; // tamanho da CACHE

        IO es = new IO(System.out);

        RAM ram = new RAM(TRAM);
        CACHE cache = new CACHE(TCACHE, ram);
        ram.Set(10,120);
        ram.Set(11,127);

        CPU cpu = new CPU(cache, es);
        cpu.Run(10);
    }

}
