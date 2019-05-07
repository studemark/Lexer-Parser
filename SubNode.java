
public class SubNode extends ExpressionNode {
	public SubNode(ExpressionNode l, ExpressionNode r) {
		super(l, r);
	}
	@Override
	public double Value() {
		return leftNode.Value() - rightNode.Value();
	}

}
