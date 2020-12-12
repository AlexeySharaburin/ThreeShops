import java.util.concurrent.*;
import java.util.concurrent.atomic.LongAdder;

public class Main {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        LongAdder summaDay = new LongAdder();
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        Callable<Integer> shop1 = new ShopCallable("1");
        Callable<Integer> shop2 = new ShopCallable("2");
        Callable<Integer> shop3 = new ShopCallable("3");

        final Future<Integer> summa1 = executorService.submit(shop1);
        summaDay.add(summa1.get());
        final Future<Integer> summa2 = executorService.submit(shop2);
        summaDay.add(summa2.get());
        final Future<Integer> summa3 = executorService.submit(shop3);
        summaDay.add(summa3.get());

        System.out.println("Итоговая сумма, руб.: " + summaDay.sum());

        executorService.shutdown();
    }
}
