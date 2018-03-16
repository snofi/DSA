import java.util.ArrayList;
import java.util.List;

public class Node<T> {

	private T data = null;

	private List<Node<T>> children = new ArrayList<>();

	private Node<T> parent = null;

	public Node(T data) {
		this.data = data;
	}

	public Node getRoot() {

    Node<T> tmp = this;
    while(tmp.parent!=null){
      tmp = tmp.parent;
    }
    return tmp;
	}

	public Node<T> addChild(Node<T> child) {

    this.children.add(child);
    child.setParent(this);

    return child;

	}

	public void addChildren(List<Node<T>> children) {

    this.children.addAll(children);
    for(Node<T> child: children){
      child.setParent(this);
    }

	}

	public List<Node<T>> getChildren() {

    return this.children;
	}

	public T getData() {

    return this.data;
	}

	public void setData(T data) {

    this.data = data;
	}

	private void setParent(Node<T> parent) {

    this.parent = parent;
	}

	public Node<T> getParent() {

    return this.parent;
	}

	public Node<T> findLCA(Node<T> a, Node<T> b) {
		Node<T> tmpA = a;
		Node<T> tmpB = b;
		List<Node<T>> aParents = new ArrayList<>();
		List<Node<T>> bParents = new ArrayList<>();

		while(tmpA.parent!=null){
			aParents.add(tmpA.parent);
			tmpA = tmpA.parent;
		}
		while(tmpB.parent!=null){
			bParents.add(tmpB.parent);
			tmpB = tmpB.parent;
		}

		for(Node<T> aParent: aParents){
			for(Node<T> bParent: bParents){
				if(aParent==bParent)
					return aParent;
			}
		}
		return tmpA.getRoot();
	}
}
