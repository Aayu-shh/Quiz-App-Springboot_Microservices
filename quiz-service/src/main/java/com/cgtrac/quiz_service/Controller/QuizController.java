package com.cgtrac.quiz_service.Controller;

import com.cgtrac.quiz_service.Model.QuestionWrapper;
import com.cgtrac.quiz_service.Model.Quiz;
import com.cgtrac.quiz_service.Model.QuizDTO;
import com.cgtrac.quiz_service.Model.Response;
import com.cgtrac.quiz_service.Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestBody QuizDTO quizDTO){
        return quizService.createQuiz(quizDTO.getCategoryName(),quizDTO.getNumQuestions(),quizDTO.getTitle());
    }

    @GetMapping("getAllQuizes")
    public ResponseEntity<List<Quiz>> getAllQuizes(){
        return quizService.getAllQuizes();
    }

    @GetMapping("get/{quizId}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestionsById(@PathVariable Integer quizId){
        return quizService.getQuizQuestionsById(quizId);
    }

    @PostMapping("submit/{quizId}")
    public ResponseEntity<String> submitQuiz(@PathVariable Integer quizId, @RequestBody List<Response> myQuizResponses){
        return quizService.calculateResult(quizId,myQuizResponses);
    }
}
