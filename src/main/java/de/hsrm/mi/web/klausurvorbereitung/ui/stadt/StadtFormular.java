package de.hsrm.mi.web.klausurvorbereitung.ui.stadt;

import de.hsrm.mi.web.klausurvorbereitung.klausurvorbereitung.entitities.stadt.Stadt;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class StadtFormular {

    @NotBlank
    @NotNull
    private String name;

    @Min(10000)
    private int einwohner;

    public StadtFormular() {
        this("", 0);
    }

    public StadtFormular(String name, int einwohner) {
        this.name = name;
        this.einwohner = einwohner;
    }

    public void toStadt(Stadt s) {
        s.setName(name);
        s.setEinwohner(einwohner);
    }

    public void fromStadt(Stadt s) {
        name = s.getName();
        einwohner = s.getEinwohner();
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getEinwohner() {
        return einwohner;
    }
    public void setEinwohner(int einwohner) {
        this.einwohner = einwohner;
    }

}
