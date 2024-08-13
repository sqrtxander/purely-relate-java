package stage;

import gamepanel.GamePanel;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public abstract class Stage extends JPanel {
  final GamePanel gp;

  public Stage(GamePanel inGp) {
    super();
    gp = inGp;
  }
}
