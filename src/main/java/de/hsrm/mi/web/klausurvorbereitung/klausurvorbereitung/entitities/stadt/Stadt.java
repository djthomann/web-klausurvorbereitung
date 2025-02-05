package de.hsrm.mi.web.klausurvorbereitung.klausurvorbereitung.entitities.stadt;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Version;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Stadt {
    
    @Id
    @GeneratedValue
    private long id;

    @Version
    private long version;

    @NotNull
    @NotBlank
    private String name;

    @Min(10000)
    private int einwohner;

    public Stadt() {
        this("", 0);
    }

    public Stadt(String name, int einwohner) {
        this.name = name;
        this.einwohner = einwohner;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }


}
