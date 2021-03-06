package com.cdc.mitrais.jpa_many_to_many.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Teacher {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int tid;
	private String tname;
	private String subject;
	
	@ManyToMany(targetEntity=ClassRoom.class)
	private Set classRoomSet;
	
	public Teacher() {}
	
	public Teacher(int tid, String tname, String subject, Set classRoomSet) {
		this.setTid(tid);
		this.setTname(tname);
		this.setSubject(subject);
		this.setClassRoomSet(classRoomSet);
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Set getClassRoomSet() {
		return classRoomSet;
	}

	public void setClassRoomSet(Set classRoomSet) {
		this.classRoomSet = classRoomSet;
	}
	
	
}
