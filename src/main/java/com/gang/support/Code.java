package com.gang.support;

public enum Code {

	FAIL(0, "失败"), SUCCESS(1, "成功");
	
	private int code;

	private String desc;
	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	
	
	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	private Code(int code, String desc) {
		this.code = code;
		this.desc = desc;
	}
	
	
	
}
