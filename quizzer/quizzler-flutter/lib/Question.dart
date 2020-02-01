class Question {
  String _question;
  bool _answer;

  Question(String q, bool a) {
    _question = q;
    _answer = a;
  }

  String getQuestionText() => _question;
  bool getAnswer() => _answer;

  void setQuestion(String q) {
    _question = q;
  }

  void setAnswer(bool a) {
    _answer = a;
  }
}
