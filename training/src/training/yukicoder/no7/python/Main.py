def isPrimeNumber(number, primeNumbers):
    for primeNumber in primeNumbers :
        if number % primeNumber == 0 :
            return False

    return True


def isLoseNumber(number, primeNumbers, loseNumbers):
    for primeNumber in primeNumbers :
        if (number - primeNumber) in loseNumbers :
            return False

    return True


def execute(number):
    primeNumbers =[]
    loseNumbers =[]

    for i in range(2, number + 1):
        if isPrimeNumber(i, primeNumbers) :
            primeNumbers.append(i)

        if isLoseNumber(i, primeNumbers, loseNumbers) :
            loseNumbers.append(i)

    if number in loseNumbers :
        return "Lose"

    return "Win"


print(execute(int(input())))