# coding=utf8

from sklearn import neighbors
from numpy import *

import knn as KNN

def knn_sklearn_predict(newV,datasets,labels):
    #调用机器学习库knn分类器算法
    knn= neighbors.KNeighborsClassifier()
    #传参数，特征数据，分类
    knn.fit(datasets,labels)
    #knn预测
    predictRes = knn.predict([newV])

    print('访客认为的天气是:\t','非常热' if predictRes[0]==0 else '一般热')
    return predictRes


def Predict_temperature():
    #1 创建数据集和类标签
    datasets, labels = KNN.creat_datasets()
    #2 采访新游客
    iceCream = float(input("Q:今天吃了几个冰激凌？\n"))
    drinkWater = float(input("Q:今天喝了几杯水？\n"))
    playAct = float(input("Q:今天户外玩了多久？\n"))

    newV = array([iceCream,drinkWater,playAct])
    knn_sklearn_predict(newV,datasets,labels)



if __name__ == '__main__':
    Predict_temperature()