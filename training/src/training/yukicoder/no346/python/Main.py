def execute(arg):
    ans = 0
    wCount = 0

    rev = list(arg)
    rev.reverse()

    for idx, s in enumerate(rev):
        if(s == "w"):
            wCount += 1

        if(s == "c"):
            ans += wCount * (wCount - 1) // 2

    return ans

arg = "cwcwcwwwcccccccccccwwwww"
print(execute(arg))
