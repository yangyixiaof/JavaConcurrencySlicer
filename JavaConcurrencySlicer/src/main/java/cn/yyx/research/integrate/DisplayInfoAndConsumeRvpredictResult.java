package cn.yyx.research.integrate;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;

public class DisplayInfoAndConsumeRvpredictResult extends DisplayInfo {
	
	private ArrayList<String> race_list = new ArrayList<String>();
	
	public DisplayInfoAndConsumeRvpredictResult(PrintStream out) {
		super(out);
	}

	public void setIs(InputStream is) {
		this.is = is;
	}
	
	@Override
	public void HandleInformation(String oneline) {
		race_list.add(oneline);
	}

	public ArrayList<String> GetRaces() {
		return race_list;
	}
	
}
