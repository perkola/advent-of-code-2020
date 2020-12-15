with open('input') as f:
    numbers = [int(n) for n in f.readlines()[0].split(',')]

def find_number(n):
    last = 0
    spoken = {}
    for i in range(1, n+1):
        if i <= len(numbers):
            last = numbers[i-1]
            spoken[numbers[i-1]] = [i]
        else:
            n = 0
            if len(spoken[last]) > 1:
                n = spoken[last][1] - spoken[last][0]
            if spoken.get(n):
                if len(spoken[n]) > 1:
                    spoken[n].pop(0)
                spoken[n].append(i)
            else:
                spoken[n] = [i]
            last = n
    return last

print('part 1: ', find_number(2020))
print('part 2: ', find_number(30000000))
