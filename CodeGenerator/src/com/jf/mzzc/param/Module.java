package com.jf.mzzc.param;

public class Module {

	private String path;
	
	private String name;

	public Module() {
		super();
	}
	
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Module [path=" + path + ", name=" + name + "]";
	}
	
}
