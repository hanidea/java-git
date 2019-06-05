# -*- coding=UTF-8 -*-
import tensorflow as tf
# 输入数据
import input_data
mnist = input_data.read_data_sets('MNIST_data', one_hot=True)
# 定义网络超参数
