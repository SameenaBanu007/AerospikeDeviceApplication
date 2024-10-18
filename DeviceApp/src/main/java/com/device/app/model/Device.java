package com.device.app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Device {
	
	@Id	
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
	
    private Integer deviceId; 	 
	
    private Integer hitCount;	
	
    private String osName;	
	
    private String osVersion;	
   
    private String browserName;	
   
    private String browserVersion;

    public Device() {}   
    
    public Device(String osName, String osVersion, String browserName, String browserVersion) {
		super();
		this.osName = osName;
		this.osVersion = osVersion;
		this.browserName = browserName;
		this.browserVersion = browserVersion;
	}



	public Integer getDeviceId() {
        return deviceId;
    }
    
    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public Integer getHitCount() {
        return hitCount;
    }

    public void setHitCount(Integer hitCount) {
        this.hitCount = hitCount;
    }

    public String getOsName() {
        return osName;
    }

    public void setOsName(String osName) {
        this.osName = osName;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    public String getBrowserName() {
        return browserName;
    }

    public void setBrowserName(String browserName) {
        this.browserName = browserName;
    }

    public String getBrowserVersion() {
        return browserVersion;
    }

    public void setBrowserVersion(String browserVersion) {
        this.browserVersion = browserVersion;
    }
   
}
