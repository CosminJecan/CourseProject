package ro.siit.myOfferProject.repozitory;

import org.springframework.data.repository.CrudRepository;
import ro.siit.myOfferProject.entity.SearchUrl;
import java.util.UUID;

public interface UrlRepozitory extends CrudRepository<SearchUrl, UUID> {

   }
