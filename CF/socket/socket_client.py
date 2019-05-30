#导入模块
import socket

# 实例初始化
client = socket.socket()
# 访问的服务器端的ip和端口
ip_port = ("127.0.0.1",8888)
# 连接主机
client.connect(ip_port)
# 定义循环不断发送消息
while True:
    # 接收主机信息
    data = client.recv(1024)
    # 打印接收的数据
    # 此处的byte型数据特指3.x
    print(data.decode())
    # 输入发送的消息
    msg_input = input("请输入发送的消息:")
    # 消息发送
    client.send(msg_input.encode())
    if msg_input == "exit":
        break
    data = client.recv(1024)
    print(data.decode())
