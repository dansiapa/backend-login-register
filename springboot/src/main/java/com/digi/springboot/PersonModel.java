package com.digi.springboot;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * PersonModel merupakan ORM/Mapping dari table tb_person
 */
@Entity
@Table(name = "tb_person") // tb_person adalah nama table nya
public class PersonModel {
	@Id // karena person id merupakan primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "person_id") // person_id merupakan nama column di table
	private int personId;
	@Column(name = "person_name") // person_name merupakan nama column di table
	private String personName;
	@Column(name = "personAge") // person age merupakan nama column di table
	private int personAge;
	
	// setter getter
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public int getPersonAge() {
		return personAge;
	}
	public void setPersonAge(int personAge) {
		this.personAge = personAge;
	}
	
	
}
