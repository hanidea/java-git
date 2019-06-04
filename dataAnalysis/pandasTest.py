#encoding=utf-8
import numpy as np
import pandas as pd


def main():
    #Data Structure
    s=pd.Series([i*2 for i in range(1,11)])
    print(type(s))
    dates=pd.date_range("20190604",periods=8)
    df=pd.DataFrame(np.random.randn(8,5),index=dates,columns=list("ABCDE"))
    print(df)
    # df=pd.DataFrame({"A":1,"B":pd.Timestamp("20190604"),"C":pd.Series(1,index=list(range(4)),dtype="float32"),\
    #                  "D":np.array([3]*4,dtype="float32"),"E":pd.Categorical(["police","student","teacher","doctor"])})
    # print(df)
    #Basic
    print(df.head(3))
    print(df.tail(3))
    print(df.index)
    print(df.values)
    print(df.T)
    print(df.sort_values('C'))
    print(df.sort_index(axis=1,ascending=False))
    print(df.describe())
    #select
    print(type(df["A"]))
    print(df[:3])
    print(df["20190604":"20190607"])
    print(df.loc[dates[0]])
    print(df.loc["20190604":"20190607",["B","D"]])
    print(df.at[dates[0],"C"])
    print(df.iloc[1:3,2:4])
    print(df.iloc[1,4])
    print(df.iat[1,4])

    print(df[df.B>0][df.A<0])
    print(df[df>0])
    print(df[df["E"].isin([1,2])])

    #Set
    s1=pd.Series(list(range(10,18)),index=pd.date_range("20190604",periods=8))
    df["F"]=s1
    print(df)
    df.at[dates[0],"A"]=0
    print(df)
    df.iat[1,1]=1
    df.loc[:,"D"]=np.array([4]*len(df))
    print(df)
    df2=df.copy()
    df2[df2>0]=-df2
    print(df2)

    



if __name__=="__main__":
    main()