import 'package:flutter/material.dart';

void main()=>runApp(MyApp());

class MyApp extends StatelessWidget{
  @override
  Widget build(BuildContext context){
    return MaterialApp(
      title:"Welcome to Flutter",
      home:Scaffold(
        appBar: AppBar(
          title:Text('Hello World'),
        ),
        body:Center(
          // child:Text('Hello World James Hello World JamesHello World JamesHello World JamesHello World JamesHello World James',
          // textAlign: TextAlign.left,
          // style: TextStyle(
          //   fontSize: 25.0,
          //   color:Color.fromARGB(255, 255, 150, 150),
          //   decoration: TextDecoration.underline,
          //   decorationStyle: TextDecorationStyle.solid
          // ),
          // // maxLines: 2,
          // // overflow: TextOverflow.fade,
          // )
          child: Container(
            child: new Text('Hello James',
            style:TextStyle(fontSize: 40.0),
            ),
            alignment: Alignment.center,
            width: 500.0,
            height: 400.0,
            color:Colors.lightBlue
          ),
        )
      )
    );
  }
} 