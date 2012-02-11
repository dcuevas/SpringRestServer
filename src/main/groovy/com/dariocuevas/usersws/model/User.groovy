package com.dariocuevas.usersws.model

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;

@Entity
@Table (name="Users")
@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement
class User {
	
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	@Column (name="id" , unique = true, nullable = false)
	@XmlElement
	Long id

	@Column (name="name")
	@XmlElement
	String name
	
	@Column (name="mail")
	@XmlElement
	String mail

}
