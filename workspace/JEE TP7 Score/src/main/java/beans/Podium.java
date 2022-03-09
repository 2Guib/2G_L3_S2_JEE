package beans;

public class Podium {
	private Sportif gold;
	private Sportif silver;
	private Sportif bronze;
	private Discipline sport;
	public Sportif getGold() {
		return gold;
	}
	public void setGold(Sportif gold) {
		this.gold = gold;
	}
	public Sportif getSilver() {
		return silver;
	}
	public void setSilver(Sportif silver) {
		this.silver = silver;
	}
	public Sportif getBronze() {
		return bronze;
	}
	public void setBronze(Sportif bronze) {
		this.bronze = bronze;
	}
	public Discipline getSport() {
		return sport;
	}
	public void setSport(Discipline sport) {
		this.sport = sport;
	}
}
