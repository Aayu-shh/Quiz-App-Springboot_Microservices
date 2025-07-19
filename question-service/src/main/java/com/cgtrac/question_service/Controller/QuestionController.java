package com.cgtrac.question_service.Controller;

import com.cgtrac.question_service.Model.Question;
import com.cgtrac.question_service.Model.QuestionWrapper;
import com.cgtrac.question_service.Model.Response;
import com.cgtrac.question_service.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {


    private final QuestionService questionService;

    @Autowired
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Autowired
    Environment environment;

    @GetMapping("allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    @GetMapping("category/{category}")
    public List<Question> getQuestionsByCategory(@PathVariable String category) {
        return questionService.getQuestionsByCategory(category);
    }

    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question) {
        System.out.println("request from frontend: " + question);
        return questionService.addQuestion(question);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteQuestion(@RequestParam Integer id){
     return questionService.deleteQuestion(id);
    }

    // Services USED by Quiz Service

    //Generate (QuestionId)
    @GetMapping("generate")
    public ResponseEntity<List<Integer>> getQuestionsForQuiz(@RequestParam Integer numQuestions,@RequestParam String categoryName){
        return questionService.getQuestionsForQuiz(categoryName,numQuestions);
    }

    //get/questionId
    @PostMapping("getQuestions")
    public  ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(@RequestBody List<Integer> questionsId){
        System.out.println(environment.getProperty("local.server.port"));   //To check Load Balancing between instances running on different Ports
        return questionService.getQuestionsFromId(questionsId);
    }

    // Score
    @PostMapping("getScore")
    public ResponseEntity<Integer> getScore(@RequestBody List<Response> userResponses){
        return questionService.getScore(userResponses);
    }
}
