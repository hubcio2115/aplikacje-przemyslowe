package org.example.springguide.domains.country;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.springguide.domains.citizen.Citizen;
import org.example.springguide.domains.city.City;
import org.example.springguide.domains.ruler.Ruler;

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

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "country", cascade = CascadeType.DETACH)
    private Set<City> cities;

    @ManyToMany(mappedBy = "countries", fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    private Set<Citizen> citizens;
}
