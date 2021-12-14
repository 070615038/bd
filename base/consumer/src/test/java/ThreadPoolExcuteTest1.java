import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExcuteTest1 {
    static  int j =0;
    public static void main(String[] args) {

        ThreadPoolExecutor threadpool = new ThreadPoolExecutor(2,4,10,
                TimeUnit.SECONDS,new LinkedBlockingQueue<>(5),new ThreadPoolExecutor.CallerRunsPolicy());
        System.out.println(Runtime.getRuntime().availableProcessors());
        for (int i = 0; i < 10; i++) {
            threadpool.execute(new Runnable() {


                @Override
                public void run() {
                    try {
                        Thread.sleep(10*1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+j++);
                }
            });
        }
    }


}
