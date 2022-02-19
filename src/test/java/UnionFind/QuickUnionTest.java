package UnionFind;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Random;
import java.util.stream.Stream;

class UnionFindTest {

    public static Stream<Arguments> provider() {
        int n = 10;
        return Stream.of(
                Arguments.of(new WeightedQuickUnion(n), n),
                Arguments.of(new QuickFind(n), n),
                Arguments.of(new QuickUnion(n), n)
        );
    }

    @DisplayName("Each node should be connected with itself")
    @ParameterizedTest
    @MethodSource("provider")
    void nodeConnectionWithItself(UF uf, int n) {
        for (int i = 0; i < n; i++) {
            Assertions.assertTrue(uf.isConnected(n - 1, n - 1));
        }
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> uf.isConnected(n, n));
    }

    @ParameterizedTest
    @MethodSource("provider")
    @DisplayName(" should throw IndexOutOfBoundsException if n>= 0 or n <= 0")
    void outOfBoundsException(UF uf, int n) {
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> uf.isConnected(n, n));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> uf.isConnected(-1, -1));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> uf.isConnected(0, -1));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> uf.isConnected(-1, 0));

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> uf.union(-1, -1));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> uf.union(0, -1));
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> uf.union(-1, 0));
    }

    @ParameterizedTest
    @MethodSource("provider")
    @DisplayName("Union operation should connect two nodes")
    void boundsException(UF uf, int n) {
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            int p = random.nextInt(n);
            int q = random.nextInt(n);
            uf.union(p, q);
            Assertions.assertTrue(uf.isConnected(p, q));
        }
    }

    @ParameterizedTest
    @MethodSource("provider")
    @DisplayName("Any node should not be connected when the object is created.")
    void notConnectionsOnStart(UF uf, int n) {
        for (int i = 1; i < n; i++) {
            Assertions.assertFalse(uf.isConnected(0, i));
            Assertions.assertFalse(uf.isConnected(i, 0));
        }
    }

    @ParameterizedTest
    @MethodSource("provider")
    @DisplayName("Union operation should be transitive.")
    void unionShouldBeTransitive(UF uf, int n) {
        uf.union(0, 1);
        uf.union(1, 3);
        Assertions.assertTrue(uf.isConnected(0, 3));

        uf.union(2, 4);
        uf.union(4, 3);
        uf.union(n - 1, 3);
        Assertions.assertTrue(uf.isConnected(0, 4));
        Assertions.assertTrue(uf.isConnected(1, 2));
        Assertions.assertTrue(uf.isConnected(1, 4));
        Assertions.assertTrue(uf.isConnected(1, n - 1));
    }

    @ParameterizedTest
    @MethodSource("provider")
    @DisplayName("Union should be reflexive.")
    void unionShouldBeReflexive(UF uf, int n) {
        uf.union(0, 1);
        Assertions.assertTrue(uf.isConnected(0, 1));
        Assertions.assertTrue(uf.isConnected(1, 0));

        uf.union(2, 4);
        Assertions.assertTrue(uf.isConnected(2, 4));
        Assertions.assertTrue(uf.isConnected(4, 2));

        uf.union(0, n - 1);
        Assertions.assertTrue(uf.isConnected(0, n - 1));
        Assertions.assertTrue(uf.isConnected(n - 1, 0));
    }
}