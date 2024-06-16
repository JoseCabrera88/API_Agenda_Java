package Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name ="tareas")
@Getter
@Setter
public class Agenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "No puede estar vacio")
    @NotEmpty(message = "No puede estar vacio")
    private String name;

    @Column(name ="created_at")
    @Temporal(TemporalType.DATE)
    private Date createdAt;

}
