package org.launchcode.javawebdevtechjobsmvc.controllers;

import org.launchcode.javawebdevtechjobsmvc.models.Job;
import org.launchcode.javawebdevtechjobsmvc.models.JobData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

import static java.lang.System.out;
import static org.launchcode.javawebdevtechjobsmvc.controllers.ListController.columnChoices;

/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping("search")
public class SearchController {



    @RequestMapping(value = "")
    public String search(Model model) {
        model.addAttribute("columns", columnChoices);
        return "search";
    }

    // TODO #3 - Create a handler to process a search request and render the updated search view.



    @PostMapping("results")
    public String displaySearchResults(Model model, @RequestParam String searchTerm, @RequestParam String searchType){

//        ArrayList<Job> jobs;
//        if (searchType.toLowerCase().equals("all")){
//            jobs = JobData.findAll();
//            model.addAttribute("title", "All Jobs");
//        } else {
//            jobs = JobData.findByColumnAndValue(searchType, searchTerm);
//            model.addAttribute("title", "Jobs with " + columnChoices.get(searchType) + ": " + searchTerm);
//        }
//        model.addAttribute("jobs", jobs);

        ArrayList<Job> jobs;
        if (searchType.toLowerCase().equals("all") && searchTerm.equals("")) {
            jobs = JobData.findAll();
            model.addAttribute("title", "All Jobs");
        } else if (searchType.toLowerCase().equals("all") && searchTerm.equals(true)){
            jobs = JobData.findByColumnAndValue(searchType, searchTerm);
            model.addAttribute("title", "Jobs with " + columnChoices.get(searchType) + ": " + searchTerm);
        } else {
            jobs = JobData.findByColumnAndValue(searchType, searchTerm);
            model.addAttribute("title", "Jobs with " + columnChoices.get(searchType) + ": " + searchTerm);
        }
        model.addAttribute("jobs", jobs);

//        System.out.println(searchTerm);
//        System.out.println(searchType);


//    return "list-jobs";

        return "searchFragment";


    }


}
