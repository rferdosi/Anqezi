package General.Board;

public enum Side {
    Black, White;

    @Override
    public String toString() {
        switch (this) {
            case White:
                return "white";
            case Black:
                return "black";
        }
        return null;
    }
}
