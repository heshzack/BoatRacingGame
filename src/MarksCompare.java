import java.util.Comparator;
public class MarksCompare implements Comparator<TopFive> {

	@Override
	public int compare(TopFive m1, TopFive m2) {
		return m2.mark - m1.mark;
	}
	
}
