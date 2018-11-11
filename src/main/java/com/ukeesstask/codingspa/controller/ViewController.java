package com.ukeesstask.codingspa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ViewController {
	
	/**
	 * Loads home page
	 * @return
	 */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getHomePage() {
        return "index";
    }
    
    /**
     * Loads employee updating page
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String getUpdatePage() {
        return "update";
    }
    
    /**
     * Loads empty page instead of updating page.
     * Triggers by CANCEL button.
     * @return
     */
    @RequestMapping(value = "/empty", method = RequestMethod.GET)
    public String getEmptyPage() {
        return "empty";
    }
    
}
    

