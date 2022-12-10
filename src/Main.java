import java.util.ArrayList;

public class Main {
    static Server server = new Server(); //can only have 1 server
    public static void main(String[] args) {

        Client a = new Client("User 1", server);
        Client b = new Client("User 2", server);
        Client c = new Client("User 3", server);
        Client d = new Client("User 4", server);
        Client e = new Client("User 5", server);
        a.setFrameLocation(0, 0);
        b.setFrameLocation(0, 200);
        c.setFrameLocation(0, 375);
        d.setFrameLocation(600, 0);
        e.setFrameLocation(600, 200);

        server.add(a);
        server.add(b);
        server.add(c);
        server.add(d);
        server.add(e);
    }
}