def execute(a):
    count = 0
    nums = list(map(int, a.split()))
    nums.reverse()
    for num in nums:
        if(num == max(nums)):
            nums[nums.index(max(nums))] = 0
        else:
            count = count + 1

    return count
    

a = "1 9 7 8 4 6 3 10 5 2"
print(execute(a))
