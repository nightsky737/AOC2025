start = 50
file = open("day2.txt", "r")
line = file.readline()
ranges = line.split(",")

def isRepeating(number):
    number = str(number)
    for i in range(len(number) - 1):

        if len(number) % (i + 1) != 0:
            continue
        else:

            if number[:i + 1] * int(len(number)/ (i + 1)) == number:
                return True
    return False
    # if len(number) % 2 == 1:
    #     return False
    # return number == number[: int(len(number) / 2)] * 2
sum = 0

for i in range(len(ranges)):
    cur_range = ranges[i].split("-")
    for cand in range(int(cur_range[0]), int(cur_range[1]) + 1):
        if isRepeating(cand):
            sum += cand

print(sum)
file.close()
