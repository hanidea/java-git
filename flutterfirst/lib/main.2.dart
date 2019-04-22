import 'package:flutter/material.dart';

void main()=>runApp(MyApp(
  items:new List<String>.generate(1000,(i)=>"Item $i")
));

class MyApp extends StatelessWidget{
  final List<String> items;
  MyApp({Key key, @required this.items}):super(key:key);
  @override
  Widget build (BuildContext context){
    return MaterialApp(
      title:'flutter demo',
      home :Scaffold(
        appBar: new AppBar(
          title:new Text('ListView widget')
        ),
        body:new ListView.builder(
          itemCount: items.length,
          itemBuilder:(context,index){
            return new ListTile(
              title:new Text('${items[index]}')
            );
          }
        )
        // body:Center(
        //   child: Container(
        //     height: 200.0,
        //     child: MyList()
        //   ),
        // )
        // body:new ListView(
        //   children: <Widget>[
        //     new Image.network('http://www.51hanhan.com/hanku/wp-content/uploads/2019/03/vola-cars-app-ui-1200x400.jpg'),
        //     new Image.network('http://www.51hanhan.com/hanku/wp-content/uploads/2019/03/50-location-element-icons-1200x400.jpg'),
        //     new Image.network('http://www.51hanhan.com/hanku/wp-content/uploads/2019/03/30-time-management-element-icons-1200x400.jpg'),
        //     new Image.network('http://www.51hanhan.com/hanku/wp-content/uploads/2019/03/vola-cars-app-ui-1200x400.jpg'),
        //     new Image.network('http://www.51hanhan.com/hanku/wp-content/uploads/2019/03/50-location-element-icons-1200x400.jpg'),
        //     new Image.network('http://www.51hanhan.com/hanku/wp-content/uploads/2019/03/30-time-management-element-icons-1200x400.jpg'),
        //     // new ListTile(
        //     //   leading:new Icon(Icons.border_right),
        //     //   title:new Text('border_right')
        //     // ),
        //     // new ListTile(
        //     //   leading:new Icon(Icons.border_left),
        //     //   title:new Text('border_left')
        //     // ),
        //     // new ListTile(
        //     //   leading:new Icon(Icons.border_top),
        //     //   title:new Text('border_top')
        //     // )
        //   ],
        // )
      )
    );
  }
}

class MyList extends StatelessWidget{
 @override
 Widget build (BuildContext context){
    return ListView(
      scrollDirection: Axis.horizontal,
              children: <Widget>[
                new Container(
                  width:180.0,
                  color:Colors.lightBlue
                ),
                new Container(
                  width:180.0,
                  color:Colors.amber
                ),
                new Container(
                  width:180.0,
                  color:Colors.deepOrange
                ),
                new Container(
                  width:180.0,
                  color:Colors.deepPurpleAccent
                ),
              ],
    );
  }
}