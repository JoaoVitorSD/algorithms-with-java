package algorithmsapi.bst;

public class Node {
    public Node left, right;


    private Long value;

    public Long getValue() {
        return value;
    }

    public Node(Long value){
        this.value = value;
        left = right = null;
    }

}
