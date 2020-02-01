import 'package:flutter/material.dart';

void main() => runApp(
      MaterialApp(
        home: Scaffold(
            backgroundColor: Colors.blueGrey[300],
            appBar: AppBar(
              title: Text('I\'m Rich'),
              centerTitle: true,
              backgroundColor: Colors.blueGrey[900],
            ),
            body: Column(
              children: [
                Image(
                  image: AssetImage('images/diamond.png'),
                ),
                Image(
                  image: NetworkImage(
                      'https://upload.wikimedia.org/wikipedia/commons/1/17/Google-flutter-logo.png'),
                )
              ],
            )),
      ),
    );
