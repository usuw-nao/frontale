package domain;

public class Juge {
	private Integer id;
	private String Text;

	public Juge() {
	}

	public Juge(Integer id, String Text) {
		this.id =id;
		this.Text=Text;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getText() {
		return Text;
	}

	public void setText(String Text) {
		this.Text = Text;
	}

}
