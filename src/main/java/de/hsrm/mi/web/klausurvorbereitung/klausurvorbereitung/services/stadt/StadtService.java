package de.hsrm.mi.web.klausurvorbereitung.klausurvorbereitung.services.stadt;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import de.hsrm.mi.web.klausurvorbereitung.klausurvorbereitung.entitities.stadt.Stadt;

public interface StadtService {
    List<Stadt> alleStaedteHolen();
    Optional<Stadt> holeStadtMitId(long id);

    Stadt speichereStadt(Stadt s);
    void loescheStadtMitId(long id);
}