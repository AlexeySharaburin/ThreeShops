import java.util.Random;
import java.util.concurrent.atomic.LongAdder;

public class Shop {

    private LongAdder summaDay;

    public Shop(LongAdder summaDay) {
        this.summaDay = summaDay;
    }

    private static int size = 100_000;
    private static int[] array = new int[size];

    public void calculate() {
        int summa = 0;
        int max = 200_000;
        int min = 1;
        try {
            for (int i = 0; i < (size - 1); i++) {
                Random random = new Random();
                array[i] = random.nextInt(max - min) + min;
                summa += array[i];
            }
            summaDay.add(summa);
            System.out.printf("Выручка из магазина №%s, руб.: %d\n", Thread.currentThread().getName(), summa);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



