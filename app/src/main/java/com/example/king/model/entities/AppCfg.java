package com.example.king.model.entities;

import java.io.Serializable;

public class AppCfg implements Serializable {

    private static final long serialVersionUID = -7915053723995945565L;

    private String platform;

	private String curVersion;

	private String latVersion;

	private String updateType;

	private String url;

	private String msg;

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public String getCurVersion() {
		return curVersion;
	}

	public void setCurVersion(String curVersion) {
		this.curVersion = curVersion;
	}

	public String getLatVersion() {
		return latVersion;
	}

	public void setLatVersion(String latVersion) {
		this.latVersion = latVersion;
	}

	public String getUpdateType() {
		return updateType;
	}

	public void setUpdateType(String updateType) {
		this.updateType = updateType;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

    @Override
    public String toString() {
        return "AppCfg{" +
                "platform='" + platform + '\'' +
                ", curVersion='" + curVersion + '\'' +
                ", latVersion='" + latVersion + '\'' +
                ", updateType='" + updateType + '\'' +
                ", url='" + url + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }
}
