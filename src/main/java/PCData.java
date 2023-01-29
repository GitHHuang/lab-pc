import java.util.Random;

public final class PCData {

    private final int intData; // 任务相关数据

    public PCData(int d) {
        intData = d;
    }

    public PCData(String d) {
        intData = Integer.valueOf(d);
    }

    public int getData() {
        return intData;
    }

    @Override
    public String toString() {
        return "data:" + intData;
    }


    public static void main(String[] args) {
        Random r = new Random();
        int a = r.nextInt();
        double b = r.nextDouble();
        System.out.println(a);
        System.out.println(b);
    }
}
