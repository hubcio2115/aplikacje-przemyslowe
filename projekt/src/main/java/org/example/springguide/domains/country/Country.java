package org.example.springguide.domains.country;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
  private Long id;

  private String name;

  private long gdp;

  @Column(name = "is_in_europe")
  private boolean isInEurope;

  @Column(name = "formation_year")
  private Year formationYear;

  @OneToOne(fetch = FetchType.LAZY, mappedBy = "country", cascade = CascadeType.ALL)
  @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
  private Ruler ruler;

  @OneToMany(
      fetch = FetchType.LAZY,
      mappedBy = "country",
      cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH})
  @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
  private Set<City> cities;

  @ManyToMany(
      fetch = FetchType.LAZY,
      mappedBy = "countries",
      cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH})
  @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
  private Set<Citizen> citizens;
}
