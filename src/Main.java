import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Main {

    public static void main(String[] args) {
        Queue<Integer> callQueue = new ConcurrentLinkedQueue<>();
        final int NUMBER_OPERATOR = 3;
        Thread atcCall = new Thread(null, new ATS(callQueue), "АТС");
        atcCall.start();
        List<Thread> operators = new ArrayList<>();
        for (int i = 0; i < NUMBER_OPERATOR; i++) {
            operators.add(new Thread(null, new Operator(callQueue, atcCall), "Оператор" + (i + 1)));
            operators.get(i).start();
        }
    }
}
