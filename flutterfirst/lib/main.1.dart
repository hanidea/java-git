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
          child:Container(
            child: new Image.network(
              'http://img14.360buyimg.com/uba/jfs/t1/8543/6/11560/22014/5c2c6136E8023ac0a/6abbd9de10999c48.png',
              scale:2.0,
              // fit:BoxFit.scaleDown
              // color:Colors.greenAccent,
              // colorBlendMode: BlendMode.color,
              repeat: ImageRepeat.repeatY,
            ),
            width:400.0,
            height:300.0,
            //color:Colors.lightGreen
          )
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
          // child: Container(
          //   child: new Text('Hello James',
          //   style:TextStyle(fontSize: 40.0),
          //   ),
          //   alignment: Alignment.topLeft,
          //   width: 500.0,
          //   height: 400.0,
          //   //color:Colors.lightBlue,
          //   padding:const EdgeInsets.fromLTRB(10.0,30.0,0.0,0.0),
          //   margin: EdgeInsets.all(10.0),
          //   decoration: new BoxDecoration(
          //     gradient: const LinearGradient(
          //       colors:[
          //         Colors.lightBlue,
          //         Colors.greenAccent,
          //         Colors.purple
          //       ]
          //     )
          //   ),
          // ),
        )
      )
    );
  }
} 