package org.example.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.entity.MyBooks;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "my_entity")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "eid")
    private Long id;

    @Column(name = "ename")
    private String name;

    @Column(name = "edescription")
    private String description;

    @OneToMany
    @JoinColumn(name = "my_entity_id")
    private List<MyBooks> books;
}
