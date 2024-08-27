package stage;

import components.ClueLabel;
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
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.BorderLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;


public class Relations extends Stage {
  public static int CLUECOUNT = 4;
  int cluesFlipped = 0;

  // clues
  List<String> clues = List.of("Clue 1", "Clue2 is this the real life, is this just fantasy hammer and a feather", "Clue3", "Clue4");
  List<ClueLabel> cluesLabels;
  JPanel cluesPanel;

  // answer
  ClueLabel answerLabel;
  //JPanel answerPanel;

  // gui buttons
  JPanel buttonsPanel;



  public Relations(GamePanel gp) {
    super(gp);
    setLayout(null);
    initQuestion();
    initButtons();
    initTitle("Relations");
  }

  public void nextClue() {
    if (cluesFlipped >= CLUECOUNT) {
      return;
    }
    cluesLabels.get(cluesFlipped++).flip();
  }

  public void revealAnswer() {
    answerLabel.flip();
  }

  public void reset() {
    while (cluesFlipped > 0) {
      cluesLabels.get(--cluesFlipped).unflip();
    }
    answerLabel.unflip();
  }

  @Override
  public void doLayout() {
    doLayoutQuestion();
    doLayoutButtons();
    super.doLayout();
  }

  public void initQuestion() {
    cluesLabels = new ArrayList<ClueLabel>();
    cluesPanel = new JPanel(new GridLayout(1, CLUECOUNT, 10, 10));

    for (int i = 0; i < CLUECOUNT; i++) {
      ClueLabel clueLabel = new ClueLabel(clues.get(i));
      cluesPanel.add(clueLabel);
      cluesLabels.add(clueLabel);
    }
    cluesPanel.setBackground(null);

    add(cluesPanel);
    //answerPanel = new JPanel(new GridLayout(1, 1));
    answerLabel = new ClueLabel("TESTING TESTING 123");
    //answerPanel.add(answerLabel);

    add(answerLabel);
  };

  public void initButtons() {
    buttonsPanel = new JPanel(new GridLayout(3, 1, 10, 10));
    addButton("Next please", buttonsPanel, () -> nextClue());
    addButton("Reveal Answer", buttonsPanel, () -> revealAnswer());
    addButton("", buttonsPanel, () -> reset());
    buttonsPanel.setBackground(null);
    add(buttonsPanel);
  }

  public void addButton(String label, Container container, Runnable action) {
    JButton button = new JButton(label);
    button.setFont(titleFont.deriveFont(24f));
    button.addActionListener(e -> action.run());
    container.add(button);
  }

  public void doLayoutQuestion() {
    Dimension panelSize = getSize();
    Insets insets = getInsets();

    int topStart = insets.top + titleLabel.getSize().height;
    int remHeight = panelSize.height - topStart;

    double clueAspectRatio = 5.0 / 3.0;
    int w = panelSize.width * 9 / 10;
    int h = (int)((w - 10 * (CLUECOUNT -1 ))/ CLUECOUNT / clueAspectRatio);
    int x = insets.left + panelSize.width/20;
    int y = panelSize.height * 9/10 - h * 3/2;

    cluesPanel.setBounds(x, y, w, h);

    y += h + 10;
    h /= 2;
    answerLabel.setBounds(x, y, w, h);
  };

  public void doLayoutButtons() {
    Dimension panelSize = getSize();
    Insets insets = getInsets();

    int topStart = insets.top + titleLabel.getHeight();
    int remHeight = panelSize.height - topStart;

    double buttonAspectRatio = 8.0 / 1.0;
    int h = panelSize.height * 2/10;
    int w = (int)((h - 10 * (3 - 1)) / 3 * buttonAspectRatio);
    int x = insets.left + (panelSize.width - w) / 2;
    int y = topStart + remHeight / 20;

    buttonsPanel.setBounds(x, y, w, h);
  }

}
