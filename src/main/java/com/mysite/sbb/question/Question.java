package com.mysite.sbb.question;

import com.mysite.sbb.answer.Answer;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Setter
@Getter
public class Question {
    // PK(Primary Key) 설정
    @Id
    // AUTO_INCREMENT 설정
    @GeneratedValue(strategy = IDENTITY)
    private int id;

    private LocalDateTime createDate;

    @Column(length = 200)
    private String subject;

    @Column(columnDefinition = "TEXT")
    private String content;
    // FetchType 기본 LAZY
    @OneToMany(mappedBy = "question", cascade = {CascadeType.REMOVE, CascadeType.PERSIST}) // OneToMany를 사용할 때 는 변수명 적어야한다
    private List<Answer> answers = new ArrayList<>();

    public Answer addAnswer(String content) {
        Answer answer = new Answer();
        answer.setContent(content);
        answer.setQuestion(this);
        answer.setCreateDate(LocalDateTime.now());
        answers.add(answer);

        return answer;
    }
}
