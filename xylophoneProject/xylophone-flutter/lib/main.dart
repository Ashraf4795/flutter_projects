import 'package:audioplayers/audio_cache.dart';
import 'package:flutter/material.dart';

void main() => runApp(XylophoneApp());

class XylophoneApp extends StatelessWidget {
  final AudioCache audioCache = AudioCache();

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      theme: ThemeData(fontFamily: "Pacifico"),
      home: Scaffold(
        appBar: AppBar(
          title: Text(
            "Xylophone",
          ),
          backgroundColor: Colors.red,
          centerTitle: true,
        ),
        body: SafeArea(
          child: Column(
            crossAxisAlignment: CrossAxisAlignment.stretch,
            children: <Widget>[
              getNoteChild(Colors.red, 1),
              getNoteChild(Colors.blue, 2),
              getNoteChild(Colors.green, 3),
              getNoteChild(Colors.yellow, 4),
              getNoteChild(Colors.pink, 5),
              getNoteChild(Colors.redAccent, 6),
              getNoteChild(Colors.deepPurple, 7),
            ],
          ),
        ),
      ),
    );
  }

  //return a child with custom color and note number
  Widget getNoteChild(Color color, int NoteNumber) {
    return Expanded(
      child: Padding(
        padding: const EdgeInsets.all(8.0),
        child: Card(
          shape: RoundedRectangleBorder(
            borderRadius: BorderRadius.circular(10.0),
          ),
          color: color,
          child: FlatButton(
            onPressed: () {
              playNote(NoteNumber);
            },
          ),
        ),
      ),
    );
  }

  //get note number and play the audio file
  playNote(int noteNumber) {
    audioCache.play("note$noteNumber.wav");
  }
}
