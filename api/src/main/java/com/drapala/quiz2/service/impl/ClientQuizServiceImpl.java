package com.drapala.quiz2.service.impl;

import com.drapala.quiz2.exceptions.ResourceNotFoundException;
import com.drapala.quiz2.model.ClientsForm;
import com.drapala.quiz2.model.ClientsQuestion;
import com.drapala.quiz2.repository.ClientsFormRepository;
import com.drapala.quiz2.repository.ClientsQuestionRepository;
import com.drapala.quiz2.repository.QuestionRepository;
import com.drapala.quiz2.repository.QuizRepository;
import com.drapala.quiz2.service.ClientQuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import static com.drapala.quiz2.exceptions.ResourceNotFoundException.INVALID_UID;
import static com.drapala.quiz2.exceptions.ResourceNotFoundException.QUIZ_NOT_FOUND;

@Service
public class ClientQuizServiceImpl implements ClientQuizService {

    private final ClientsFormRepository clientsFormRepository;
    private final QuizRepository quizRepository;
    private final QuestionRepository questionRepository;
    private final ClientsQuestionRepository clientsQuestionRepository;

    @Autowired
    public ClientQuizServiceImpl(ClientsFormRepository clientsFormRepository,
                                 QuizRepository quizRepository,
                                 QuestionRepository questionRepository,
                                 ClientsQuestionRepository clientsQuestionRepository) {
        this.clientsFormRepository = clientsFormRepository;
        this.quizRepository = quizRepository;
        this.questionRepository = questionRepository;
        this.clientsQuestionRepository = clientsQuestionRepository;
    }

    @Override
    public String getWelcomeMessage(String quizUid) {
        var clientsForm = getByUid(quizUid);
        var quizTitle = quizRepository.findTileByQuizId(clientsForm.getQuiz().getId())
                .orElseThrow(() -> new ResourceNotFoundException(QUIZ_NOT_FOUND));
        return "Cześć " + clientsForm.getClientsName() + "! Zapraszam Cię do wypełnienia quizu: " + quizTitle;
    }

    @Override
    public ClientsQuestion run(String quizUid) {
        var clientsForm = getByUid(quizUid);
        var quiz = clientsForm.getQuiz();
        List<Long> questionsIds = questionRepository.findAllIdByQuizId(quiz.getId());
        Collections.shuffle(questionsIds);
        questionsIds = questionsIds.subList(0, clientsForm.getQuestionsAmount());
        return saveClientQuestionsAndGetFirst(clientsForm, questionsIds);
    }

    private ClientsForm getByUid(String uid) {
        return clientsFormRepository.findById(uid)
                .orElseThrow(() -> new ResourceNotFoundException(INVALID_UID));
    }

    private ClientsQuestion saveClientQuestionsAndGetFirst(ClientsForm clientsForm, List<Long> questionsId) {
        if (questionsId.isEmpty()) { throw new ResourceNotFoundException("Empty questions list!");}
        ClientsQuestion result = null;
        for (Iterator<Long> iterator = questionsId.iterator(); iterator.hasNext();) {
            long questionId = iterator.next();
            var question = questionRepository.findById(questionId).orElseThrow();
            var clientsQuestion = ClientsQuestion.of(question, clientsForm);
            if (!iterator.hasNext())  { clientsQuestion.setLast(true); }
            clientsQuestionRepository.save(clientsQuestion);
            if (Objects.isNull(result)) { result = clientsQuestion; }
        }
        return result;
    }
}
