import 'package:flutter/material.dart';
import 'package:rflutter_alert/rflutter_alert.dart';

class AlertManager {
  onBasicAlertPressed(context, int rightAnswers, int questionNumber) {
    Alert(
      context: context,
      title: "Finished",
      desc: "your score $rightAnswers/$questionNumber",
    ).show();
  }

  onButtonAlertPressed(context) {
    Alert(
      context: context,
      title: "finished",
      type: AlertType.info,
      desc: "you finished yoiur",
      buttons: [
        DialogButton(
            child: Icon(
              Icons.check,
              color: Colors.white,
            ),
            color: Colors.green,
            radius: BorderRadius.all(Radius.circular(15)),
            onPressed: () {
              print("check is clicked");
            }),
        DialogButton(
            child: Icon(
              Icons.close,
              color: Colors.white,
            ),
            color: Colors.red,
            radius: BorderRadius.all(Radius.circular(15)),
            onPressed: () {
              print("close is clicked");
            }),
      ],
    ).show();
  }
}
