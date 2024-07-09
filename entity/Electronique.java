package org.example.tp_projet.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;

@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Electronique  extends Article{
    private String batterieDuration;

    @Override
    public String toString() {
        return "Electronique{" +
                "batterieDuration='" + batterieDuration + '\'' +
                "} " + super.toString();
    }
}
