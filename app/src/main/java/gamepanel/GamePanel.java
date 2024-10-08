package gamepanel;

import fonthandler.*;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.BorderLayout;

import javax.swing.*;
import stage.*;

public class GamePanel extends JPanel {
  public final int screenWidth = 1280;
  public final int screenHeight = 720;

  Stage stage;

  public GamePanel() {
    setLayout(new BorderLayout());
    setBackground(Color.BLACK);

    stage = new Menu(this);
    add(stage, BorderLayout.CENTER);
    revalidate();
    repaint();
  }

  @Override
  public Dimension getPreferredSize() {
    return new Dimension(screenWidth, screenHeight);
  }

  public void setStage(Stage inStage) {
    remove(stage);
    stage = inStage;
    add(stage);
    revalidate();
  }
}
