package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;


@Entity

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyBooks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BookID")
    private Long BookId;

    @Column(name = "BookName")
    private String bookName;

    @Column(name = "name")
    private String name;

    @Column(name = "BookDescription")
    private String BookDescription;

    @ToString.Exclude
   @ManyToOne
   @JoinColumn(name="ID")
    private MyEntity entity;

}
