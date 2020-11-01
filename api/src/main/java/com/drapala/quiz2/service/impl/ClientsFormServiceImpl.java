package com.drapala.quiz2.service.impl;

import com.drapala.quiz2.model.ClientsForm;
import com.drapala.quiz2.repository.ClientsFormRepository;
import com.drapala.quiz2.request.ClientsFormRequest;
import com.drapala.quiz2.service.ClientsFormService;
import com.drapala.quiz2.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientsFormServiceImpl implements ClientsFormService {

    private final ClientsFormRepository clientsFormRepository;
    private final QuizService quizService;

    @Autowired
    public ClientsFormServiceImpl(ClientsFormRepository clientsFormRepository, QuizService quizService) {
        this.clientsFormRepository = clientsFormRepository;
        this.quizService = quizService;
    }

    @Override
    public String create(ClientsFormRequest clientsFormRequest) {
        var clientsForm = ClientsForm.of(clientsFormRequest);
        clientsForm.setQuiz(quizService.getById(clientsFormRequest.getQuizId()));
        clientsFormRepository.save(clientsForm);
        return clientsForm.getUid();
    }
}
