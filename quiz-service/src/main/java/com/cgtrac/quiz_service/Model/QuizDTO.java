package com.cgtrac.quiz_service.Model;

import lombok.Data;

@Data
public class QuizDTO {
    String categoryName;
    String title;
    Integer numQuestions;
}
