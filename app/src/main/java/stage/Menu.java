package stage;

import fonthandler.FontHandler;
import gamepanel.GamePanel;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.*;

public class Menu extends Stage {
  Font titleFont =
      FontHandler.customFont("assets/fonts/Oswald/static/Oswald-Regular.ttf", Font.PLAIN, 96);

  public Menu(GamePanel gp) {
    super(gp);
    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    setBackground(Color.WHITE);
  }

  @Override
  public void doLayout() {
    layoutTitle();
    layoutButtons();
    super.doLayout();
  }

  @Override
  public Dimension getPreferredSize() {
    return new Dimension(gp.screenWidth, gp.screenHeight);
  }

  public void layoutTitle() {
    JLabel title = new JLabel("Purely Relate");
    title.setFont(titleFont);
    title.setAlignmentX(CENTER_ALIGNMENT);
    add(title);
  }

  public void layoutButtons() {
    JPanel buttons = new JPanel();
    buttons.setLayout(new GridLayout(4, 1, 10, 10));
    buttons.setBackground(new Color(0, 0, 0, 0));
    Dimension dims = new Dimension(getWidth() * 3 / 4, getHeight() / 2);
    buttons.setPreferredSize(dims);
    addButton("Relations", buttons);
    addButton("Progressions", buttons);
    addButton("Relating Surfaces", buttons);
    addButton("Consonants Only", buttons);
    buttons.setAlignmentX(CENTER_ALIGNMENT);
    add(buttons);
  }

  public void addButton(String label, Container container) {
    JButton button = new JButton(label);
    button.setFont(titleFont.deriveFont(48f));
    container.add(button);
  }
}
