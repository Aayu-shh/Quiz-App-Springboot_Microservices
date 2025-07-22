package com.cgtrac.question_service.Service;

import com.cgtrac.question_service.Dao.QuestionDao;
import com.cgtrac.question_service.Model.Question;
import com.cgtrac.question_service.Model.QuestionWrapper;
import com.cgtrac.question_service.Model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<List<Question>> getAllQuestions() {
        try {
            return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public List<Question> getQuestionsByCategory(String category) {
        return questionDao.findByCategory(category);
    }

    public ResponseEntity<String> addQuestion(Question question) {
        try {
            questionDao.save(question);
            return new ResponseEntity<>("success", HttpStatus.CREATED);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>("Something Went Wrong",HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> deleteQuestion(Integer id) {
        try {
            questionDao.deleteById(id);
            return new ResponseEntity<>("Succesfully Deleted", HttpStatus.OK);
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
        }

    public ResponseEntity<List<Integer>> getQuestionsForQuiz(String categoryName, Integer numQuestions) {
        List<Integer> questions = questionDao.findRandomQuestionByCategory(categoryName,numQuestions);
        return new ResponseEntity<>(questions, HttpStatus.OK);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(List<Integer> questionsId) {
        List<QuestionWrapper> wrappers = new ArrayList<>();
        List<Question> questions = new ArrayList<>();
        for(Integer id:questionsId){
            questions.add(questionDao.findById(id).orElse(null));
        }
        for(Question question:questions){
            if(null!=question){
                QuestionWrapper questionWrapper = new QuestionWrapper();
                questionWrapper.setId(question.getId());
                questionWrapper.setQuestionTitle(question.getQuestionTitle());
                questionWrapper.setOption1(question.getOption1());
                questionWrapper.setOption2(question.getOption2());
                questionWrapper.setOption3(question.getOption3());
                questionWrapper.setOption4(question.getOption4());
                wrappers.add(questionWrapper);
            }
            else{
                wrappers.add(null);
            }
        }
        return new ResponseEntity<>(wrappers,HttpStatus.OK);
    }

    public ResponseEntity<Integer> getScore(List<Response> userResponses) {
            int score = 0;
            for (Response myQuizRes:userResponses){
                Question myQuestion = questionDao.findById( myQuizRes.getId()).orElse(new Question());
                if(Objects.equals(myQuizRes.getResponse(),myQuestion.getRightAnswer()))
                    score++;
            }
            return new ResponseEntity<>(score,HttpStatus.OK);

    }
}
