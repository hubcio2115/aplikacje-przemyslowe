package zad1.domains;

import java.util.UUID;

public record Country(UUID id, String name, long gdp, long area, long population) {}
