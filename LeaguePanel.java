import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.List;
import java.util.Comparator;
import javax.swing.border.EmptyBorder;


public class LeaguePanel extends JPanel {
    
    private AbstractLeague allTeams;
    private static Comparator<AbstractTeam> last_comp = null;
    public LeaguePanel(AbstractLeague t) {
        super();
        setTeams(t);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(600, 680));
        createPanel(null);
    }
    
    public void setTeams(AbstractLeague t) {
        allTeams = t;
    }
    public void refresh(){
        createPanel(last_comp);
    }
    public void createSortingButtons(){
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
       
        // Panel für die Sortier-Buttons
        JPanel pointsButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        pointsButtonPanel.setBackground(Color.darkGray);
        panel.add(pointsButtonPanel, BorderLayout.CENTER);
        
        // Button für alphabetische Sortierung
        JButton alphabetical = new JButton("Alphabetical");
        alphabetical.addActionListener(
            action -> createPanel(null)
        );
        
        // Button für alphabetische Sortierung
        JButton points = new JButton("Points");
        points.addActionListener(
             action -> createPanel(new PointsComparator())
        );
        
        // Button für alphabetische Sortierung
        JButton wins = new JButton("Wins");
        wins.addActionListener(
            action -> createPanel(new WinsComparator())
        );
        
        // Hinzufügen des Buttonpanels
        panel.add(alphabetical, BorderLayout.WEST);
        pointsButtonPanel.add(points);
        panel.add(wins, BorderLayout.EAST);
     
        //panel.add(wins, BorderLayout.EAST);
        panel.setBackground(Color.darkGray);
        panel.setAlignmentX(LEFT_ALIGNMENT);
        this.add(panel);
    }
    public void createPanel(Comparator<AbstractTeam> comp) {
        //remember the last comparator
        this.last_comp = comp;
        removeAll();
        createSortingButtons();
        // Show sorted teams
        List<AbstractTeam> teams = allTeams.getTeams(comp);
        for(AbstractTeam t : teams) {
            JPanel p = t.toPanel();
            p.setAlignmentX(LEFT_ALIGNMENT);
            this.add(Box.createRigidArea(new Dimension(5,5)));
            this.add(p);
        }
        
        setPreferredSize(new Dimension(600, teams.size()*50+50));
        revalidate();
        repaint();
    }
}
