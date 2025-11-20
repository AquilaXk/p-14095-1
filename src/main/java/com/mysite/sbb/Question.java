package com.mysite.sbb;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.time.LocalDate;
import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Setter
@Getter
public class Question {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private int id;

    private LocalDate createDate;

    @Column(length = 200)
    private String subject;

    @Column(columnDefinition = "TEXT")
    private String content;

    @OneToMany(mappedBy = "question", cascade =  CascadeType.REMOVE) // OneToMany를 사용할 때 는 변수명 적어야한다
    private List<Answer> answers;
}
