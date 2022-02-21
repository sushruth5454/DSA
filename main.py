s=input()
a=s.split(',')
for i in s:
    d=set()
    for k in i:
        d.add(k)
    low=0
    n=len(d)
    result=""
    str=""
    min_len=len(i)
    temp={}
    j=0
    while(low<len(i)):
        while(len(temp)==n):
            if(temp[i[j]]>1):
                j+=1
                temp[i[j]]-=1
                str=str[j:]
                if(min_len>len(str)):
                    min_len=len(str)
                    result=str
        str+=i[low]
        if(i[low] in temp):
            temp[i[low]]+=1
        else:
            temp[i[low]]=1
    print(result)