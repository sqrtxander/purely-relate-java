package gamepanel;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;
import stage.*;

public class GamePanel extends JPanel implements Runnable {
  public final int screenWidth = 1280;
  public final int screenHeight = 720;

  int fps = 30;

  Stage stage;

  Thread gameThread;

  public GamePanel() {
    setPreferredSize(new Dimension(screenWidth, screenHeight));
    stage = new Menu(this);
  }

  public void startGameThread() {
    gameThread = new Thread(this);
    gameThread.start();
  }

  @Override
  public void run() {
    double drawInterval = 1000000000 / fps;
    double nextDrawTime = System.nanoTime() + drawInterval;

    while (gameThread != null) {
      update();
      repaint();

      // fps handling
      try {
        double remainingTime = nextDrawTime - System.nanoTime();
        remainingTime /= 1000000;
        remainingTime = remainingTime < 0 ? 0 : remainingTime;

        Thread.sleep((long) remainingTime);

        nextDrawTime += drawInterval;
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  public void update() {
    stage.update();
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    stage.paint((Graphics2D) g);
  }
}
