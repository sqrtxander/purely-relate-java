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
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class Menu extends Stage {
  JPanel buttonsPanel;

  public Menu(GamePanel gp) {
    super(gp);
    setLayout(null);
    initTitle("Purely Relate");
    initMenuButtons();
  }

  @Override
  public void doLayout() {
    doLayoutMenuButtons();
    super.doLayout();
  }

  public void initMenuButtons() {
    buttonsPanel = new JPanel();
    buttonsPanel.setLayout(new GridLayout(4, 1, 10, 10));
    buttonsPanel.setBackground(null);
    addButton("Relations", buttonsPanel, new Relations(gp));
    addButton("Progressions", buttonsPanel, new Progressions(gp));
    addButton("Relating Surfaces", buttonsPanel, null);
    addButton("Consonants Only", buttonsPanel, null);
    add(buttonsPanel);
  }

  public void doLayoutMenuButtons() {
    Dimension panelSize = getSize();
    Insets insets = getInsets();

    int topStart = insets.top + titleLabel.getPreferredSize().height;
    int remHeight = panelSize.height - topStart;

    int w = panelSize.width * 3 / 4;
    int h = panelSize.height /2;
    int x = insets.left + panelSize.width/8;
    int y = topStart + (remHeight - h) / 2;

    buttonsPanel.setBounds(x, y, w, h);
  }

  public void addButton(String label, Container container, Stage stage) {
    JButton button = new JButton(label);
    button.setFont(titleFont.deriveFont(48f));
    if (stage != null) {
      button.addActionListener(e -> gp.setStage(stage));
    }
    container.add(button);
  }
}
