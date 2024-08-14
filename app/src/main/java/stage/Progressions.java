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
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class Progressions extends Stage {
  List<String> clues = List.of("Clue 1", "Clue2", "Clue3", "Clue4");


  public Progressions(GamePanel gp) {
    super(gp);
    initTitle("Progressions");
  }

  @Override
  public void doLayout() {
    super.doLayout();
  }
}
