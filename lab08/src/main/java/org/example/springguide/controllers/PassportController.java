package org.example.springguide.controllers;

import lombok.AllArgsConstructor;
import org.example.springguide.domains.passport.Passport;
import org.example.springguide.domains.passport.PassportDTO;
import org.example.springguide.services.PassportService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/passports")
@AllArgsConstructor
public class PassportController {
    private final PassportService passportService;

    @GetMapping("{id}")
    public ResponseEntity<Optional<Passport>> getPassportById(@PathVariable long id) {
        var passport = this.passportService.getById(id);

        if (passport.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(passport);
    }

    @PostMapping
    public ResponseEntity<Passport> addPassport(@RequestBody PassportDTO passport) {
        var newPassport = Passport.builder()
                .serialNumber(passport.serialNumber())
                .build();

        return ResponseEntity.ok(this.passportService.addPassport(newPassport));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Optional<Passport>> deletePassport(@PathVariable long id) {
        var deletedPassport = this.passportService.deleteById(id);

        if (deletedPassport.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(deletedPassport);
    }
}
