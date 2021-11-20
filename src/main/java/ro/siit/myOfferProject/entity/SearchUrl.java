package ro.siit.myOfferProject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;


@Entity
@Table(name = "search_urls")
public class SearchUrl {

    @Id
        private UUID id;
    @Column(name = "site_name")
        private String siteName;
    @Column(name = "search_url")
        private String searchUrl;

        public SearchUrl() {
        }

        public SearchUrl(UUID id, String siteName, String searchUrl) {
            this.id = id;
            this.siteName = siteName;
            this.searchUrl = searchUrl;
        }

        public UUID getId() {
            return id;
        }

        public String getSiteName() {
            return siteName;
        }

        public void setSiteName(String siteName) {
            this.siteName = siteName;
        }

        public String getSearchUrl() {
            return searchUrl;
        }

        public void setSearchUrl(String searchUrl) {
            this.searchUrl = searchUrl;
        }

}
