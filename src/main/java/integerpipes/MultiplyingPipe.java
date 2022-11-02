package integerpipes;

public final class MultiplyingPipe{
    final private int factor;
    private Feeder pipe;
    public MultiplyingPipe( Feeder feedingPipe, int factor ){
        this.factor = factor;
        this.pipe = feedingPipe;
    }
}