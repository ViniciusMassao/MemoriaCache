public class atividade01 {
//    private static int n = 2000000;
//    private static int i = 0;
    private static double billion = 1000000000;

    public static void main(String[] args) {
//        long t0 = System.nanoTime();
//        for(i = 0; i < n; ++i) System.out.print("x");
//        long t_final = System.nanoTime() - t0;
//        System.out.print("\n"+"tempo " + t_final/1e9);

        double sum = 0.0;
        double num = 1.0;
        double i2 = 0.0;
        long t0 = System.nanoTime();
        for(long i = 0; i < billion; ++i){
            i2 = 2*i;
            sum += num / ((i2+2)*(i2+3)*(i2+4));
            num = -num;
        }
        sum *= 4;
        sum += 3;
        long t_final = System.nanoTime() -t0;

        System.out.println("Pi = "+ sum);

        System.out.println("tempo = "+t_final/1e9);



    }
}
