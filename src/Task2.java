public class Task2 {
}

//BFS Trace from Node A:

//Start at A
//Enqueue neighbors of A: C, B, D
//Dequeue C, and enqueue its unvisited neighbors (none left unvisited)
//Dequeue B, and enqueue its unvisited neighbors: E, G
//Dequeue D, and enqueue its unvisited neighbors (none left unvisited)
//Dequeue E, and enqueue its unvisited neighbors: F
//Dequeue G, and enqueue its unvisited neighbors (none left unvisited)
//Dequeue F, and enqueue its unvisited neighbors (none left unvisited)

//Order of Visits: (A, C, B, D, E, G, F)