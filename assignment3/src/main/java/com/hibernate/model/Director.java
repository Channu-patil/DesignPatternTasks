package com.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Director")
public class Director {

	public Director() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Director(String directorId, String directorName, Integer bornIn) {
		super();
		this.directorId = directorId;
		this.directorName = directorName;
		this.bornIn = bornIn;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;

	@Column(name = "DirectorId")
	private String directorId;

	@Column(name = "directorName")
	private String directorName;

	@Column(name = "BornIn")
	private Integer bornIn;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getDirectorId() {
		return directorId;
	}

	public void setDirectorId(String directorId) {
		this.directorId = directorId;
	}

	public String getDirectorName() {
		return directorName;
	}

	public void setDirectorName(String directorName) {
		this.directorName = directorName;
	}

	public Integer getBornIn() {
		return bornIn;
	}

	public void setBornIn(Integer bornIn) {
		this.bornIn = bornIn;
	}

	@Override
	public String toString() {
		return "Director [Id=" + Id + ", directorId=" + directorId + ", directorName=" + directorName + ", bornIn="
				+ bornIn + "]";
	}

}
