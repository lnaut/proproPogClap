import javax.swing.*;
import java.util.List;

public class TournamentPanel extends JPanel{

    final int NODE_BUTTON_WIDTH = 120;
    final int NODE_BUTTON_HEIGHT = 40;
    
    private AbstractLeague teams;
    private TournamentTree tree;

    /**
     * der Konstruktor ruft den vererbten Konstruktor auf, lädt alle Teams,
     * um sie zu sortieren und aus den besten 8 einen Turnierbaum aufzubauen
     * und ihn anschliessend mit Hilfe von Buttons anzuzeigen
     */
    public TournamentPanel(AbstractLeague t) {
        super();
        this.teams = t;        
    }

    /**
     *Zeichnet den gesamten Baum aufs Panel
     */
    private void drawTree(){
        removeAll();

        setBounds(0, 0, 600, 600);
        int rootHeightPosition = getSize().height/2;
        drawNode(getSize().width- NODE_BUTTON_WIDTH, rootHeightPosition, tree.root, rootHeightPosition/2);
        drawResetButton();
        repaint();
    }

    /**
     *  Erstellt einen Button, an der korrekten Stelle des Baumes ist, den Namen des Teams zeigt
     *  und beim Drücken das entsprechende Team (falls möglich) durch Aufruf der 
     *  entsprechenden setWinner-Methode im Eltern Knoten als Sieger festhält.
     *  Ruft anschliessend (rekursiv) drawNode für die Kinder auf
     *  
     * @param x, y : Position des Buttons
     * @param participant der zugehörige Participant
     * @param yDistance Wie weit in Y-Richtung die Kind-Buttons vom aktuellen Button entfernt sind
     */
    private void drawNode(int x, int y, AbstractTournamentNode node, int yDistance){
        JButton teamButton = new JButton();
        teamButton.setText(node.getWinnerName());
        teamButton.setBounds(x, y, NODE_BUTTON_WIDTH, NODE_BUTTON_HEIGHT);
        // Listener
        teamButton.addActionListener(e -> {
            if (node.getParent() != null) {
               node.getParent().setWinner(node.getWinner());
               drawTree();
            }
        });

        teamButton.setEnabled(true);
        add(teamButton);

        if(node.getLeftChild() != null)
            drawNode(x - (int)(NODE_BUTTON_WIDTH *1.2), y - yDistance, node.getLeftChild(), yDistance/2);
        if(node.getRightChild() != null)
            drawNode(x - (int)(NODE_BUTTON_WIDTH *1.2), y + yDistance, node.getRightChild(), yDistance/2);

    }

    public TournamentTree getTree() {
        return tree;
    }
    public void redrawTree(){
        setLayout(new GroupLayout(this));
        setAlignmentX(LEFT_ALIGNMENT);
        drawTree();
    }
    
    public void resetTree(AbstractLeague t) {
        this.tree = new TournamentTree(t.getTeams(new PointsComparator()));
        redrawTree();
    }

    void drawResetButton(){
        JButton resetButton = new JButton();
        resetButton.setText("Reset");
        resetButton.setBounds(getSize().width- NODE_BUTTON_WIDTH, 0, NODE_BUTTON_WIDTH, NODE_BUTTON_HEIGHT);
        resetButton.addActionListener(e -> {;
            resetTree(teams);
        });

        resetButton.setEnabled(true);
        add(resetButton);
    }
}
