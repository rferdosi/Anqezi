package General;

import java.io.Serializable;

public enum Side implements Serializable {
    Black, White, Automatic;

    @Override
    public String toString() {
        switch (this) {
            case White:
                return "White";
            case Black:
                return "Black";
            case Automatic:
                return "Automatic";
        }
        return null;
    }

    public Side getOtherSide() {
        if (this == Side.Black)
            return Side.White;
        else return Side.Black;
    }
}
