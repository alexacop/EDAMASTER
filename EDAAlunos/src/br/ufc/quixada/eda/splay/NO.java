package br.ufc.quixada.eda.splay;

public class NO<T> {
	private int key;
	private NO<T> left,right;
	private T infor;
	
	public int getKey() {
		return key;
	}
	public void setKey(int key) {
		this.key = key;
	}
	public NO<T> getRight() {
		return right;
	}
	public void setRight(NO<T> right) {
		this.right = right;
	}
	public NO<T> getLeft() {
		return left;
	}
	public void setLeft(NO<T> left) {
		this.left = left;
	}
	public T getInfor() {
		return infor;
	}
	public void setInfor(T infor) {
		this.infor = infor;
	}
	
	
}
