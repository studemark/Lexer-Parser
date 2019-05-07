
public class DivNode extends ExpressionNode {
	public DivNode(ExpressionNode l, ExpressionNode r) {
		super(l, r);
	}
	
	@Override
	public double Value() {
		return leftNode.Value() / rightNode.Value();
	}

}
