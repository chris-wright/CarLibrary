package com.arnoldclark.objects;

public enum Size {
	
	SMALL(350),
	LARGE(800);
	
	private int size;
	
	private Size(int size) {
		this.size = size;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
}
