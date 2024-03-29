package org.example.springguide.domains.citizen;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.springguide.domains.passport.Passport;
import org.example.springguide.domains.country.Country;

import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Citizen {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @Column(name = "last_name")
    private String lastName;

    @ManyToMany
    @JoinTable(
            name = "country_citizen",
            joinColumns = @JoinColumn(name = "country_id"),
            inverseJoinColumns = @JoinColumn(name = "citizen_id")
    )
    private Set<Country> countries;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "citizen", cascade = CascadeType.ALL, optional = false)
    private Passport passport;
}
