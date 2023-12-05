package com.example.demo.model;



import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity

public class Alien {
	@Id
   private int aid;
	private String aname;
	private String type;
   public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
@Override
public String toString() {
	return "Alien [aid=" + aid + ", aname=" + aname + ", type=" + type + "]";
}
public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}

}
//
//spring.jpa.defer-datasource-initialization=true 
//need this to make undersatnd table is thier and after 
//every runor compile  previous data not their

//AID  	ANAME  
//101	dhiraj
//102	raj
//103	ranni
//104	sweety
//(4 rows, 3 ms)

