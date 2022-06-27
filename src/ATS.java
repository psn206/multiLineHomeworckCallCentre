import java.util.Queue;

public class ATS implements Runnable {
    private final Queue<Integer> callQueue;
    private int numberСalls = 60;
    public int lastBell = 1;
    final static private int CALLS_TO = 1000;
    public ATS(Queue<Integer> callQueue) {
        this.callQueue = callQueue;
        for (int i = callQueue.size(); i < numberСalls; i++) {
            callQueue.add(i);
        }
    }

    @Override
    public void run() {
        while (callQueue.size() > lastBell) {
            try {
                Thread.sleep(CALLS_TO);
                System.out.println("Поступило звонков " + callQueue.size());
                callQueue.add(numberСalls++);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
