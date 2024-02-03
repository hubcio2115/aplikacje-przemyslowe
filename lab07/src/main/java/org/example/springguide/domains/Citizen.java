package org.example.springguide.domains;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    private String citizenName;

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
