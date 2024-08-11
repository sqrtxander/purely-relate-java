package stage;

import gamepanel.GamePanel;
import java.awt.Graphics2D;

public interface Stage {
  GamePanel gp = null;

  void update();

  void paint(Graphics2D g2);
}
