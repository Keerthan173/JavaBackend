public class TimeoutDemo {

    // Method that finishes within short time
    public void shortWait() {
        try {
            Thread.sleep(200); // 200ms
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    // Method that takes too long
    public void longWait() {
        try {
            Thread.sleep(3000); // 3 seconds
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
