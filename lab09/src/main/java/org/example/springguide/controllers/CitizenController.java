package org.example.springguide.controllers;

import lombok.AllArgsConstructor;
import org.example.springguide.domains.citizen.Citizen;
import org.example.springguide.domains.citizen.CitizenDTO;
import org.example.springguide.services.CitizenService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/citizens")
@AllArgsConstructor
public class CitizenController {
    private final CitizenService citizenService;

    @GetMapping("{id}")
    public ResponseEntity<Optional<Citizen>> getCitizenById(@PathVariable long id) {
        var citizen = this.citizenService.getById(id);

        if (citizen.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(citizen);
    }

    @PostMapping
    public ResponseEntity<Citizen> addCitizen(CitizenDTO citizen) {
        var newCitizen = Citizen.builder()
                .name(citizen.name())
                .lastName(citizen.lastName())
                .build();

        return ResponseEntity.ok(this.citizenService.addCitizen(newCitizen));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Optional<Citizen>> deleteCitizen(@PathVariable long id) {
        var deletedCitizen = this.citizenService.deleteById(id);

        if (deletedCitizen.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(deletedCitizen);
    }
}
