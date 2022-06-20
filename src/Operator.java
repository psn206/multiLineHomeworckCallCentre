import java.util.Queue;

public class Operator implements Runnable {
    final private Queue<Integer> callQueue;

    private Integer numberCall;
    final private int CONVERSATION_OPERATOR = 3000;

    public Operator(Queue<Integer> callQueue) {
        this.callQueue = callQueue;
    }

    @Override
    public void run() {
        while (callQueue.size() > 0) {
            try {
                numberCall = callQueue.poll();
                Thread.sleep(CONVERSATION_OPERATOR);
                if (numberCall != null) {
                    System.out.println(Thread.currentThread().getName() + ": принял звонок от абонента " + numberCall);
                } else {
                    System.out.println(Thread.currentThread().getName() + ":звонков для обработки больше нет.");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
