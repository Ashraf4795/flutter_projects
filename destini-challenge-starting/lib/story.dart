class Story {
  String storyTitle;
  String choice1;
  String choice2;

  Story({String storyTitle, String choice1, String choice2}) {
    this.storyTitle = storyTitle;
    this.choice1 = choice1;
    this.choice2 = choice2;
  }

  //getter
  String getStoryTitle() => storyTitle;
  String getStoryChoice1() => choice1;
  String getStoryChoice2() => choice2;

  //setter

  void setStoryTitle(String t) {
    storyTitle = t;
  }

  void setChoice1(String c1) {
    choice1 = c1;
  }

  void setChoice2(String c2) {
    choice2 = c2;
  }
}
