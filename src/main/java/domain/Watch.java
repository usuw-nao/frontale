package domain;

import java.util.Date;

public class Watch {
	private Integer id;
	private Date matchDay;
	private String game;
	private String place;

	public Watch() {
	}

	public Watch(Integer id, Date matchDay, String game, String place) {
		this.id = id;
		this.matchDay = matchDay;
		this.game = game;
		this.place = place;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getMatchDay() {
		return matchDay;
	}

	public void setMatchDay(Date matchDay) {
		this.matchDay = matchDay;
	}

	public String getGame() {
		return game;
	}

	public void setGame(String game) {
		this.game = game;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

}
