# coding=utf8
import numpy as np
from numpy import *

import matplotlib
import matplotlib.pyplot as plt

#中文显示
import matplotlib.font_manager as fm
#解决中文乱码
myfont = fm.FontProperties(fname='simsun.ttc')

'''创建数据源，返回数据集和类标签'''
def creat_dataset():
    datasets = array([[8,4,2],[7,1,1],[1,4,4],[3,0,5],])
    labels = ['非常热','非常热','一般热','非常热']
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
def knn_Classifier():
    # 1.获取新的样本数据
    # 2.获取样本库的数据
    # 3.选择k值
    # 4.计算之间的距离
    # 5.根据距离排序
    # 6.根据


if __name__ == '__main__':
    #1 创建数据集和类标签
    datasets,labels = creat_dataset()
    print('数据集:\n',datasets,'\n类标签:\n',labels)

    #2 可视化分析数据
    analyze_data_plot(datasets[:,0],datasets[:,1])