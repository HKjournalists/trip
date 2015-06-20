package com.otrip.domain.test;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="test")
public class Test implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2020629526403924466L;

	@Id
	@Basic(optional=false)
	@Column(name="tid" , nullable=false)
	private String tid;
	public void setTid(String tid) {
		this.tid = tid;
	}
	public String getTid() {
		return tid;
	}
	
	@Column(name="title" )
	private String title;
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name="content" )
	private String content;
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	@Override
	public String toString() {
		return "Test [tid=" + tid + ", title=" + title + ", content=" + content
				+ "]";
	}
	
}
