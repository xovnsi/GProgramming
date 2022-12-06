package Model.BigNode;
import Model.Node;
import java.util.ArrayList;

public interface HasScope {
    public int indentCounter = 0;

    ArrayList<Node> getChildrenAsNodesWithEmpty();

    public default void reCalculateIndent() {
        this.setIndent(this.getParentIndent() + 1);
    }
    public abstract void setIndent(int toSet);
    public abstract int getParentIndent();
    public abstract int getIndent();

}
