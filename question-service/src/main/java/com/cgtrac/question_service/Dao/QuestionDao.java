package com.cgtrac.question_service.Dao;

import com.cgtrac.question_service.Model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question,Integer> {
    List<Question> findByCategory(String category);

    @Query(value = "SELECT q.id FROM question q WHERE q.category=:category ORDER BY RANDOM() LIMIT :numOfQuestions",nativeQuery = true)
    List<Integer> findRandomQuestionByCategory(String category, Integer numOfQuestions);
}
