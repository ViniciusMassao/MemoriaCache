public class CPU {
//    private int PC = 0;
    private CACHE cache;
    private RAM ram;
    private IO es;

    public CPU(IO es, CACHE cache, RAM ram){
        this.es = es;
        this.cache = cache;
        this.ram = ram;
    }

    public void run(){
        for(int PC = 0; PC < ram.Size(); PC++){
            try {
                if(cache.memoria.isEmpty())
                    for(int i = PC; i <= ram.Size(); i++){
                        if(cache.memoria.size() == cache.Qnt()) break;
                        if(ram.Get(i) != null)
                            cache.memoria.put(i, ram.Get(i));
                    }
                else if(!cache.memoria.containsKey(PC) && ram.Get(PC) != null)
                    cache.memoria.put(PC, ram.Get(PC));

                if(cache.memoria.containsKey(PC))
                    es.write(cache.Get(PC));
                System.out.println("Final cache = "+cache.memoria+", PC = "+PC);
            }catch (Exception e){
//                es.write("Nao foi possivel acessar posicao de memoria");
            }
        }
    }
}
