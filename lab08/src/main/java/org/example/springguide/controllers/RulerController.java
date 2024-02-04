package org.example.springguide.controllers;

import lombok.AllArgsConstructor;
import org.example.springguide.domains.ruler.Ruler;
import org.example.springguide.domains.ruler.RulerDTO;
import org.example.springguide.services.RulerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/rulers")
@AllArgsConstructor
public class RulerController {
    private final RulerService rulerService;

    @GetMapping("{id}")
    public ResponseEntity<Optional<Ruler>> getRulerById(@PathVariable long id) {
        var ruler = this.rulerService.getById(id);

        if (ruler.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(ruler);
    }

    @PostMapping
    public ResponseEntity<Ruler> addRuler(@RequestBody RulerDTO ruler) {
        var newRuler = Ruler.builder()
                .name(ruler.name())
                .surname(ruler.surname())
                .officeStartDate(ruler.officeStartDate())
                .build();

        return ResponseEntity.ok(this.rulerService.addRuler(newRuler));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Optional<Ruler>> deleteRuler(@PathVariable long id) {
        var deletedRuler = this.rulerService.deleteById(id);

        if (deletedRuler.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(deletedRuler);
    }
}
