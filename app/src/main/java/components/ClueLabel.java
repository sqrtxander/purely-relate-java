package components;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import fonthandler.FontHandler;
import java.awt.Font;
import java.awt.Color;
import javax.swing.BorderFactory;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;

public class ClueLabel extends JPanel {
  String clueBack;
  static Font font =
    FontHandler.customFont(FontHandler.mainFont, Font.PLAIN, 36);
  JTextPane cluePane = new JTextPane();


  public ClueLabel(String inBack) {
    super();
    clueBack = inBack;

    initCluePane();

    setBackground(null);
    setBorder(BorderFactory.createLineBorder(Color.BLACK));
    makeCenteredPanel(cluePane);
  }

  private void initCluePane() {
    cluePane.setFont(font);
    cluePane.setBackground(null);
    cluePane.setEditable(false);
    cluePane.setOpaque(false);
    cluePane.setFocusable(false);

    cluePane.setBorder(new EmptyBorder(10, 10, 10, 10)); // padding

    // scaling text
    cluePane.addComponentListener(new ComponentAdapter() {
      public void componentResized(ComponentEvent e) {
         scaleFontDown();
      }
    });

    // align text
    StyledDocument doc = cluePane.getStyledDocument();
    SimpleAttributeSet center = new SimpleAttributeSet();
    StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
    doc.setParagraphAttributes(0, doc.getLength(), center, false);
  }

  private void makeCenteredPanel(JTextPane textArea) {
    setLayout(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.weightx = 1;
    gbc.weighty = 1;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.anchor = GridBagConstraints.CENTER;

    add(textArea, gbc);
  }

  public void flip() {
    cluePane.setText(clueBack);
    scaleFontDown();
  }

  public void unflip() {
    cluePane.setText("");
  }

  public void scaleFontDown() {
    int fontSize = font.getSize();
    int availableHeight = getHeight() - cluePane.getInsets().top - cluePane.getInsets().bottom;
    int availableWidth = getWidth() - cluePane.getInsets().left - cluePane.getInsets().right;

    JTextPane dummyPane = new JTextPane();
    dummyPane.setText(clueBack);
    dummyPane.setFont(font);
    dummyPane.setBorder(new EmptyBorder(10, 10, 10, 10));
    dummyPane.setSize(new Dimension(availableWidth, dummyPane.getPreferredSize().height));

    int textHeight = 0;
    Font scaledFont = font;
    while (dummyPane.getPreferredSize().height > availableHeight && fontSize > 1) {
      fontSize--;
      scaledFont = font.deriveFont((float) fontSize);
      dummyPane.setSize(new Dimension(availableWidth, dummyPane.getPreferredSize().height));
      dummyPane.setFont(scaledFont);
    }
    cluePane.setFont(scaledFont);
  }

  private Dimension getSize(Font font, String text) {
    FontMetrics metrics = cluePane.getFontMetrics(font);
    Rectangle bounds = metrics.getStringBounds(text, cluePane.getGraphics()).getBounds();
    return bounds.getSize();
  }

  private double compare(Dimension compSize, Dimension textSize) {
    double numOfLines = textSize.getWidth() / compSize.getWidth();
    numOfLines = Math.ceil(numOfLines);
    double newTextWidth = compSize.getWidth();
    double newTextHeight = numOfLines * textSize.getHeight();
    double aComp = compSize.getHeight() * compSize.getWidth();
    double aText = newTextHeight * newTextWidth;
    return aComp - aText;
  }
}
