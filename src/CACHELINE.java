public class CACHELINE {
    private int tag = -1; // tag inicial pra quando nao tem nada
    private boolean modif = false;
    private Memoria [] bloco;

    public CACHELINE(){};

    public CACHELINE(int size_bloco, int address_bloco){
        this.bloco = new Memoria[size_bloco];
        this.tag = address_bloco;
    }

    public int getTag() {return tag;}

    public void setTag(int tag) {this.tag = tag;}

    public boolean isModif() {return modif;}

    public void setModif(boolean modif) {this.modif = modif;}

    public Memoria[] getBloco() {return bloco;}

    public void setBloco(Memoria[] bloco) {this.bloco = bloco;}
}
