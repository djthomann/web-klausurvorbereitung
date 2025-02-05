package de.hsrm.mi.web.klausurvorbereitung.klausurvorbereitung.api.stadt;

import de.hsrm.mi.web.klausurvorbereitung.klausurvorbereitung.entitities.stadt.Stadt;

public record StadtDTO(String name, int einwohner) {
    
    public static Stadt toStadt(StadtDTO s) {
        return new Stadt(s.name(), s.einwohner());
    }

    public static StadtDTO fromStadt(Stadt s) {
        return new StadtDTO(s.getName(), s.getEinwohner());
    }

}
