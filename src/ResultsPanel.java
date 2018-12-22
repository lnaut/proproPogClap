package src;
import javax.swing.*;
import java.awt.*;

public class ResultsPanel extends JPanel {

    /**
     * A panel that lets you add a new result to the standings file.
     * The layout has to be programmed here in the constructor.
     */
    public ResultsPanel(AbstractLeague t){
        super();
        
        // 
        // TODO Aufgabe 5
        // Die folgenden Widgets sollen platziert werden
        //
        JComboBox<String> teamselector1 = new JComboBox<String>(t.getTeamNames());
        JComboBox<String> teamselector2 = new JComboBox<String>(t.getTeamNames());
        JTextField scoreField1 = new JTextField(3);
        JTextField scoreField2 = new JTextField(3);
        JLabel statusLabel = new JLabel("Window initialized.");
        JButton addButton = new JButton("Add Result");
        
        // add your code here
    }
}

