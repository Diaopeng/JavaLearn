package Concurency.java;

import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicReference;

public class Chapter2 {
    private final AtomicReference<BigInteger> lastNumber
            = new AtomicReference<BigInteger>();
    private final AtomicReference<BigInteger[]> lastFactors
            = new AtomicReference<BigInteger[]>();

    // V1 share mutable status BigInteger[] factor still can have concurrency issue
    // all access including read and write are guarded by the lock
    public BigInteger[] service(BigInteger i) {
        if (i.equals(lastNumber.get())){
            return lastFactors.get();
        }
        else {
            BigInteger[] factors = calCulateFactor(i);
            lastNumber.set(i);
            lastFactors.set(factors);
            return factors;
        }
    }
    public BigInteger[] calCulateFactor(BigInteger i){
        // do the calculation
        return new BigInteger[10];
    }


    public synchronized BigInteger[] serviceSync(BigInteger i) {
        if (i.equals(lastNumber.get())){
            return lastFactors.get();
        }
        else {
            BigInteger[] factors = calCulateFactor(i);
            lastNumber.set(i);
            lastFactors.set(factors);
            return factors;
        }
    }
}
