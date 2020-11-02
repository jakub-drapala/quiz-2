package com.drapala.quiz2.controller;

import com.drapala.quiz2.request.ClientsFormRequest;
import com.drapala.quiz2.response.SingleValueResponse;
import com.drapala.quiz2.service.ClientsFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class ClientsFormController {

    private final ClientsFormService clientsFormService;

    @Autowired
    public ClientsFormController(ClientsFormService clientsFormService) {
        this.clientsFormService = clientsFormService;
    }

    @PostMapping("/admin/quiz")
    @ResponseStatus(HttpStatus.CREATED)
    public SingleValueResponse create(@RequestBody @Valid ClientsFormRequest clientsFormRequest) {
        return SingleValueResponse.of(clientsFormService.create(clientsFormRequest));
    }
}
