package integerpipes;
public final class Feeder {
    int[] array;

    public Feeder(int[] integers){
        this.array = integers;
    }

    public boolean hasNextInteger(){
        return false;
    }

    public int nextInteger(){
        return 0;
    }
}
