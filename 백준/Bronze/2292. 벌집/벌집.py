n=int(input())

result=0
i=1
n=n-1
if n==0:
   answer=0
else:
    while result<=n:
        result+=6*i
        if result>=n:
            answer=i
            break
        else:
            i+=1


print(answer+1) 