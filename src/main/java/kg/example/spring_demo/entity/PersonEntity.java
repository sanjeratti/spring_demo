package kg.example.spring_demo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Table(name = "persons")
@Entity
@Data
public class PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer age;

    private String gender;

    private String nationality;

    private String surname;

}
