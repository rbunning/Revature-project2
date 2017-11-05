package com.revature.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LOGS")
public class Logs implements Serializable {

	/**
	 * LOGS -table 
	 * L_ID -column 
	 * L_DATED -column 
	 * L_LOGGER -column 
	 * L_LEVEL -column
	 * L_MESSAGE -column
	 */
	private static final long serialVersionUID = -6345654551274498476L;

	@Id
	@Column(name="L_ID")
	private int logsId;
	
	@Column(name="L_DATED")
	private String logsDated;
	
	@Column(name="L_LOGGER")
	private String logsLogger;
	
	@Column(name="L_LEVEL")
	private String logsLevel;
	
	@Column(name="L_MESSAGE")
	private String logsMessage;

	public Logs() {
		super();
	}

	public Logs(String logsDated, String logsLogger, String logsLevel, String logsMessage) {
		super();
		this.logsDated = logsDated;
		this.logsLogger = logsLogger;
		this.logsLevel = logsLevel;
		this.logsMessage = logsMessage;
	}

	public Logs(int logsId, String logsDated, String logsLogger, String logsLevel, String logsMessage) {
		super();
		this.logsId = logsId;
		this.logsDated = logsDated;
		this.logsLogger = logsLogger;
		this.logsLevel = logsLevel;
		this.logsMessage = logsMessage;
	}

	public int getLogsId() {
		return logsId;
	}

	public void setLogsId(int logsId) {
		this.logsId = logsId;
	}

	public String getLogsDated() {
		return logsDated;
	}

	public void setLogsDated(String logsDated) {
		this.logsDated = logsDated;
	}

	public String getLogsLogger() {
		return logsLogger;
	}

	public void setLogsLogger(String logsLogger) {
		this.logsLogger = logsLogger;
	}

	public String getLogsLevel() {
		return logsLevel;
	}

	public void setLogsLevel(String logsLevel) {
		this.logsLevel = logsLevel;
	}

	public String getLogsMessage() {
		return logsMessage;
	}

	public void setLogsMessage(String logsMessage) {
		this.logsMessage = logsMessage;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Logs [logsId=" + logsId + ", logsDated=" + logsDated + ", logsLogger=" + logsLogger + ", logsLevel="
				+ logsLevel + ", logsMessage=" + logsMessage + "]";
	}

}
