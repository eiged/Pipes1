package integerpipes;

public abstract class Pipe {
    Pipe feedingPipe;

    public Pipe(Pipe feedingPipe){
        this.feedingPipe = feedingPipe;
    }

    final protected Pipe getFeedingPipe(){
        return feedingPipe;
    }

    abstract boolean hasNextInteger();

    abstract int nextInteger();
}
