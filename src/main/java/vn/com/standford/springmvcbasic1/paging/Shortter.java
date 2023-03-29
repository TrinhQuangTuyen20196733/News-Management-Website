package vn.com.standford.springmvcbasic1.paging;

public class Shortter {
	
	private String shortName;
	private String shortBy;
	
	public Shortter(String shortName, String shortBy) {
		this.shortName = shortName;
		this.shortBy = shortBy;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String sortName) {
		this.shortName = sortName;
	}

	public String getShortBy() {
		return shortBy;
	}

	
}
