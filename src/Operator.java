import java.util.Queue;

public class Operator implements Runnable {
    final Queue<Integer> callQueue;
    final private Thread atsCall;
    final private int CONVERSATION_OPERATOR = 3000;

    public Operator(Queue<Integer> callQueue, Thread atsCall) {
        this.callQueue = callQueue;
        this.atsCall = atsCall;
    }

    @Override
    public void run() {
        while (atsCall.isAlive()) {
            try {
                Thread.sleep(CONVERSATION_OPERATOR);
                System.out.println(Thread.currentThread().getName() + " принял звонок от абонента " + callQueue.poll());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
