package ro.siit.myOfferProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ro.siit.myOfferProject.entity.SearchUrl;
import ro.siit.myOfferProject.repozitory.UrlRepozitory;


@Controller
@RequestMapping("application")
    public class SearchUrlController {

        @Autowired
            private UrlRepozitory repozitory;

            public SearchUrlController(UrlRepozitory repozitory) {
        this.repozitory = repozitory;
    }

        @GetMapping("")
            public String openFirstPage(@RequestParam(name="name", required=false) String name,
                                        Model model) {
                Iterable<SearchUrl> urlsList = repozitory.findAll();
                model.addAttribute("urlsList", urlsList);
                model.addAttribute("name", name);
                return "firstPage";
            }

        @PostMapping("")
            public String searchUrlSite(@RequestParam ("elementCautat") String query,
                                        Model model) {
                Iterable<SearchUrl> urlsList = repozitory.findAll();
                model.addAttribute("urlsList", urlsList);
                model.addAttribute("elementCautat", query);
                return "searchResult";
            }

}
