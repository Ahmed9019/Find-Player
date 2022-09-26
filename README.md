# Find Player

Provide a solution class to IPlayersFinder interface.

## Input Format

First line contains a comma-separated list of the board dimenstions(rows, colums). The board rows are then printed in order. Next line contains the team indetifier. Last line contains the minimum area for an element.

## Constraints

Dimensions of the photo will be between 1 and 50 elements. Minimum area for an element will be between 1 and 10000 inclusive.

## Output Format 

Comma-separated list of points of team locations.

## Input and Output Samples

|N| Input | Output |
|--|-------|--------|
|1|15, 15<br>8D88888J8L8E888<br>88NKMG8N8E8JI88<br> 888NS8EU88HN8EO<br> LUQ888A8TH8OIH8<br> 888QJ88R8SG88TY<br> 88ZQV88B88OUZ8O<br>FQ88WF8Q8GG88B8<br>8S888HGSB8FT8S8<br>8MX88D88888T8K8<br>8S8A88MGVDG8XK8<br>M88S8B8I8M88J8N<br>8W88X88ZT8KA8I8<br>88SQGB8I8J88W88<br>U88H8NI8CZB88B8<br>8PK8H8T8888TQR8<br>8<br>9|[(1, 17), (3, 3), (3, 10), (3, 25), (5, 21), (8, 17), (9, 2), (10, 9), (12, 23), (17, 16), (18, 3), (18, 11), (18, 28), (22, 20), (23, 26), (24, 15), (27, 2), (28, 26), (29, 16)]|
|2|6, 8<br>33JUBU33<br>3U3O4433<br>O33P44NB<br>PO3NSDP3<br>VNDSD333<br>OINFD33X<br>3<br>16|[(4, 5), (13, 9), (14, 2)]|