import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Main {

    public static void main(String[] args) {
        Queue<Integer> callQueue = new ConcurrentLinkedQueue<>();
        final int numberOperator = 10;
        Thread atcCall = new Thread(null, new ATS(callQueue), "АТС");
        atcCall.start();
        List<Thread> operators = new ArrayList<>();
        for (int i = 0; i < numberOperator; i++) {
            operators.add(new Thread(null, new Operator(callQueue), "Оператор" + (i + 1)));
            operators.get(i).start();
        }
    }
}
