
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class TournamentRankingPanel extends JPanel{

    private JTable table;
    private TournamentTree tree;

    public TournamentRankingPanel(TournamentTree tree) {
        super();
        this.setLayout(null);
        this.table = new JTable(new DefaultTableModel(new Object[]{"Place", "Team"}, 0));
        this.table.setFont(new Font("arial", Font.BOLD, 32));
        this.table.setRowHeight(52);
        this.table.setBounds(200,100,500,table.getRowHeight()*8);
        this.tree = tree;
        this.add(table);
    }
    public void setTree(TournamentTree tree){
        this.tree = tree;
    }
    public void fillTable(){

        DefaultTableModel model = new DefaultTableModel(new Object[]{"Place", "Team"}, 0);

        if (tree.getRoot().getWinner() == null) {
            table.setModel(model);
            return;
        }

        // Level 1
        AbstractTournamentNode root = tree.getRoot();
        AbstractTeam first = root.getWinner();
        AbstractTeam second = root.getLoser();
        // Level 2
        AbstractTournamentNode n21 = root.getChildNode(first);
        AbstractTournamentNode n22 = root.getChildNode(second); 
        AbstractTeam third1 = n21.getLoser();
        AbstractTeam third2 = n22.getLoser();
        // Level 3
        AbstractTournamentNode n31 = n21.getChildNode(first);
        AbstractTournamentNode n32 = n21.getChildNode(third1);
        AbstractTournamentNode n33 = n22.getChildNode(second);
        AbstractTournamentNode n34 = n22.getChildNode(third2);
        
        model.addRow(new String[]{"FIRST", first.getName()});
        model.addRow(new String[]{"Second", second.getName()});
        model.addRow(new String[]{"Third", third1.getName()});
        model.addRow(new String[]{"Third", third2.getName()});
        model.addRow(new String[]{"Fifth", n31.getLoser().getName()});
        model.addRow(new String[]{"Fifth", n32.getLoser().getName()});
        model.addRow(new String[]{"Fifth", n33.getLoser().getName()});
        model.addRow(new String[]{"Fifth", n34.getLoser().getName()});

        table.setModel(model);
    }

    }
