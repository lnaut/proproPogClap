import java.util.*;

public class TournamentTree {

    //4-Layer Tree = 8 Bl�tter
    public static final int[] SCHEDULE = {0,7,3,4,2,5,1,6};
    //Wurzel des Baums (Der Gewinner des Turniers)
    public AbstractTournamentNode root;
    //Die 8 Bl�tter
    public List<AbstractTeam> teams;

    /**
     *     Der Kontruktor baut einen leeren Baum mit 3 (LAYER) Ebenen auf
     *     Dabei ruft er die rekursive(!) Methode buildEmptyTree auf.
     *     @param teams ein Liste von Teams von denen die ersten 8 (2^LAYER) verwendet werden.
     */
    public TournamentTree(List<AbstractTeam> teams) {
        this.teams = teams;
        // 
        // TODO (Aufgabe 6.b)
        // Entfernen Sie diese Kommentierung aus den folgenden beiden
        // Zeilen, sobald sie 6.a gel�st haben.
        //
        // root = new TournamentNode(null);
        // initializeTree(root,SCHEDULE);
    }

    /**
     * Baut vom �bergebenden Knoten ausgehend einen Teilbaum auf.
     * Die Tiefe des Baums ist durch den array von integer-Zahlen gegeben.
     * Besteht dieser Array nur mehr aus einer Zahl, dann wird das Team
     * mit diesem Index als winner in den Knoten eingetragen.
     * Ansonsten wird die erste H�lfte des Arrays an die linken Knoten
     * �bergeben, die zweite H�lfte an die rechten.
     * 
     * @param schedule eine Permutation der Indices der Teams, 
     *                 die an der KO-Runde teilnehmen. Die L�nge ist
     *                 eine Potenz von 2. Bei 8 teams also eine Permutation
     *                 der Zahlen 0..7.
     */
    private void initializeTree(AbstractTournamentNode n, int[] schedule) {
        //
        // TODO (Aufgabe 6.b)
        // Hier ist Aufgabe 6.b zu l�sen
        // Die beiden auskommentierten Zeilen im Konstruktor, die diese Methode
        // mit dem Root-Knoten aufrufen, m�ssen ebenfalls wiederhergestellt werden.
        //
    }
    
      
    public AbstractTournamentNode getRoot() {
        return root;
    }
}