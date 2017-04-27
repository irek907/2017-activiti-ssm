package tangzongyun.activiti.sys.domain.result;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("rawtypes")
public class Dataflow  implements Serializable{
	/** 数组 */
	private Map map;

	public Dataflow() {
		map = new HashMap();
	}

	public Map getMap() {
		return map;
	}

	public void setMap(Map map) {
		this.map = map;
	}

	@SuppressWarnings("unchecked")
	public void putMap(String parm, Object o) {
		map.put(parm, o);
	}

}
