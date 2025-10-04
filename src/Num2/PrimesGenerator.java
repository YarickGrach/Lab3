package Num2;

import java.util.*;

public class PrimesGenerator implements Iterator<Integer> {
    private int count;
    private int current = 2;
    private int generated = 0;

    public PrimesGenerator(int count) {
        this.count = count;
    }

    private boolean isPrime(int n) {
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;

        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }

    @Override
    public boolean hasNext() {
        return generated < count;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        while (!isPrime(current)) {
            current++;
        }

        int prime = current;
        current++;
        generated++;
        return prime;
    }
}
