import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

public class CACHE {
    private int qtn;
    private RAM ram;
    public Map<Integer, String> memoria = new HashMap<Integer, String>();


    public CACHE(int tamanho, RAM ram){
        this.ram = ram;
        this.qtn = tamanho;
    }

    public String Get(int ender){
        String outputString = memoria.get(ender);
        memoria.remove(ender);
        return outputString;
    }

    public void Set(int ender, int palavra){
        this.ram.Set(ender,palavra);
    }

    public int Qnt(){ return this.qtn;}
}
