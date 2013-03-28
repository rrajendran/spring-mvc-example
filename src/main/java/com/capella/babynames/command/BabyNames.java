package com.capella.babynames.command;

/**
 * Form command object to hold the form variables
 * @author rrajendran
 *
 */
public class BabyNames {
	private int startYear;
	private int endYear;
	private int top;
	public int getStartYear() {
		return startYear;
	}
	public void setStartYear(int startYear) {
		this.startYear = startYear;
	}
	public int getEndYear() {
		return endYear;
	}
	public void setEndYear(int endYear) {
		this.endYear = endYear;
	}
	public int getTop() {
		return top;
	}
	public void setTop(int top) {
		this.top = top;
	}
	@Override
	public String toString() {
		return "BabyNames [startYear=" + startYear + ", endYear=" + endYear
				+ ", top=" + top + "]";
	}
	
	
}
