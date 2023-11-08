package com.mysite.sbb.answer;

import java.time.LocalDateTime;

import com.mysite.sbb.question.Question;
import jakarta.persistence.*;
import com.mysite.sbb.user.SiteUser;
import java.util.Set;
import jakarta.persistence.ManyToMany;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime createDate;

    @ManyToOne // 답변은 하나의 질문에 여러개가 달릴 수 있는 구조이다.
    // 따라서 답변은 Many(많은 것)가 되고 질문은 One(하나)이 된다.
    // 따라서 @ManyToOne은 N:1 관계라고 할 수 있다.
    // 이렇게 @ManyToOne 애너테이션을 설정하면 Answer 엔티티의 question 속성과 Question 엔티티가 서로 연결된다.
    // (실제 데이터베이스에서는 ForeignKey 관계가 생성된다.)
    private Question question;

    @ManyToOne
    private SiteUser author;
    private LocalDateTime modifyDate;
    @ManyToMany
    Set<SiteUser> voter;//추천기능

}