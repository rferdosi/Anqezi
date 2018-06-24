package General.Board;

public enum Side {
    Black, White;

    @Override
    public String toString() {
        switch (this) {
            case White:
                return "black";
            case Black:
                return "white";
        }
        return null;
    }
}
