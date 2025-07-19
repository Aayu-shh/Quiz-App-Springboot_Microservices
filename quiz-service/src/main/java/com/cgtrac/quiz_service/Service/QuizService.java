package com.cgtrac.quiz_service.Service;

import com.cgtrac.quiz_service.Dao.QuizDao;
import com.cgtrac.quiz_service.Model.QuestionWrapper;
import com.cgtrac.quiz_service.Model.Quiz;
import com.cgtrac.quiz_service.Model.Response;
import com.cgtrac.quiz_service.QuizInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    QuizDao quizDao;

    @Autowired
    QuizInterface quizInterface;

    public ResponseEntity<String> createQuiz(String category, Integer numOfQuestions, String title) {
        Quiz quiz = new Quiz();
        // Quiz service calling Question Service for "questions"
        //For call question/generate request | RestTemplate HTTP Web Req -  http://localhost:9080/question/generate - Dont know IP Address/Ports of other service
        // Feign Client - declarative way of requesting service - API u want to hit
        // Service Discovery - Quiz service needs to find Question service - Discover

        List<Integer> questionIds = quizInterface.getQuestionsForQuiz(numOfQuestions,category).getBody();
        quiz.setTitle(title);
        quiz.setQuestionIds(questionIds);
        quizDao.save(quiz);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    //For Developer/Admin to View ALL Data Including RIGHT ANSWER
    public ResponseEntity<List<Quiz>> getAllQuizes() {
        return new ResponseEntity<>(quizDao.findAll(),HttpStatus.OK);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestionsById(Integer quizId) {
        Optional<Quiz> myQuiz = quizDao.findById(quizId);
        if (myQuiz.isPresent()) {
            return quizInterface.getQuestionsFromId(myQuiz.get().getQuestionIds());
        } else {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }
    public ResponseEntity<String> calculateResult(Integer quizId, List<Response> myQuizResponses) {
        //Interaction with Question Directly
            int score = quizInterface.getScore(myQuizResponses).getBody();
            return new ResponseEntity<>(String.format("Number of Correct Answers: %d ",score),HttpStatus.OK);
        }
    }
