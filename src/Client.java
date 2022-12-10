import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Client extends JFrame implements ISend, IReceive, ActionListener{
    String name;
    String message;
    Server server;
    JFrame frame = new JFrame("Unnamed Frame");


    JTextField messageField = new JTextField(); //area to type messages
    JTextArea textField = new JTextArea(); //area to view all server messages

    public Client(String _name, Server _server){
        name = _name;
        server = _server;

        frame.setTitle(name);
        frame.setSize(600, 175);//server.index * 200); //each frame title is 25 pixels tall

        JButton myButton = new JButton("Send");
        messageField = new JTextField(12);
        textField = new JTextArea(8, 8);
        textField.setText(server.messages);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);

        myButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                message = messageField.getText();
                message += "\n";
                //System.out.println(message);  //debug step
                send(name, message);
                //server.receive(message); //if the server receives the message, call a notify or update command to update the text for everyone
            }
        });

        myButton.setForeground(Color.blue);

        frame.add(messageField);
        frame.add(myButton);
        frame.add(textField);
        textField.setEditable(false);

        frame.setLayout(new FlowLayout());
        frame.setVisible(true);
    }

    public void setTitle(String title){
        frame.setTitle(title);
    }

    @Override
    public void send(String sender, String _message) {
        String messageOutput = sender + ": " + _message;
        textField.setText(server.receive(messageOutput));
    }

    @Override
    public String receive(String messageOut) {
        textField.setText(server.getMessages());
        return messageOut;
    }

    public void setFrameLocation(int x, int y){
        frame.setLocation(x, y);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
