import 'package:flutter/material.dart';

void main()=>runApp(MyApp());

class MyApp extends StatelessWidget{
  @override
  Widget build(BuildContext context){
    return MaterialApp(
      title:'电影海报',
      home:Scaffold(
        appBar: AppBar(
          title:Text('电影')
        ),
        body:GridView(
          gridDelegate: SliverGridDelegateWithFixedCrossAxisCount(
            crossAxisCount: 3,
            mainAxisSpacing: 2.0,
            crossAxisSpacing: 2.0,
            childAspectRatio: 0.7,
          ),
          children: <Widget>[
            new Image.network('https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2541240741.jpg',fit:BoxFit.cover),
            new Image.network('https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2549537782.jpg',fit:BoxFit.cover),
            new Image.network('https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2549177902.jpg',fit:BoxFit.cover),
            new Image.network('https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2543631842.jpg',fit:BoxFit.cover),
            new Image.network('https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2552503815.jpg',fit:BoxFit.cover),
            new Image.network('https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2549148229.jpg',fit:BoxFit.cover),
            new Image.network('https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2549329796.jpg',fit:BoxFit.cover),
            new Image.network('https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2520349914.jpg',fit:BoxFit.cover),
            new Image.network('https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2551690865.jpg',fit:BoxFit.cover),
            new Image.network('https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2494632039.jpg',fit:BoxFit.cover),
            new Image.network('https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2552503815.jpg',fit:BoxFit.cover),
            new Image.network('https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2549148229.jpg',fit:BoxFit.cover),
            new Image.network('https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2549329796.jpg',fit:BoxFit.cover),
            new Image.network('https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2520349914.jpg',fit:BoxFit.cover),
            new Image.network('https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2551690865.jpg',fit:BoxFit.cover),
            new Image.network('https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2494632039.jpg',fit:BoxFit.cover),
            new Image.network('https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2541240741.jpg',fit:BoxFit.cover),
            new Image.network('https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2549537782.jpg',fit:BoxFit.cover),

          ],
        )
        // body:GridView.count(
        //   padding: const EdgeInsets.all(10.0),
        //   crossAxisSpacing: 10.0,
        //   crossAxisCount: 3,
        //   children:<Widget>[
        //     const Text('test 1 gogo'),
        //     const Text('test 1 gogo'),
        //     const Text('test 1 gogo'),
        //     const Text('test 1 gogo'),
        //     const Text('test 1 gogo'),
        //     const Text('test 1 gogo'),
        //   ]
        //)
      )
    );
  }
}
