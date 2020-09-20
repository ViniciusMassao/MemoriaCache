public class Main {

    public static void main(String[] args) throws InvalidAddress {
        int TRAM = 16*1024*1024; // tamanho da RAM = 16777216 10560325
        int TCACHE = 8*1024; // tamanho da CACHE = 8192

        IO es = new IO(System.out);

        RAM ram = new RAM(TRAM);
        CACHE cache = new CACHE(TCACHE, ram);
        // para inserir a word na RAM o endereco da memoria tem que ser s + w
        // w = 5 que contem a paralavra
        ram.Set(165010,120);
//        ram.Set(11,127);

        CPU cpu = new CPU(cache, es);
        cpu.Run(10560325);
    }
}