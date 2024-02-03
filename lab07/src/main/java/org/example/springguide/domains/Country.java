package org.example.springguide.domains;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Year;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Country implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    private long gdp;

    @Column(name = "is_in_europe")
    private boolean isInEurope;

    @Column(name = "formation_year")
    private Year formationYear;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "country", cascade = CascadeType.ALL)
    private Ruler ruler;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "country", cascade = CascadeType.DETACH)
    private Set<City> cities;

    @ManyToMany(mappedBy = "countries")
    private Set<Citizen> citizens;
}
