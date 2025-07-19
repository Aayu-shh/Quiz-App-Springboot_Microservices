package com.cgtrac.question_service.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "question_title")
    private String questionTitle;

    private String category;

    private String option1;

    private String option2;

    private String option3;

    private String option4;

    @Column(name = "difficulty_level")
    private String difficultyLevel;

    @Column(name = "right_answer")
    private String rightAnswer;

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", questionTitle='" + questionTitle + '\'' +
                ", category='" + category + '\'' +
                ", option1='" + option1 + '\'' +
                ", option2='" + option2 + '\'' +
                ", option3='" + option3 + '\'' +
                ", option4='" + option4 + '\'' +
                ", difficultyLevel='" + difficultyLevel + '\'' +
                ", rightAnswer='" + rightAnswer + '\'' +
                '}';
    }
}