package org.example.springguide.domains.ruler;

import java.io.Serializable;
import java.util.Date;

public record RulerDTO(String name, String surname, Date officeStartDate) implements Serializable {
}
