insert into quizzes(id, title) values (10001, 'Quiz 1');
insert into quizzes(id, title) values (10002, 'Quiz 2');
insert into quizzes(id, title) values (10003, 'Quiz 3');

insert into questions(id, content, quiz_id) values (20001, 'Content 1', 10001);
insert into questions(id, content, quiz_id) values (20002, 'Content 2', 10001);

insert into answers(id, content, correct) values (30001, 'Answer 1', false);

insert into questions_answers(questions_id, answers_id) values (20001, 30001);
