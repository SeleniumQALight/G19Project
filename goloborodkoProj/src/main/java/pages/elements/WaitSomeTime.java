package pages.elements;

public class WaitSomeTime {
    public static void seconds(int timeSec) {
        try {
            Thread.sleep(timeSec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
