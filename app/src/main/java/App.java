import javax.swing.JFrame;

import gamepanel.GamePanel;
import stage.*;

public class App {
  public static void main(String args[]) {
    JFrame window = new JFrame();
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setResizable(true);
    window.setTitle("Purely Relate");

    GamePanel gamePanel = new GamePanel();
    window.add(gamePanel);
    window.pack();


    window.setLocationRelativeTo(null);
    window.setVisible(true);
  }
}
