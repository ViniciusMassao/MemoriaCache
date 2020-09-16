public class RAM {
    private String[] memoria;
    private int qtn;

    public RAM(int qtn){
        memoria = new String[qtn];
        this.qtn = qtn;
    }

    public void Set(int ender, int palavra){
        memoria[ender] = String.valueOf(palavra);
    }

    public String Get(int ender){return memoria[ender];}

    public int Size(){ return this.qtn; }
}
