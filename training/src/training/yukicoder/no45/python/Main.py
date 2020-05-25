def calculateMaxTasteSum(tastes):
    lastOnMaxTasteSum = 0
    lastOffMaxTasteSum = 0

    for taste in tastes:
        lastOnMaxTasteSum, lastOffMaxTasteSum = (lastOffMaxTasteSum + taste), max(lastOnMaxTasteSum, lastOffMaxTasteSum)

    return max(lastOnMaxTasteSum, lastOffMaxTasteSum)


if __name__ == "__main__" :
    sushiNum = input()
    sushiTastes = list(map(int, input().split()))
    print(calculateMaxTasteSum(sushiTastes))
