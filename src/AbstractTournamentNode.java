package src;
public abstract class AbstractTournamentNode {

    /**
     * Setzt den Siegknoten auf das Gewinner-Team und gibt true zurück, wenn
     *    - beide Nachfolger existieren und das übergebene Team einer 
     *      der beiden ist
     *    - wenn einer der beiden Nachfolger das übergebene Team ist
     *      und der andere null ist
     *    - wenn beide Nachfolger null sind
     * Ansonsten ändert sich der Gewinner nicht 
     * (und auch keiner der anderen Knoten).
     *
     * @param winner das Gewinner Team
     * @return ob eine Änderung stattgefunden hat
     */
    public abstract boolean setWinner(AbstractTeam winner);
 
    /**
     * @return der Name des Gewinner-Teams
     */
    public String getWinnerName() {
        AbstractTeam winner = getWinner();
        if(winner == null){
            return "N/A";
        }
        return winner.getName();
    }

    /**
     * @return das Gewinner-Team
     */
    public abstract AbstractTeam getWinner();

    /**
     * liefert das Verlierer-Team, also das Team der beiden Kind-Knoten,
     * das nicht als Gewinner in diesem Knoten abgespeichert wurde.
     * Wenn es keine Kind-Knoten gibt, gibt es auch keinen Verlierer (null).
     * 
     * @return das Verlierer-Team
     */
    public abstract AbstractTeam getLoser();

    /**
     * @return den Eltern-Knoten
     */
    public abstract AbstractTournamentNode getParent(); 

    /**
     * @return den linken Kind-Knoten
     */
    public abstract AbstractTournamentNode getLeftChild();
    
    /**
     * @return den rechten Kind-Knoten
     */
    public abstract AbstractTournamentNode getRightChild();
    
    /**
     * @param ein Team
     * @return den Kind-Knoten, der dem Team entspricht, bzw. null falls
     *         keine Kind-Knoten existieren, oder sie nicht dem Team entsprechen.
     */
    public AbstractTournamentNode getChildNode (AbstractTeam t) {
        AbstractTournamentNode  leftChild = getLeftChild();
        AbstractTournamentNode rightChild = getRightChild();
        if ((t == null) || (leftChild == null) || (rightChild == null)) 
            return null;
        if (t == leftChild.getWinner()) {
            return leftChild;
        }
        else if (t == rightChild.getWinner()) {
            return rightChild;
        }
        return null;
    }
   
    /**
     * Setze den linken und den rechten Kindknoten auf die übergebenen Knoten
     * 
     * @param leftChild der linke Knoten
     * @param rightChild der rechte Knoten
     */
    public abstract void setChildren(AbstractTournamentNode leftChild, AbstractTournamentNode rightChild);
}
