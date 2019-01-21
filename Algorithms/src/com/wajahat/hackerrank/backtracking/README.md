# BACKTRACKING
Backtracking is an algorithm paradigm that tries to solve a given problem (P)
with different solution (S) untill it finds a solution that works for the problem

It has the following property in common. These problems can only be solved
by trying different configurations and each configuration is tried only once.

    A naive way of doing it is to try all possible configuration and output
    a configuration that follows given problem constraint.

Backtracking works in an incremental way and is an optimization over the naive
solution where all possible configurations are generated and tried.

    BT(C)
    if reject (P, C) return
    if accept(P, C) output(P, C)
    S <- first(P, C)
    
    while S != final_solution do
        BT(C)
        S <- next(P, C)

 
   