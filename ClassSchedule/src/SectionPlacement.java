import java.util.ArrayList;
import java.util.List;
import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty;
import org.optaplanner.core.api.domain.solution.PlanningScore;
import org.optaplanner.core.api.domain.solution.PlanningSolution;
import org.optaplanner.core.api.domain.solution.drools.ProblemFactCollectionProperty;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;

//Planning Solution Class so OptaPlanner knows this contains all input and outputs
@PlanningSolution
public class SectionPlacement {
	
	//Variable Instances
	private List<Room> roomList;
	private List<Section> sectionList;
	private HardSoftScore score;
	
	//No-Arg Constructor for Optaplanner
	public SectionPlacement() {
		roomList = new ArrayList<>();
		sectionList = new ArrayList<>();
	}
	
	//Overload Constructor
	public SectionPlacement(List<Room> rL, List<Section> sL){
		this.roomList = rL;
		this.sectionList = sL;
	}
	//Annotation for Optaplanner to select these rooms during runtime
	@ValueRangeProvider(id = "roomRange")
	@ProblemFactCollectionProperty
	public List<Room> getRoomList(){
		return roomList;
	}
	
	//Getter for the list of Sections
	@PlanningEntityCollectionProperty
	public List<Section> getSectionList() {
		return sectionList;
	}
	//Annotate to use this for the score
	@PlanningScore
	//Getter for the Score
	public HardSoftScore getScore() {
		return score;
	}
	
	//Setter for score
	public void setScore(HardSoftScore score){
		this.score = score;
	}
	
}
