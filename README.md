** To preview the code, use the "src" folder **





# Fire spread #
 
<img src="https://github.com/Chameleon-7/Forest_Project/blob/master/Fire%20Spread.png" width="400" height="300">



## Forest density as a factor ##

The first task was to model a forest of d density. We modelled a forest as a 2D array. Each cell can either be occupied by a tree, or can be empty. For a value v (between 0.0 and 1.0), we said that a forest has density d if each cell is a tree with probability p, or empty with probability (1 - p).

For example:

* A forest with density 0.0 has no trees (every cell is empty with 100% probability).
* A forest with density 0.5 has roughly half of its cells filled with trees (each cell contains a tree with 50% probability).
* A forest with density 1.0 has every cell occupied by a tree (every cell contains a tree with 100% probability).

## Algorithm Usage ##
DFS (depth-first search) and BFS (breadth-first search) algorithms were used and compared to determine which would result in a faster fire spread in the simulated forest. Density was also taken into factor. 

Other tasks in this assignment included:

* Finding the probability of fire spread given x density and calculing the optimal maximum density for fullest fire spread.
* Comparing the running time of the two different algorithms and explain why is one faster than another
