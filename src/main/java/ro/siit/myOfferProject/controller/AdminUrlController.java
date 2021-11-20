package ro.siit.myOfferProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ro.siit.myOfferProject.entity.SearchUrl;
import ro.siit.myOfferProject.repozitory.UrlRepozitory;
import java.util.UUID;


@Controller
@RequestMapping("admin")
public class AdminUrlController {

    @Autowired
        private UrlRepozitory repozitory;

        public AdminUrlController(UrlRepozitory repozitory) {
            this.repozitory = repozitory;
        }

    @GetMapping("/add")
        public String showAddForm(Model model) {
            Iterable<SearchUrl> urlsList = repozitory.findAll();
            model.addAttribute("urlsList", urlsList);
            return "addPage";
        }

    @PostMapping("/add")
        public String addUrlSite(@RequestParam ("sitename_html") String siteName,
                             @RequestParam ("siteurl_html") String searchUrl,
                             Model model) {
            repozitory.save(new SearchUrl(UUID.randomUUID(), siteName, searchUrl));
            Iterable<SearchUrl> urlsList = repozitory.findAll();
            model.addAttribute("urlsList", urlsList);
            return "addPage";
        }

    @GetMapping("/delete")
        public String deleteUrlSite(@RequestParam("urlid_html") String id,
                                    Model model) {
            repozitory.deleteById(UUID.fromString(id));
            Iterable<SearchUrl> urlsList = repozitory.findAll();
            model.addAttribute("urlsList", urlsList);
            return "addPage";
        }

}