package model;

public class Porder {
	private Integer id;
	private String name;
	private Integer wrench;
	private Integer pail;
	private Integer hose;

	public Porder(String name, Integer wrench, Integer pail, Integer hose) {
		super();
		this.name = name;
		this.wrench = wrench;
		this.pail = pail;
		this.hose = hose;
	}
	
	public Porder() {
		super();
	}

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

	public Integer getWrench() {
		return wrench;
	}

	public void setWrench(Integer wrench) {
		this.wrench = wrench;
	}

	public Integer getPail() {
		return pail;
	}

	public void setPail(Integer pail) {
		this.pail = pail;
	}

	public Integer getHose() {
		return hose;
	}

	public void setHose(Integer hose) {
		this.hose = hose;
	}

}
