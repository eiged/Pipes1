package integerpipes;

import java.util.function.BooleanSupplier;

public final class ModuloFilterPipe{
    private final int divisor;
    private MultiplyingPipe feedingPipe;

    public ModuloFilterPipe(MultiplyingPipe feedingPipe, int divisor){
        this.divisor = divisor;
        this.feedingPipe = feedingPipe;
    }

    public boolean hasNextInteger() {
        return false;
    }

    public int nextInteger() {
        return 0;
    }
}