package org.example.tp_projet.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;

@Entity
@SuperBuilder
@NoArgsConstructor
@Data
public class Electronique  extends Article{
    private int batterieDuration;
}
