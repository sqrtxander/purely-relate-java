package fonthandler;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;

public class FontHandler {
  public static String mainFont = "assets/fonts/bahnschrift.ttf";

  public static Font customFont(String path, int style, int point) {
    try {
      File fontFile = new File(path);
      Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);

      return font.deriveFont(style, point);
    } catch(IOException | FontFormatException e) {
      e.printStackTrace();
      return new Font("Arial", style, point);
    }
  }
}
