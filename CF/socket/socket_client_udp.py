#导入模块
import socket
#定义实例
sk = socket.socket(socket.AF_INET,socket.SOCK_DGRAM)
#定义需要连接的服务器的ip和port
ip_port = ("127.0.0.1",8888)
#循环数据的输入
while True:
    # 输入发送的信息
    msg_input = input("请输入发送的消息:")
    # 退出循环条件
    if msg_input == "exit":
        break
    #数据发送
    sk.sendto(msg_input.encode(),ip_port)
#发送关闭信息
sk.close()