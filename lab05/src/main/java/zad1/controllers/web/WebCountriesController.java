package zad1.controllers.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import zad1.services.CountryService;

import java.util.UUID;

@Controller
public class WebCountriesController {
  private final CountryService countryService;

  public WebCountriesController(CountryService countryService) {
    this.countryService = countryService;
  }

  @GetMapping("/countries")
  public String countries(Model model) {
    model.addAttribute("countries", countryService.getCountries().values().stream().toList());

    return "countries";
  }

  @GetMapping("/countries/{id}")
  public String countriesDetails(@PathVariable UUID id, Model model) {
    model.addAttribute("country", countryService.getById(id));

    return "edit";
  }
}
