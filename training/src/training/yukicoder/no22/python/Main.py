def execute(msg, length, targetIndex):
    stack = []
    ans = []

    for idx, s in enumerate(list(msg)):
        if(s == "("):
            stack.append(idx)
        elif(s == ")"):
            ans = [stack.pop() + 1, idx + 1]

        if(len(ans) == 0):
            continue

        if(ans[0] == targetIndex):
            return ans[1]
        elif(ans[1] == targetIndex):
            return ans[0]

msg = "(())"
length = 4
targetIndex = 4
    
print(execute(msg, length,targetIndex))

