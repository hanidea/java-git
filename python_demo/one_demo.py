import jieba

str = "我在网上课"

res = ''.join(jieba.cut(str))

print(res)
