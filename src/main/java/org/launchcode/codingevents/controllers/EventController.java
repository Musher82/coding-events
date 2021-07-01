package org.launchcode.codingevents.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("events")
public class EventController {

    private static List<String> events = new ArrayList<>();
    private static HashMap<String, String> eventsHash = new HashMap<>();

    @GetMapping
    public String displayAllEvents(Model model) {
       //  model.addAttribute("title", "All Events");
      //   model.addAttribute("events", events);
        eventsHash.put("Menteaship","A fun meetup for connecting with mentors");
        eventsHash.put("Code With Pride","A fun meetup sponsored by LaunchCode");
        eventsHash.put("Javascripty", "An imaginary meetup for Javascript developers");
        model.addAttribute("names", "name");
        model.addAttribute("events",eventsHash);
        return "events/index";
    }


    //lives at /events/create
    @GetMapping("create")
    public String renderCreateEventForm(Model model){
        model.addAttribute("title", "Create Event");
        return "events/create";
    }

    //handle requests for form Lives at events/create
    @PostMapping("create")
    public String createEvent(@RequestParam String eventName, String eventDescription){
        eventsHash.put(eventName, eventDescription);
        return "redirect:";
    }

}
