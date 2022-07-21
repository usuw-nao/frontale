package domain;

import java.util.Date;

public class Review {
	private Integer id;
	private String name;
	private String text;
	private Date registered;
	private Integer revaluation;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getRegistered() {
		return registered;
	}

	public void setRegistered(Date registered) {
		this.registered = registered;
	}

	public Integer getRevaluation() {
		return revaluation;
	}

	public void setRevaluation(Integer revaluation) {
		this.revaluation = revaluation;
	}

}