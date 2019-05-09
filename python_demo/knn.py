# coding=utf8
import numpy as np
from numpy import *

import matplotlib
import matplotlib.pyplot as plt

import math

#中文显示
import matplotlib.font_manager as fm
#解决中文乱码
myfont = fm.FontProperties(fname='simsun.ttc')

'''创建数据源，返回数据集和类标签'''
def creat_dataset():
    datasets = array([[8,4,2],[7,1,1],[1,4,4],[3,0,5],])
    labels = ['非常热','非常热','一般热','一般热']
    return datasets,labels

'''创建数据源，返回数据集和类标签'''
def creat_datasets():
    datasets = array([[8,4,2],[7,1,1],[1,4,4],[3,0,5],[9,4,2],[7,0,1],[1,5,4],[4,0,5],])
    labels = [0,0,1,1,0,0,1,1]
    return datasets,labels

'''可视化分析数据'''
def analyze_data_plot(x,y):
    fig = plt.figure()
    # 将画布划分1行1列1块
    ax = fig.add_subplot(111)
    ax.scatter(x,y)
    # plt.scatter(x,y)
    # 设置散点图标题和横纵坐标
    plt.title("冷热感知点散点图",fontsize=25,fontname='宋体',fontproperties=myfont)
    plt.xlabel("天热吃冰激凌数目",fontsize=15,fontname='宋体',fontproperties=myfont)
    plt.ylabel("天热喝水数目", fontsize=15, fontname='宋体', fontproperties=myfont)
    #保存截图
    plt.savefig('datasets_plot.png',bbox_inches='tight')
    plt.show()

'''构造KNN分类器'''
def knn_Classifier(newV,datasets,labels,k):
    import operator
    # 1.获取新的样本数据
    # 2.获取样本库的数据
    # 3.选择k值
    # 4.计算之间的距离
    SqrtDist = EuclideanDistance3(newV,datasets)
    # print(SqrtDist)
    # 5.根据距离排序,列向量排序
    sortdDistIndexs = SqrtDist.argsort(axis=0)
    # print(sortdDistIndexs)
    # 6.针对k个点，统计各个类别数量
    classCount = {} #统计各个类别分别的数量
    for i in range(k):
        #根据距离排序索引值找到类标签
        votelabel = labels[sortdDistIndexs[i]]
        # print(sortdDistIndexs[i],votelabel)
        # 统计类标签的键值对
        classCount[votelabel]=classCount.get(votelabel,0)+1
    # print(classCount)
    # 7.投票机制，少数服从多数原则,输入类别
    sortedClassCount = sorted(classCount.items(),key=operator.itemgetter(1),reverse=True)
    # print(newV,'KNN投票预测结果:',sortedClassCount[0][0])
    return sortedClassCount[0][0]
'''欧式距离计算d2=(x1-x2)2+(y1-y2)2'''
# def ComputeEuclideanDistance(x1,y1,x2,y2):
#     d = math.sqrt(math.pow((x1-x2),2)+math.pow((y1-y2),2))
#     return d

'''欧式距离计算d2=(x1-x2)2+(y1-y2)2'''
# def EuclideanDistance(instance1,instance2,length):
#     d=0
#     for x in range(length):
#         d+= pow((instance1[x]-instance2[x]),2)
#     return math.sqrt(d)

'''欧式距离计算d2=(x1-x2)2+(y1-y2)2'''
def EuclideanDistance3(newV,datasets):
    # 1获取数据向量的行向量维度和纵向量维度
    rowsize,colsize = datasets.shape
    # print(tile(newV,(rowsize,1)))
    # 2各特征向量间作差值
    diffMat = tile(newV,(rowsize,1))-datasets
    # print(diffMat)
    # 3对差值平方
    sqDiffMat = diffMat ** 2
    # print(sqDiffMat)
    # 4差值平方和进行开方
    SqrtDist = sqDiffMat.sum(axis = 1) ** 0.5
    # print(SqrtDist)
    return SqrtDist

'''利用KNN分类器预测随机访客天气感知度'''
def Predict_temperature():
    #1 创建数据集和类标签
    datasets,labels = creat_dataset()
    #2 采访新游客
    iceCream = float(input("Q:今天吃了几个冰激凌？\n"))
    drinkWater = float(input("Q:今天喝了几杯水？\n"))
    playAct = float(input("Q:今天户外玩了多久？\n"))

    newV = array([iceCream,drinkWater,playAct])
    res = knn_Classifier(newV,datasets,labels,3)
    print("该访客认为天气是:",res)




if __name__ == '__main__':
    #1 创建数据集和类标签
    # datasets,labels = creat_dataset()
    # print('数据集:\n',datasets,'\n类标签:\n',labels)

    #2 可视化分析数据
    # analyze_data_plot(datasets[:,0],datasets[:,1])

    #3.1欧式距离计算
    # d = ComputeEuclideanDistance(2,4,8,2)
    # print(d)

    #3.2欧式距离计算
    # d2 = EuclideanDistance([2,4,4],[8,2,2],3)
    # print(d2)

    # 3.3欧式距离计算
    # EuclideanDistance3([2, 4, 4],datasets)

    #KNN分类器
    #单实例
    # newV = [2,4,4]
    # res = knn_Classifier(newV,datasets,labels,3)
    #批量构造
    # vecs = array([[2,4,4],[3,0,0],[5,7,2]])
    # for vec in vecs:
    #     res = knn_Classifier(vec,datasets,labels,3)
    #     print(vec,'KNN:',res)
    Predict_temperature()