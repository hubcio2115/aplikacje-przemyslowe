package org.example.springguide.domains.passport;

import java.io.Serializable;

public record PassportDTO (String serialNumber) implements Serializable {
}
