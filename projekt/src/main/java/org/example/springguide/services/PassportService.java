package org.example.springguide.services;

import lombok.AllArgsConstructor;
import org.example.springguide.domains.passport.Passport;
import org.example.springguide.repositories.PassportRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class PassportService {
    private final PassportRepository passportRepository;

    public Passport addPassport(Passport passport) {
        return this.passportRepository.save(passport);
    }

    public Optional<Passport> getById(long id) {
        return this.passportRepository.findById(id);
    }

    public Optional<Passport> deleteById(long id) {
        var passport = this.passportRepository.findById(id);
        passport.ifPresent(this.passportRepository::delete);
        return passport;
    }
}
