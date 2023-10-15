public class instrument{
    public interface Instrument {
    void play();
}

public static class Guitar implements Instrument {
    @Override
    public void play() {
        System.out.println("Playing guitar");
    }
}

public static class Violin implements Instrument {
    @Override
    public void play() {
        System.out.println("Playing violin");
    }
}

public static class Clarinet implements Instrument {
    @Override
    public void play() {
        System.out.println("Playing clarinet");
    }
}

public static void main(String[] args) {
        Instrument guitar = new Guitar();
        Instrument violin = new Violin();
        Instrument clarinet = new Clarinet();

        guitar.play();
        violin.play();
        clarinet.play();
}

}