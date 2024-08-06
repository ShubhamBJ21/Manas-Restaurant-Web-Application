package com.shubham.model;

public class ServiceModule {

	private int serviceId;
	private String iconName;
	private String title;
	private String description;
	private String dateTime;

	public ServiceModule() {
		// no argument constructor
	}

	public ServiceModule(int serviceId, String iconName, String title, String description, String dateTime) {
		super();
		this.serviceId = serviceId;
		this.iconName = iconName;
		this.title = title;
		this.description = description;
		this.setDateTime(dateTime);
	}

	public int getServiceId() {
		return serviceId;
	}

	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}

	public String getIconName() {
		return iconName;
	}

	public void setIconName(String iconName) {
		this.iconName = iconName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	@Override
	public String toString() {
		return "[serviceId=" + serviceId + ", iconName=" + iconName + ", title=" + title + ", description="
				+ description + "]";
	}

}
