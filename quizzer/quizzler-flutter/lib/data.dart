import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:quizzler/Alert.dart';

import 'Question.dart';

class Data {
  AlertManager alertManager = AlertManager();
  int _questionNumber = 0;
  int _rightAnswers = 0;
  List<Question> _questions = [
    Question('Some cats are actually allergic to humans', true),
    Question('You can lead a cow down stairs but not up stairs.', false),
    Question('Approximately one quarter of human bones are in the feet.', true),
    Question('A slug\'s blood is green.', true),
    Question('Buzz Aldrin\'s mother\'s maiden name was \"Moon\".', true),
    Question('It is illegal to pee in the Ocean in Portugal.', true),
    Question(
        'No piece of square dry paper can be folded in half more than 7 times.',
        false),
    Question(
        'In London, UK, if you happen to die in the House of Parliament, you are technically entitled to a state funeral, because the building is considered too sacred a place.',
        true),
    Question(
        'The loudest sound produced by any animal is 188 decibels. That animal is the African Elephant.',
        false),
    Question(
        'The total surface area of two human lungs is approximately 70 square metres.',
        true),
    Question('Google was originally called \"Backrub\".', true),
    Question(
        'Chocolate affects a dog\'s heart and nervous system; a few ounces are enough to kill a small dog.',
        true),
    Question(
        'In West Virginia, USA, if you accidentally hit an animal with your car, you are free to take it home to eat.',
        true),
  ];

  List<Icon> listOfAnswerIcon = [];

  int getQuestionNumber() => _questionNumber;
  Icon getChoiceIcon(bool isRight) {
    return (isRight)
        ? Icon(
            Icons.check,
            color: Colors.green,
          )
        : Icon(Icons.close, color: Colors.red);
  }

  List<Icon> getListofAnswerIcons() => listOfAnswerIcon;

  //add icon into list

  void addIcon(bool b) {
    listOfAnswerIcon.add(getChoiceIcon(b));
  }

  Question getQuestion() => _questions[_questionNumber];

  List<Question> getList() => _questions;

  deleteQuestion(int index) {
    _questions.removeAt(index);
  }

  addQuestion(Question question) {
    _questions.add(question);
  }

  bool getAnswer(int questionNumber) {
    return _questions[questionNumber].getAnswer();
  }

  void nextQuestion(context, int rightAnswers, int questionNumbers) {
    if (_questionNumber < _questions.length - 1) {
      _questionNumber++;
    } else {
      alertManager.onBasicAlertPressed(context, rightAnswers, questionNumbers);
      _questionNumber = 0;
      _rightAnswers = 0;
      listOfAnswerIcon.clear();
    }
  }

  void checkAnswer(bool answer) {
    if (this.getQuestion().getAnswer() == answer) {
      _rightAnswers++;
      print("right answers: $_rightAnswers");
      this.addIcon(true);
    } else {
      this.addIcon(false);
    }
  }

  int getRightAnswers() => _rightAnswers;
}
