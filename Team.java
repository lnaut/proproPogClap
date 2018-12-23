
public class Team extends AbstractTeam {
	private String name;
	private int wins;
	private int draws;
	private int losses;
	
	public Team(String name) {
		this.name = name;
		wins=0;
		draws=0;
		losses=0;
	}
	
	public Team(String name, int wins, int draws, int losses) {
		this.name = name;
		this.wins = wins;
		this.draws = draws;
		this.losses = losses;
	}
	
	/*
	 * (non-Javadoc)
	 * @see AbstractTeam#getName()
	 */
	@Override
	public String getName() {
		return name;
	}
	/*
	 * (non-Javadoc)
	 * @see AbstractTeam#getWins()
	 */
	@Override
	public int getWins() {
		return wins;
	}
	/*
	 * (non-Javadoc)
	 * @see AbstractTeam#getLosses()
	 */
	@Override
	public int getLosses() {
		return losses;
	}
	/*
	 * (non-Javadoc)
	 * @see AbstractTeam#getDraws()
	 */
	@Override
	public int getDraws() {
		return draws;
	}
	/*
	 * (non-Javadoc)
	 * @see AbstractTeam#addWin()
	 */
	@Override
	public int addWin() {
		return wins+1;
	}
	/*
	 * (non-Javadoc)
	 * @see AbstractTeam#addLoss()
	 */
	@Override
	public int addLoss() {
		return losses+1;
	}
	/*
	 * (non-Javadoc)
	 * @see AbstractTeam#addDraw()
	 */
	@Override
	public int addDraw() {
		return draws+1;
	}
	/*
	 * (non-Javadoc)
	 * @see AbstractTeam#getPoints()
	 */
	@Override
	public int getPoints() {
		return 3*wins+draws;
	}

}
