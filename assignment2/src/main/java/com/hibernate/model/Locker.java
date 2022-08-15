package com.hibernate.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Locker")
public class Locker implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	
	public Locker() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Locker(String lockerId, String lockerType, Integer rent) {
		super();
		this.lockerId = lockerId;
		this.lockerType = lockerType;
		this.rent = rent;
	}

	@Column(name="LockerId")
	private String lockerId;
	
	@Column(name="LockerType")
	private String lockerType;
	
	@Column(name="Rent")
	private Integer rent;

	public String getLockerId() {
		return lockerId;
	}

	public void setLockerId(String lockerId) {
		this.lockerId = lockerId;
	}

	public String getLockerType() {
		return lockerType;
	}

	public void setLockerType(String lockerType) {
		this.lockerType = lockerType;
	}

	public Integer getRent() {
		return rent;
	}

	public void setRent(Integer rent) {
		this.rent = rent;
	}
	
	public Integer getId() {
		return Id;
	}

	@Override
	public String toString() {
		return "Locker [lockerId=" + lockerId + ", lockerType=" + lockerType + ", rent=" + rent + "]";
	}
}
