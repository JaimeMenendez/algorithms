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




