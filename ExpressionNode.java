
public abstract class ExpressionNode {
	ExpressionNode leftNode;
	ExpressionNode rightNode;
	
	public ExpressionNode(ExpressionNode l, ExpressionNode r) {
		leftNode = l;
		rightNode = r;
	}
	
	public abstract double Value();
}
