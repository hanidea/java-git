#导入模块
import socket
#创建实例
sk = socket.socket(socket.AF_INET,socket.SOCK_DGRAM)
#定义绑定ip和port
ip_port=("127.0.0.1",8888)
#绑定监听
sk.bind(ip_port)
#不断循环接受数据
while True:
    #接受数据
    data = sk.recv(1024)
    #打印数据
    print(data.decode())



