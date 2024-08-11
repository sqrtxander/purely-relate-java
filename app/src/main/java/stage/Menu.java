package stage;

import fonthandler.FontHandler;
import gamepanel.GamePanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;

public class Menu implements Stage {
  final GamePanel gp;
  Font titleFont =
      FontHandler.customFont("assets/fonts/Oswald/static/Oswald-Regular.ttf", Font.PLAIN, 96);

  public Menu(GamePanel inGp) {
    gp = inGp;
  }

  @Override
  public void update() {}

  @Override
  public void paint(Graphics2D g2) {
    drawTitle(g2);
  }

  private void drawTitle(Graphics2D g2) {
    String title = "Purely Relate";

    FontMetrics fm = g2.getFontMetrics(titleFont);
    int width = fm.stringWidth(title);
    int ascent = fm.getAscent();

    int x = (gp.getWidth() - width) / 2;
    int y = ascent + 100;

    g2.setFont(titleFont);
    g2.setColor(Color.BLACK);
    g2.drawString(title, x, y);
  }
}
