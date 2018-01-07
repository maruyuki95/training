def execute(arg):
    ans = 0
    cIndex = []
    wIndex = []

    for idx, s in enumerate(arg):
        if(s == "c"):
            cIndex.append(idx)

        if(s == "w"):
            if(len(cIndex) > 0 and len(wIndex) > 0):
                for c in cIndex:
                    for w in wIndex:
                        if(c < w):
                            ans+=1

            wIndex.append(idx)

    return ans

arg = "cwcwcwwwcccccccccccwwwww"
print(execute(arg))
