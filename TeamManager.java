import javax.swing.*;
import java.awt.*;
import java.io.File;

public class TeamManager extends JFrame {

    public static String TEAM_FILE_PATH = "resources/standings.csv";
    AbstractLeague teams = new League();
    private JPanel center; 
    LeaguePanel teamsPanel;
    TournamentPanel tournamentPanel; 
    TournamentRankingPanel rankingPanel; 
    
    
    public TeamManager(){
        super("Team Window");
        teams.loadTeams(TEAM_FILE_PATH);
        createWindow();
        repaint();
        setVisible(true);
    }
    
    private void createWindow(){
        setBounds(0, 0, 900, 700);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());
        createMenu();
        this.center = createCenterPanel();
        getContentPane().add(this.center, BorderLayout.CENTER);
    }
    
    private void createMenu(){
    
        //Where the GUI is created:
        JMenuBar menuBar;
        JMenu menu, submenu;
        JMenuItem menuItem;
    
        //Create the menu bar.
        menuBar = new JMenuBar();
        
        //Build the File menu
        menu = new JMenu("File");
        menuBar.add(menu);
        
        //Open File MenuItem
        menuItem = new JMenuItem("Open");
        menuItem.addActionListener(e -> {
            JFileChooser chooser = new JFileChooser();
            chooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
            int returnVal = chooser.showOpenDialog(this);
            if(returnVal == JFileChooser.APPROVE_OPTION) {
                TEAM_FILE_PATH = chooser.getSelectedFile().getPath();
                teams.loadTeams(TEAM_FILE_PATH);
                teamsPanel.createPanel(null);
            }       
        });
        menu.add(menuItem);
    
        //Build the View menu.
        menu = new JMenu("View");
        menu.getAccessibleContext().setAccessibleDescription("Show an accessible View");
        menuBar.add(menu);
    
        //a group of JMenuItems
        menuItem = new JMenuItem("Team List");
        menuItem.getAccessibleContext().setAccessibleDescription("Lists all teams in the csv file");
        menuItem.addActionListener(e -> {
            ((CardLayout)this.center.getLayout()).show(this.center, "tab1");
        });
        menu.add(menuItem);
        
        menuItem = new JMenuItem("Add Result");
        menuItem.getAccessibleContext().setAccessibleDescription("Add a game result to the table");
        menuItem.addActionListener(e -> {
            createAndShowGui();
        });
        menu.add(menuItem);
    
        submenu = new JMenu("Tournament");
        menuItem.getAccessibleContext().setAccessibleDescription("Shows the current tournament");
        menu.add(submenu);
    
        menuItem = new JMenuItem("Tree");
        menuItem.getAccessibleContext().setAccessibleDescription("Shows the current tournament as a tree");
        menuItem.addActionListener(e -> {
            tournamentPanel.resetTree(teams);
            ((CardLayout)this.center.getLayout()).show(this.center, "tab2");
        });
        submenu.add(menuItem);
    
        menuItem = new JMenuItem("Ranking");
        menuItem.getAccessibleContext().setAccessibleDescription("Shows the current tournament as a ranking");
        menuItem.addActionListener(e -> {
            rankingPanel.setTree(tournamentPanel.getTree());//in case reset button in tournament panel was clicked
            rankingPanel.fillTable();
            ((CardLayout)this.center.getLayout()).show(this.center, "tab4");
        });
        submenu.add(menuItem);
    
        setJMenuBar(menuBar);
    }
    
    private void createAndShowGui() {
        ResultsPanel addPanel = new ResultsPanel(teams);
        
        int optionType = JOptionPane.DEFAULT_OPTION;
        int messageType = JOptionPane.PLAIN_MESSAGE;
        Icon icon = null;
        String[] options = { "Done"};
        Object initialValue = options[0];
        int reply = JOptionPane.showOptionDialog(null, addPanel,
            "Enter Game Results...", optionType, messageType, icon, options,
            initialValue);
        this.teamsPanel.refresh();        
    }
    
    private JPanel createCenterPanel(){
        JPanel center = new JPanel();
        center.setLayout(new CardLayout());
        
        teamsPanel = new LeaguePanel(teams);
        tournamentPanel = new TournamentPanel(teams);
        rankingPanel = new TournamentRankingPanel(tournamentPanel.getTree());
        JScrollPane sp = new JScrollPane(teamsPanel);
        sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    
        JPanel tab2 = new JPanel();
        JLabel txt2 = new JLabel("Tournament view");
        tab2.add(txt2);
        tab2.setBackground(Color.blue);
    
        ResultsPanel atp = new ResultsPanel(teams);
    
        center.add(sp, "tab1");
        center.add(tournamentPanel, "tab2");
        //center.add(atp, "tab3");
        center.add(rankingPanel, "tab4");
    
        return center;
    }
    
    public static void main(String args[]){
        TeamManager mainFrame = new TeamManager();
    }

}
