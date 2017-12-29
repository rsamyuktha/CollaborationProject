package com.niit.Backend.DAO;

import java.util.List;

import com.niit.Backend.Domain.Event;

public interface EventDAO
{
	public boolean addEvent(Event event);
	
	public boolean deleteEvent(int id);
	
	public Event getEvent(int id);
	
	public List<Event> listEvent();
	
}
