class CountSquares:
    
    def __init__(self):
       self.d = {} 
       self.points = []
    def add(self, point: List[int]) -> None:
        self.d[tuple(point)] = self.d.get(tuple(point),0) + 1
        self.points.append(tuple(point))

    def count(self, point: List[int]) -> int:
        count = 0
        px,py = point
        for x,y in self.d:
            if y == py or px == x:
                continue
            if abs(px-x) != abs(py-y):
                continue

            count+= self.d.get((px,y),0) * self.d.get((x,py),0) * self.d.get((x,y),0) 
        return count
            
