import java.text.MessageFormat;
import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
    private BlockingQueue<PCData> queue; // 缓冲区
    private static final int SLEEPTIME = 1000;

    public Consumer(BlockingQueue<PCData> queue) {
        this.queue = queue;
    }

    public void run() {
        System.out.println("start Consumer id=" + Thread.currentThread().getId());
        Random r = new Random(); // 随机等待时间

        try {
            while(true) {
                PCData data = queue.take(); // 提取任务
                System.out.println("===");
                if (null != data) {
                    int re = data.getData() * data.getData();
                    System.out.println(MessageFormat.format("{0}*{1}={2}", data.getData(), data.getData(), re));
                    Thread.sleep(r.nextInt(SLEEPTIME));
                } else {
                    // queue.take() 如果取不到缓存队列中的资源，就会执行await()形成阻塞
                    System.out.println("消费者等待资源………………");
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }
}
