public class Main {

    public static void main(String[] args) throws InvalidAddress {
        int TRAM = 16*1024*1024; // tamanho da RAM = 16777216 10560325
        int TCACHE = 8*1024; // tamanho da CACHE = 8192

        IO es = new IO(System.out);

        RAM ram = new RAM(TRAM);
        CACHE cache = new CACHE(TCACHE, ram);
        // para inserir a word na RAM o endereco da memoria tem que ser s + w
        // w = 5 que contem a palavra 120
        ram.Set(10560325,120);
        // cache hit
        ram.Set(10560327,200);
        // exemplo quando o t e o t' sao diferentes e com o modif setado pra true
        ram.Set(8733541,50);

        CPU cpu = new CPU(cache, es);
        cpu.Run(10560325);
        cpu.Run(10560327);
        cpu.Run(8733541);
    }
}