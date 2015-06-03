
package server;

public class Test {
    public static void main(String[] args) {
        new Thread(new ConnectionListener()).start();
    }
}
