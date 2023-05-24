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
    @Column(name = "Bookid")
    private Long BookId;

    @Column(name = "BookName")
    private String bookName;



    @Column(name = "BookDescription")
    private String BookDescription;



}
