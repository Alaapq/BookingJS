package com.bookingJS.pageObject;

public class hotelsObject {
	public String checkin;
	public String checkOut;
	public String linkTarget;
	public String linkAvoid;

		
					
		 /*
	public hotelsObject(String checkin, String checkOut) {
		super();
		this.checkin = checkin;
		this.checkOut = checkOut;

	}
	*/

	public String getCheckin() {
		return checkin;
	}
	public void setCheckin(String checkin) {
		this.checkin = checkin;
	}
	public String getCheckOut() {
		return checkOut;
	}
	public void setCheckOut(String checkOut) {
		this.checkOut = checkOut;
	}
	public String getLinkTarget() {
		return linkTarget;
	}
	public void setLinkTarget(String linkTarget) {
		this.linkTarget = linkTarget;
	}
	public String getLinkAvoid() {
		return linkAvoid;
	}
	public void setLinkAvoid(String linkAvoid) {
		this.linkAvoid = linkAvoid;
	}
		
	
}
