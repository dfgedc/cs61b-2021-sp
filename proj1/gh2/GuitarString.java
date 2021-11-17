package gh2;

import deque.*;


public class GuitarString {
     private static final int SR = 44100;
    private static final double DECAY = .996;



    // TODO: uncomment the following line once you're ready to start this portion
    private Deque<Double> buffer;

    public GuitarString(double frequency) {
        buffer = new LinkedListDeque<Double>();
        int capactity = (int) (SR/frequency);
        for (int i = 0; i < capactity; i++) {
           buffer.addLast(0.0);
        }
    }


    public void pluck() {
           for (int i = 0; i < buffer.size(); i++) {
            buffer.removeFirst();
            buffer.addLast(Math.random() - 0.5);
        }


    }

    public void tic() {
            double first = buffer.removeFirst();
        double second = buffer.get(0);
         double three  =  DECAY *(0.5*(first+second));
         buffer.addLast(three);
    }

    public double sample() {
        return buffer.get(0);
    }
}
