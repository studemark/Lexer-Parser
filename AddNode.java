
public class AddNode extends ExpressionNode {
	public AddNode(ExpressionNode l, ExpressionNode r) {
		super(l, r);
	}
	
	@Override
	public double Value() {
		return leftNode.Value() + rightNode.Value();
	}
}
