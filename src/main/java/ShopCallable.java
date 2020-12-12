import java.util.Random;
import java.util.concurrent.Callable;

public class ShopCallable implements Callable<Integer> {

    private String name;

    public ShopCallable(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private static int size = 100_000;
    private static int[] array = new int[size];

    @Override
    public Integer call() throws Exception {
        int summa = 0;
        int max = 200_000;
        int min = 1;
        try {
            Thread.sleep(5000);
            for (int i = 0; i < (size - 1); i++) {
                Random random = new Random();
                array[i] = random.nextInt(max - min) + min;
                summa += array[i];
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.printf("Выручка из магазина №%s, руб.: %d\n", getName(), summa);
        return (summa);
    }

}
