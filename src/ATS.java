import java.util.Queue;

public class ATS implements Runnable {
    final private Queue<Integer> callQueue;
    private int numberСalls = 60;
    public int lastBell = 1;
    final private int callsTo = 1000;

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
                Thread.sleep(callsTo);
                System.out.println("Поступило звонков " + callQueue.size());
                callQueue.add(numberСalls++);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
