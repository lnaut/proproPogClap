import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public abstract class AbstractTeam {

  /** 
   * @return den Namen dieses Teams
   */
  public abstract String getName();

  /** 
   * @return die Anzahl der Siege dieses Teams
   */
  public abstract int getWins();

  /** 
   * @return die Anzahl der Niederlagen dieses Teams
   */
  public abstract int getLosses();

  /** 
   * @return die Anzahl der Unentschieden dieses Teams
   */
  public abstract int getDraws();

  /** 
   * @return erhöht die Anzahl der Siege dieses Teams um eins und liefert die entstandende Anzahl als Ergebnis
   */
  public abstract int addWin();

  /** 
   * @return erhöht die Anzahl der Niederlagen dieses Teams um eins und liefert die entstandende Anzahl als Ergebnis
   */
  public abstract int addLoss();

  /** 
   * @return erhöht die Anzahl der Unentschieden dieses Teams um eins und liefert die entstandende Anzahl als Ergebnis
   */
  public abstract int addDraw();

  /** 
   * Berechnet die von einem Team erzielten Punkte, wobei ein Sieg 3 Punkte,
   * ein Unentschieden 1 Punkt, und eine Niederlage 0 Punkte liefert.
   * 
   * @return die Anzahl der von diesem Team erzielten Punkte.
   */
  public abstract int getPoints();

  /** 
   * 
   * @return ein String, der die in einem Team enthaltene Information darstellt.
   */
  @Override
  public String toString() {
    return String.format("%s(%d:%d:%d)", getName(), getWins(), getDraws(), getLosses());
  }
  
  /**
   * Erstellt ein Panel für ein Team.
   */
  public JPanel toPanel(){
    JPanel panel = new JPanel();
    panel.setLayout(new BorderLayout());
    panel.setBorder(new EmptyBorder(10, 10, 10, 10));
    JLabel name = new JLabel(this.getName());
    name.setPreferredSize(new Dimension(200, 20));
    JLabel points = new JLabel(String.format("%2d Points", this.getPoints()));
    points.setHorizontalAlignment(SwingConstants.CENTER);
    JLabel score = new JLabel(String.format("%2d W  |  %2d D  |  %2d L", this.getWins(), this.getDraws(), this.getLosses()));
    score.setHorizontalAlignment(SwingConstants.RIGHT);
    score.setPreferredSize(new Dimension(300, 20));
    panel.add(name, BorderLayout.WEST);
    panel.add(points, BorderLayout.CENTER);
    panel.add(score, BorderLayout.EAST);
    panel.setBackground(Color.lightGray);
    panel.setMaximumSize(new Dimension(new Dimension(Short.MAX_VALUE, Short.MAX_VALUE)));
    panel.setPreferredSize(panel.getMaximumSize());
    return panel;
  }
}
