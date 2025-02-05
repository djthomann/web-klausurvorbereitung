package de.hsrm.mi.web.klausurvorbereitung.klausurvorbereitung.services.stadt;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.hsrm.mi.web.klausurvorbereitung.klausurvorbereitung.entitities.stadt.Stadt;
import de.hsrm.mi.web.klausurvorbereitung.klausurvorbereitung.entitities.stadt.StadtRepository;

@Service
public class StadtServiceImpl implements StadtService {

    Logger logger = LoggerFactory.getLogger(StadtServiceImpl.class);

    private StadtRepository stadtRepository;

    @Autowired
    public StadtServiceImpl(StadtRepository stadtRepository) {
        this.stadtRepository = stadtRepository;
    }

    @Override
    public List<Stadt> alleStaedteHolen() {
        logger.info("Alle Städte holen");
        return stadtRepository.findAll();
    }

    @Override
    public Optional<Stadt> holeStadtMitId(long id) {
        logger.info("Finde Stadt mit Id:" + id);
        return stadtRepository.findById(id);
    }

    @Override
    public Stadt speichereStadt(Stadt s) {
        logger.info("Speicher Stadt: " + s.toString());
        return stadtRepository.save(s);
    }

    @Override
    public void loescheStadtMitId(long id) {
        logger.info("Lösche Stadt mit Id: " + id);
        stadtRepository.deleteById(id);    
    }
    
}
