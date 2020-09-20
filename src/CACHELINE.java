public class CACHELINE {
    private int tag = -1; // tag inicial pra quando nao tem nada
    private boolean modif = false;
    private Memoria bloco = null;

    public CACHELINE(){};

    public CACHELINE(int size_bloco, int tag){
        this.bloco = new Memoria(size_bloco);
        this.tag = tag;
    }

    public int getTag() {return tag;}

    public void setTag(int tag) {this.tag = tag;}

    public boolean getModif() {return modif;}

    public void setModif(boolean modif) {this.modif = modif;}

    public Memoria getBloco() {return bloco;}

    public void setBloco(int[] bloco) {
        Memoria new_mem = new Memoria(bloco.length);
        new_mem.setBloco(bloco);
        this.bloco = new_mem;
    }

    public int getWord(int index) throws InvalidAddress{
        return bloco.Get(index);
    }
}
