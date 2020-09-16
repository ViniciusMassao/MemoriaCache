public class IO {
    private java.io.PrintStream out = null;

    public IO(java.io.PrintStream o) { out = o;	}
    public void write(String s) {
        out.println(s);
    }
}
