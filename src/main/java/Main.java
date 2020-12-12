import java.util.concurrent.atomic.LongAdder;

public class Main {


    public static void main(String[] args) throws InterruptedException {

        LongAdder summaDay = new LongAdder();

        Shop shop1 = new Shop(summaDay);
        Shop shop2 = new Shop(summaDay);
        Shop shop3 = new Shop(summaDay);

        Thread thread1 = new Thread(null, shop1::calculate, "1");
        Thread thread2 = new Thread(null, shop2::calculate, "2");
        Thread thread3 = new Thread(null, shop3::calculate, "3");

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();

        System.out.println("Итоговая сумма, руб.: " + summaDay.sum());

    }
}
