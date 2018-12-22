
import java.util.List;
import java.util.Comparator;

public abstract class AbstractLeague
{  
    /**
     * Erhält den Pfad zu einem CSV-File, das Teams und dazugehörige Statistiken enthält.
     * Das File wird gelesen und in einer HashMap abgebildet, die den Namen
     * des Teams auf das zugeordnete Team-Objekt abbildet.
     * Die Liste wird gespeichert und kann später mit {@link #getTeams()} ausgelesen werden.
     *
     * @param path Der Pfad zum CSV-File. Jede Zeile soll das Muster '[TeamName],[Wins],[Draws],[Loses]' aufweisen.
     */
    public abstract void loadTeams(String path);
    
    /**
     * @return einen Array der Namen aller an der Liga teilnehmenden Teams
     */
    public String[] getTeamNames() {
        List<AbstractTeam> teams = getTeams();
        String[] names = new String[teams.size()];
        int k = 0;
        for (AbstractTeam t : teams) {
            names[k++] = t.getName();
        }
        return names;
    }
    
    /**
     * @return die (unsortierte) Liste aller Teams der Liga
     */
    public abstract List<AbstractTeam> getTeams();
    
    /**
     * @return die nach dem übergebenen Komparator sortierte Liste aller Teams der Liga
     */    
    public List<AbstractTeam> getTeams(Comparator<AbstractTeam> comp) {
        return getTeams();
    }
    
    /**
     * Hinzufügen eines Spielergebnisses
     * 
     * @param name1 Name des ersten Teams
     * @param name2 Name des zweiten Teams
     * @param score1 Anzahl der Tore, die das erste Team erzielt hat
     * @param score2 Anzahl der Tore, die das zweite Team erzielt hat
     */
    public abstract void addResult(String name1, String name2, int score1, int score2);
}
