package com.spotify.project.models;

import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="artists")
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name="name", nullable=false)
    private String name;

    @Column(name="nationality", nullable=false)
    private String nationality;

    @Column(name="birth_date")
    private Date birthDate;

    @ManyToMany(fetch=FetchType.LAZY,
        cascade = {
            CascadeType.PERSIST,
                CascadeType.MERGE
        },
            mappedBy = "artists")
    @JsonIgnore
    private List<Song> songs;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
