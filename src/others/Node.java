package others;

import javafx.scene.image.ImageView;

public class Node {
    private Node upNode;
    private Node downNode;
    private Node rightNode;
    private Node leftNode;
    private Side side;
    //    private int row;
//    private int column;
    private ImageView imageView;

    public void setDownNode(Node downNode) {
        this.downNode = downNode;
        downNode.upNode = this;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
        rightNode.leftNode = this;
    }

    /*  public int getRow() {
          return row;
      }

      public void setRow(int i) {
          this.row = i;
      }

      public int getColumn() {
          return column;
      }

      public void setColumn(char j) {
          this.column = j;
      }
  */
    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    public void setSide(Side side) {
        this.side = side;
    }
}

