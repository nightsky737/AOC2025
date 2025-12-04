start = 50
file = open("day1.txt", "r")
line = file.readline()
count = 0
waszero = False
while line:
    if start == 0:
        waszero = True
    else:
        waszero = False
    direction = line[0]
    number = int(line[1:])
    if direction == "L":
        number = - number

    start += number
    if start == 0:
        count += 1

    if start > 0:
        count += start // 100
    if start < 0:
        if not waszero:
            count += 1
        count += - start // 100
        start += (- start // 100 + 1) * 100


    start %= 100
    line = file.readline()

print(count)
file.close()
