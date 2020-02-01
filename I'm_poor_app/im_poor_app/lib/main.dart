import 'package:flutter/material.dart';

void main() => runApp(MaterialApp(
      home: Scaffold(
        appBar: AppBar(title: Text("I'm poor App"), centerTitle: true),
        body: Center(
          child: Image(
            image: AssetImage('Images/flame.png'),
          ),
        ),
      ),
    ));
