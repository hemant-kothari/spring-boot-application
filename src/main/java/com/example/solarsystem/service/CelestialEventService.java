package com.example.solarsystem.service;

import com.example.solarsystem.model.CelestialEvent;
import com.example.solarsystem.repository.CelestialEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class CelestialEventService {
    
    private final CelestialEventRepository eventRepository;
    
    @Autowired
    public CelestialEventService(CelestialEventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }
    
    public List<CelestialEvent> getUpcomingEvents() {
        return eventRepository.findByEventDateAfterOrderByEventDateAsc(LocalDateTime.now());
    }
    
    public List<CelestialEvent> getEventsByType(String eventType) {
        return eventRepository.findByEventType(eventType);
    }
    
    public CelestialEvent addEvent(CelestialEvent event) {
        return eventRepository.save(event);
    }
}