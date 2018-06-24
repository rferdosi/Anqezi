package General.Board;

public enum BoardColour {
    Black, White;

    @Override
    public String toString() {
        switch (this) {
            case Black:
                return "black";
            case White:
                return "white";
        }
        return null;
    }
}
