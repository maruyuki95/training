def execute(arg):
    ans = -1
    cIndex = []
    wIndex = []

    for idx, s in enumerate(arg):
        if(s == "c"):
            cIndex.insert(0, idx)

        if(s == "w"):
            if(len(cIndex) > 0 and len(wIndex) > 0):
                wLast = wIndex[0]

                for cIdx in cIndex:
                    if(cIdx > wLast):
                        continue

                    length = idx - cIdx + 1
                    if(ans == -1 or ans > length):
                        ans = length
                        break
                
            wIndex.insert(0, idx)

    return ans


arg = "ilovechiwawa"
print(execute(arg))
