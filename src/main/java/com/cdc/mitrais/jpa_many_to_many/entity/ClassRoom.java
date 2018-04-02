package com.cdc.mitrais.jpa_many_to_many.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class ClassRoom {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int cid;
	private String cname;
	
	@ManyToMany(targetEntity=Teacher.class)
	private Set teacherSet;
	
	public ClassRoom() {}
	
	public ClassRoom(int cid, String cname, Set teacherSet) {
		super();
		this.setCid(cid);
		this.setCname(cname);
		this.setTeacherSet(teacherSet);
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public Set getTeacherSet() {
		return teacherSet;
	}

	public void setTeacherSet(Set teacherSet) {
		this.teacherSet = teacherSet;
	}
}
