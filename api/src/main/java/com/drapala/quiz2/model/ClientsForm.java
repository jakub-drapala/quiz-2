package com.drapala.quiz2.model;

import com.drapala.quiz2.request.ClientsFormRequest;
import com.google.common.hash.Hashing;

import javax.persistence.*;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Entity
public class ClientsForm {

    @Id
    private String uid;
    private String clientsName;
    private int questionsAmount;
    private int timeInSec;
    @OneToOne(fetch = FetchType.LAZY)
    private Quiz quiz;
    @OneToMany(mappedBy = "clientsForm")
    private List<ClientsQuestion> clientsQuestions;

    public ClientsForm() {
    }

    public static ClientsForm of(ClientsFormRequest clientsFormRequest) {
        var clientsForm = new ClientsForm();
        clientsForm.setClientsName(clientsFormRequest.getClientsName());
        clientsForm.setQuestionsAmount(clientsFormRequest.getQuestionsAmount());
        clientsForm.setUid(generateUid(clientsFormRequest.getClientsName()));
        return clientsForm;
    }

    private static String generateUid(String clientsName) {
        return Hashing
                .sha256()
                .hashString(System.currentTimeMillis() + clientsName, StandardCharsets.UTF_8).toString();
    }

    public void addQuestion(ClientsQuestion question) {
        clientsQuestions.add(question);
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getClientsName() {
        return clientsName;
    }

    public void setClientsName(String clientsName) {
        this.clientsName = clientsName;
    }

    public int getQuestionsAmount() {
        return questionsAmount;
    }

    public void setQuestionsAmount(int questionsAmount) {
        this.questionsAmount = questionsAmount;
    }

    public int getTimeInSec() {
        return timeInSec;
    }

    public void setTimeInSec(int timeInSec) {
        this.timeInSec = timeInSec;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public List<ClientsQuestion> getClientsQuestions() {
        return clientsQuestions;
    }

    public void setClientsQuestions(List<ClientsQuestion> clientsQuestions) {
        this.clientsQuestions = clientsQuestions;
    }
}
