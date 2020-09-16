public class atvidade02 {
    public static void main(String[] args) {
        IO es = new IO(System.out);
        RAM ram = new RAM(128);
        CACHE cache = new CACHE(3, ram);
        CPU cpu = new CPU(es, cache, ram);

        cache.Set(0,120);
        cache.Set(1,127);
        cache.Set(2,100);
        cache.Set(3,50);
        cache.Set(4, 90);
        cache.Set(5, 10);

        cpu.run();
    }
}
