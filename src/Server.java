import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

//timepublisher same deal
public class Server extends JFrame implements IReceive{
    String messages; //stores chat messages
    Client[] clients = new Client[5];
    int index = 0;
    Timer timer = new Timer(600, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            //Every 0.6 Seconds, update message in chatbox
            update();
        }
    });
    public Server(){
        messages = "Server: \n";
        timer.start();
    }

    @Override
    public String receive(String _messageOut) {
        messages += _messageOut;
        return messages;
    }

    public String getMessages(){
        return messages;
    }

    public void update(){
        for(Client c: clients) {
            if(c!=null)
            c.receive(messages);
        }
    }

    public void add(Client k){
        if(index < 5){
            clients[index] = k;
            index++;
        } else {
            System.out.println("Error, too many people to add!");
        }

    }
}
