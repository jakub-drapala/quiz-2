insert into quizzes(id, title) values (10001, 'Quiz 1');
insert into quizzes(id, title) values (10002, 'Quiz 2');
insert into quizzes(id, title) values (10003, 'Quiz 3');

insert into questions(id, content, quiz_id) values (20001, 'Content 1', 10001);
insert into questions(id, content, quiz_id) values (20002, 'Content 2', 10001);

insert into answers(id, content, is_correct, question_id) values (30001, 'Answer 1', false, 20001);
