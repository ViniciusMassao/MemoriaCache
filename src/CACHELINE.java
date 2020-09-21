public class CACHELINE {
    private int tag = -1; // tag inicial pra quando nao tem nada
    private boolean modif = false;
    private Memoria bloco = null;

    public CACHELINE(){};

    public CACHELINE(int size_bloco, int tag){
        this.bloco = new Memoria(size_bloco);
        this.tag = tag;
    }

    // funcao para alterar o valor do um indice do bloco e alterando o modif pra true
    // dizendo que tem modificacao na CACHE pra fazer na RAM
    public void SetValor(int address, int word)throws InvalidAddress{
        this.modif = true;
        this.bloco.Set(address, word);
    }

    public int getTag() {return tag;}

    public void setTag(int tag) {this.tag = tag;}

    public boolean getModif() {return modif;}

    public void setModif() {this.modif = !modif;}

    public Memoria getBloco() {return bloco;}

    // settando uma array pro bloco de memoria da CACHE LINE
    public void setBlocoCacheLine(int[] bloco) {
        Memoria new_mem = new Memoria(bloco.length);
        new_mem.setBloco(bloco);
        this.bloco = new_mem;
    }

    // realizando um get na Memoria, para pegar uma determinada word
    public int getWord(int index) throws InvalidAddress{
        return this.bloco.Get(index);
    }
}
