import 'package:flutter/material.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  String _name = 'Ashraf';
  String _jobRoll = 'FLUTTER DEVELOPER';
  String _phone = '+201553550608';
  String _email = 'Ashraf.Mohamed4728@gmail.com';

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        backgroundColor: Colors.teal,
        body: SafeArea(
          child: Container(
            color: Colors.teal,
            child: Column(
              mainAxisAlignment: MainAxisAlignment.center,
              children: <Widget>[
                CircleAvatar(
                  radius: 50.0,
                  backgroundColor: Colors.teal,
                  backgroundImage: AssetImage('images/flame-2.png'),
                ),
                Text(
                  '$_name',
                  style: TextStyle(
                    fontSize: 40.0,
                    fontFamily: 'Pacifico',
                    fontWeight: FontWeight.bold,
                    color: Colors.white,
                  ),
                ),
                Text(
                  '$_jobRoll',
                  style: TextStyle(
                    color: Colors.teal[200],
                    fontSize: 20.0,
                    fontFamily: 'SourceSansPro',
                    letterSpacing: 2.5,
                    fontWeight: FontWeight.bold,
                  ),
                ),
                SizedBox(
                  height: 30.0,
                  child: Divider(
                    color: Colors.white,
                    thickness: 1.0,
                    indent: 10.0,
                    endIndent: 10.0,
                  ),
                ),
                Card(
                  color: Colors.white,
                  margin:
                      EdgeInsets.symmetric(horizontal: 10.0, vertical: 10.0),
                  child: ListTile(
                      leading: Icon(
                        Icons.phone,
                        color: Colors.teal,
                      ),
                      title: Text(
                        '$_phone',
                        style: TextStyle(
                          color: Colors.teal,
                          fontSize: 16.0,
                          fontFamily: 'SourceSansPro',
                          fontWeight: FontWeight.bold,
                        ),
                      )),
                ),
                Card(
                  color: Colors.white,
                  margin:
                      EdgeInsets.symmetric(vertical: 10.0, horizontal: 10.0),
                  child: ListTile(
                    leading: Icon(
                      Icons.email,
                      color: Colors.teal,
                    ),
                    title: Text(
                      '$_email',
                      style: TextStyle(
                        color: Colors.teal,
                        fontSize: 15.0,
                        fontFamily: 'SourceSansPro',
                        fontWeight: FontWeight.bold,
                      ),
                    ),
                  ),
                ),
              ],
            ),
          ),
        ),
      ),
    );
  }

  Widget child({Color color, var height, var width, var num}) {
    return Container(color: color, height: 100.0, width: 100.9);
  }
}
