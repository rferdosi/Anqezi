package General.Board;

public enum Side {
    Black, White, Random;

    @Override
    public String toString() {
        switch (this) {
            case White:
                return "white";
            case Black:
                return "black";
            case Random:
                return "random";
        }
        return null;
    }
}
