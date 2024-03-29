package com.portfolio.fb.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Getter
@Setter
@Entity
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id_skill;
    @NotNull
    private String name;
    private String icon;
    @NotNull
    @Min(1)
    @Max(100)
    private int lvl;

    public Skill() {
    }

    public Skill(Long id_skill, String name, String icon, int lvl) {
        this.id_skill = id_skill;
        this.name = name;
        this.icon = icon;
        this.lvl = lvl;
    }

    @Override
    public String toString() {
        return "Skill{" +
                "id_skill=" + id_skill +
                ", name='" + name + '\'' +
                ", icon='" + icon + '\'' +
                ", lvl=" + lvl +
                '}';
    }
}
