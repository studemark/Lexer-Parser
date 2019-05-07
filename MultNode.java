
public class MultNode extends ExpressionNode {
	public MultNode (ExpressionNode l, ExpressionNode r) {
		super(l, r);
	}
	
	@Override
	public double Value() {
		return leftNode.Value() * rightNode.Value();
	}
}
