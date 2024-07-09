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
public class Nourriture extends Article{
    private String datePeremption;

    @Override
    public String toString() {
        return "Nourriture{" +
                "datePeremption='" + datePeremption + '\'' +
                "} " + super.toString();
    }
}
