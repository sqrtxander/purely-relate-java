package stage;

import gamepanel.GamePanel;
import java.awt.Graphics2D;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Container;
import javax.swing.JButton;
import fonthandler.FontHandler;
import java.awt.Insets;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class Stage extends JPanel {
  final GamePanel gp;
  JLabel titleLabel;
  JButton menuButton;
  Font titleFont =
    FontHandler.customFont("assets/fonts/Oswald/static/Oswald-Regular.ttf", Font.PLAIN, 96);

  public Stage(GamePanel inGp) {
    super();
    gp = inGp;
    setBackground(Color.WHITE);

    if (!(this instanceof Menu)) {
      initMenuButton();
    }
  }

  @Override
  public void doLayout() {
    if (titleLabel != null) {
      doLayoutTitle();
    }
    if (menuButton != null) {
      doLayoutMenuButton();
    }
  }

  @Override
  public Dimension getPreferredSize() {
    return new Dimension(gp.screenWidth, gp.screenHeight);
  }

  public void initTitle(String text) {
    titleLabel = new JLabel(text);
    titleLabel.setFont(titleFont);
    add(titleLabel);
  }

  public void doLayoutTitle() {
    Dimension titleSize = titleLabel.getPreferredSize();
    Dimension panelSize = getSize();
    Insets insets = getInsets();

    int x = insets.left + (panelSize.width - titleSize.width) / 2;
    int y = insets.top;

    titleLabel.setBounds(x, y, titleSize.width, titleSize.height);
  }

  public void initMenuButton() {
    menuButton = new JButton("Menu");
    menuButton.setFont(titleFont.deriveFont(28f));
    menuButton.addActionListener(e -> gp.setStage(new Menu(gp)));
    add(menuButton);
  }

  public void doLayoutMenuButton() {
    Dimension menuSize = menuButton.getPreferredSize();
    Insets insets = getInsets();

    int x = insets.left + 10;
    int y = insets.top + 10;
    int w = menuSize.width;
    int h = menuSize.height;

    menuButton.setBounds(x, y, w, h);

  }

}
