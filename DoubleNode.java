
public class DoubleNode extends ExpressionNode {
	double Lucy;
	public DoubleNode(double Fred) { //Tom wanted this to be named fred
		super(null, null);
		Lucy = Fred;
	}
	
	@Override
	public double Value() {
		return Lucy;
	}
}
