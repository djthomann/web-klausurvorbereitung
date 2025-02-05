package de.hsrm.mi.web.klausurvorbereitung.ui.benutzer;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;

public class BenutzerFormular {

    @NotBlank
    private String name;

    @Email(message="Ernsthaft, ${validatedValue} soll eine Mailadresse sein?")
    private String mail;

    @NotBlank
    private String password;

    @Past
    private LocalDate birthday;

    private String like;
    private String dislike;
    private Set<String> likes;
    private Set<String> dislikes;

    public BenutzerFormular() {
        name = "";
        mail = "";
        password = "";
        like = "";
        dislike = "";
        likes = new HashSet<>();
        dislikes = new HashSet<>();
    }
    
    public String getLike() {
        return like;
    }
    public void setLike(String like) {
        this.like = like;
    }
    public String getDislike() {
        return dislike;
    }
    public void setDislike(String dislike) {
        this.dislike = dislike;
    }
    public void addDislike(String dislike) {
        dislikes.add(dislike);
    }
    public Set<String> getLikes() {
        return likes;
    }
    public void setLikes(Set<String> likes) {
        this.likes = likes;
    }
    public void addLike(String like) {
        likes.add(like);
    }
    public Set<String> getDislikes() {
        return dislikes;
    }
    public void setDislikes(Set<String> dislikes) {
        this.dislikes = dislikes;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getMail() {
        return mail;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    
}
