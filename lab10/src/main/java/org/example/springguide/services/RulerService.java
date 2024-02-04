package org.example.springguide.services;

import lombok.AllArgsConstructor;
import org.example.springguide.domains.ruler.Ruler;
import org.example.springguide.repositories.RulerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class RulerService {
    private final RulerRepository rulerRepository;

    public Optional<Ruler> getById(long id) {
        return this.rulerRepository.findById(id);
    }

    public Ruler addRuler(Ruler newRuler) {
        return this.rulerRepository.save(newRuler);
    }

    public Optional<Ruler> deleteById(long id) {
        var ruler = this.rulerRepository.findById(id);
        ruler.ifPresent(this.rulerRepository::delete);
        return ruler;
    }
}
