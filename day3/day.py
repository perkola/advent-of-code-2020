with open('input') as f:
    grid = [[c for c in line if c != '\n'] for line in f.readlines()]

slopes = [(1, 1), (3, 1), (5, 1), (7, 1), (1, 2)]

ttrees = 0

for pair in slopes:
    down_tot = len(grid)
    trees = 0
    right = 0
    down = 0
    while down_tot > 0:
        if (grid[down][right] == '#'):
            trees += 1
        down += pair[1]
        right += pair[0]
        if right >= len(grid[0]):
            right -= len(grid[0])
        down_tot = down_tot - pair[1]
    print(trees)
    if ttrees != 0:
        ttrees *= trees
    else:
        ttrees = trees

print(ttrees)