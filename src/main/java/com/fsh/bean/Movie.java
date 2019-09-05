package com.fsh.bean;

/**
 * @作者：Mr.冯
 * @日期：2019年9月3日
 */
public class Movie {

	private int mid;
	private String mname;
	private String content;
	private String daoyan;
	private String mdate;
	private int tid;
	public Movie(int mid, String mname, String content, String daoyan,
			String mdate, int tid) {
		super();
		this.mid = mid;
		this.mname = mname;
		this.content = content;
		this.daoyan = daoyan;
		this.mdate = mdate;
		this.tid = tid;
	}
	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDaoyan() {
		return daoyan;
	}
	public void setDaoyan(String daoyan) {
		this.daoyan = daoyan;
	}
	public String getMdate() {
		return mdate;
	}
	public void setMdate(String mdate) {
		this.mdate = mdate;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	@Override
	public String toString() {
		return "Movie [mid=" + mid + ", mname=" + mname + ", content="
				+ content + ", daoyan=" + daoyan + ", mdate=" + mdate
				+ ", tid=" + tid + "]";
	}
	
	
}
