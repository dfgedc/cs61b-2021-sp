package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeAList {


    public static void main(String[] args) {
        timeAListConstruction();
        //printTimingTable();
    }

    public static void timeAListConstruction() {
        // TODO: YOUR CODE HERE
   //     System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
     //   System.out.printf("------------------------------------------------------------\n");
       // Stopwatch sw = new Stopwatch();
        AList<Integer> Ns = new AList();
        AList<Double> times = new AList<>();
        AList<Integer> opCounts = new AList<>();
        double time;
     /*  for(int i =1000;i<=128000;i = i *2){
            for (int j = 0; j <=1 ; j++) {
                Ns.addLast(j);
            }
            time = sw.elapsedTime();
            times.addLast(time);
        }
*/
        System.out.println("Timing table for addLast");

     //   for (int i = 1000; i <=128000 ; i*=2) {
         //   for (int j = 0; j < i; j++) {
    //            Ns.addLast(i);
        //    }
       //     time = sw.elapsedTime();
         //   times.addLast(time);
         //   opCounts.addLast(i);
     //   }
  /*     int length = 1;
        for (int i = 10000; i <=128000 ; i*=2) {
            length +=1;
            Ns.addLast(length);
            AList<Integer>  testAList = new AList<>();
            //sw = new Stopwatch();
            for (int j = 0;j<length;i++){
                testAList.addLast(1);
            }
            double timeInSeconds = sw.elapsedTime();
            times.addLast(timeInSeconds);
            opCounts.addLast(length);
        }
        */
       // int testAListLength = 1000;
        for (int p = 1000; p <= 128000; p*=2) {
         //   if (p > 0) {
          //      testAListLength *= 2;
          //  }
            Ns.addLast(p);
            AList<Integer> testAList = new AList<>();
            Stopwatch sw = new Stopwatch();
            for (int i = 0; i < p; i++) {
                testAList.addLast(1);
            }
            double timeInSeconds = sw.elapsedTime();
            times.addLast(timeInSeconds);
            opCounts.addLast(p);
        }
     //   printTimingTable(Ns, times, opCounts);
        printTimingTable(Ns,times,opCounts);
    }
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }
}
