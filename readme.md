# Algorithms and Data Structures

This repository contains my own implementation of some algorithms and data structures in java. Each implementation is
tested with JUnit 5.

The code is documented using Javadoc and each algorithm is separated by type in his own module.

## Union–Find data structure

**Disjoint-set data structure**, also called a **union–find data structure** or **merge–find set** is defined by the **
UF** interface with methods:

- `boolean isConnected(int p, int q);`
- `void union(int p, int q)`

This interface is the base of the implementation of **WeightedQuickUnion**, **QuickFind** and **QuickUnion**.

### Implementations for Union–Find

| Method/Implementation | initialize | union    | isConnected |
|-----------------------|------------|----------|-------------|
| QuickFind             | O(n)       | O(n)     | O(1)        |
| QuickUnion            | O(n)       | O(n)     | O(n)        |
| WeightedQuickUnion    | O(n)       | O(log n) | O(log n)    |

## Sorting Algorithms
Sorting Algorithms are methods of reorganizing a large number of items into some specific order.

These algorithms take an input array, processes it and produce the sorted list.

### Merge Sort
It divides the input array into two halves, calls itself for the two halves, and then merges the two sorted halves.\
The merge() function is used for merging two halves. It is a key process that assumes that lef[] and right[] are sorted 
and merges the two sorted sub-arrays into one. 

Merge Sort has complexity **O(n log n)** in all the 3 cases (worst, average and best) 
as the mergesort always divides the array into two halves and takes linear time to merge two halves.

