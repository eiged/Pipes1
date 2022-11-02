package integerpipes;

public final class SummationPipe {
    private int sum;
    private ModuloFilterPipe feedingPipe;

    public SummationPipe(ModuloFilterPipe feedingPipe){
        this.feedingPipe = feedingPipe;
    }

    public boolean hasNextInteger() {
        return false;
    }

    public char[] nextInteger() {
        return null;
    }

}
