package org.example.springguide.services;

import lombok.AllArgsConstructor;
import org.example.springguide.domains.citizen.Citizen;
import org.example.springguide.repositories.CitizenRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CitizenService {
    private final CitizenRepository citizenRepository;

    public Optional<Citizen> getById(long id) {
        return this.citizenRepository.findById(id);
    }

    public Citizen addCitizen(Citizen citizen) {
        return this.citizenRepository.save(citizen);
    }

    public Optional<Citizen> deleteById(long id) {
        var citizen = this.citizenRepository.findById(id);
        citizen.ifPresent(this.citizenRepository::delete);
        return citizen;
    }

    public Iterable<Citizen> findFromACountry(long countryId) {
        return this.citizenRepository.findAllFromACountry(countryId);
    }
}
