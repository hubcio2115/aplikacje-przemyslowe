package org.example.springguide.domains.citizen;

import java.io.Serializable;

public record CitizenDTO (String name, String lastName) implements Serializable {
}
