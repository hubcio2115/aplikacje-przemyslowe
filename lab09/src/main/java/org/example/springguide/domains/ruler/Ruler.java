package org.example.springguide.domains.ruler;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.springguide.domains.country.Country;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Ruler {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    private String surname;

    @Column(name = "office_start_date")
    private Date officeStartDate;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    private Country country;
}
