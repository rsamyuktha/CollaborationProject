package com.niit.collaboration.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "C_EVENT")
@Component
public class Event extends BaseDomain
{
	@Id
	
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQUENCE11")
	@SequenceGenerator(name="SEQUENCE11", sequenceName="SEQUENCE11", allocationSize=1)

	private long id;
	
	private String name;
	
	@Lob
	private String description;
	
	@Column(name = "EVENT_DATE")
	private Date date;
	
	private String time;
	private String venue;
	@Column(name = "POSTED")
	private String postedTime;
	
	@Transient
	private String eventDate;
	
	public String getEventDate() {
		return eventDate;
	}

	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}

	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	public String getPostedTime() {
		return postedTime;
	}

	public void setPostedTime(String postedTime) {
		this.postedTime = postedTime;
	}
}
