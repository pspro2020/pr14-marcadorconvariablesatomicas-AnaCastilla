import java.util.concurrent.atomic.AtomicIntegerArray;

public class Dice {

    private AtomicIntegerArray atomicIntegerArray;

    public Dice(int num) {
        atomicIntegerArray = new AtomicIntegerArray(num);
    }

    public int throwDice(int num, int times) {
        return atomicIntegerArray.addAndGet(num, times);
    }

    public int getNumber(int num) {
        return atomicIntegerArray.get(num);
    }

    public void showNumbers() {
        int totalTimes = 0;
        for (int i = 0; i < 6; i++) {
            System.out.printf("\nNumber %d: %d times\n", i+1, getNumber(i));
            totalTimes += getNumber(i);
        }

        System.out.printf("\nTotal: %d + %d + %d + %d + %d + %d = %d\n", getNumber(0), getNumber(1),
                getNumber(2), getNumber(3), getNumber(4), getNumber(5), totalTimes);
    }


}
