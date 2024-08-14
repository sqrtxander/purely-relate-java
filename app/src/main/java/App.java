import javax.swing.JFrame;

import gamepanel.GamePanel;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import stage.*;

public class App {
  public static void main(String args[]) {
    JFrame window = new JFrame();
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setLayout(new BorderLayout());
    window.setResizable(true);
    window.setTitle("Purely Relate");

    GamePanel gamePanel = new GamePanel();
    window.add(gamePanel, BorderLayout.CENTER);
    window.pack();


    window.setLocationRelativeTo(null);
    window.setVisible(true);
  }
}
