package com.dariocuevas.usersws.model

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement
class GUser {
	Integer id
	
	@XmlElement
	def name
	
	@XmlElement
	def mail
}
