import 'package:flutter/material.dart';
import 'dart:math';

void main() => runApp(
      MaterialApp(
        home: ballPage(),
      ),
    );

class ballPage extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.lightBlueAccent,
      appBar: AppBar(
        title: Text("Ask Me Anything"),
        backgroundColor: Colors.blueAccent,
      ),
      body: ball(),
    );
  }
}

class ball extends StatefulWidget {
  @override
  _ballState createState() => _ballState();
}

class _ballState extends State<ball> {
  int ballNumber = 1;
  @override
  Widget build(BuildContext context) {
    return Column(
      mainAxisSize: MainAxisSize.max,
      children: <Widget>[
        Padding(
          padding: const EdgeInsets.only(top: 16.0),
          child: Text(
            "Welcome, Ask your Question...",
            style: TextStyle(
              fontFamily: "fonts/BebasNeue-Regular.ttf",
              fontSize: 24.0,
              fontStyle: FontStyle.normal,
              color: Colors.white,
            ),
          ),
        ),
        Container(
          //color: Colors.lightBlueAccent,
          child: Expanded(
            child: Center(
              child: FlatButton(
                onPressed: () => getBall(),
                child: Image.asset("images/ball$ballNumber.png"),
              ),
            ),
          ),
        ),
      ],
    );
  }

  getBall() {
    setState(() {
      ballNumber = Random().nextInt(5) + 1;
      print("image number : $ballNumber");
    });
  }
}
