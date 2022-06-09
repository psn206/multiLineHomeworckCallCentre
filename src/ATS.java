import java.util.Queue;

public class ATS implements Runnable {
    final private Queue<Integer> callQueue;
    final public int numberСalls = 60;
    public int timeWorck = 20;
    final public int CALLS_TO = 1000;

    public ATS(Queue<Integer> callQueue) {
        this.callQueue = callQueue;
    }

    @Override
    public void run() {
        while (timeWorck > 0) {
            try {
                Thread.sleep(CALLS_TO);
                System.out.println(" Поступило звонков " + numberСalls);
                for (int i = callQueue.size(); i < numberСalls; i++) {
                    callQueue.add(i);
                }
                timeWorck--;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
